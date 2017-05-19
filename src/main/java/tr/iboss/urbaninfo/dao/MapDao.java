package tr.iboss.urbaninfo.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tr.iboss.constant.MapConstants;
import tr.iboss.urbaninfo.geojson.DistrictProperties;
import tr.iboss.urbaninfo.geojson.Feature;
import tr.iboss.urbaninfo.geojson.Geometry;

@Repository
public class MapDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    @Autowired
    private Logger logger;

	public List<Feature> listDistricts() {
		return this.jdbcTemplate.query("select id, name, st_asgeojson(geom) as geom from district", new ResultSetExtractor<List<Feature>>() {
			@Override
			public List<Feature> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Feature> featureList = new ArrayList<Feature>();
				while (rs.next()) {
					DistrictProperties properties = new DistrictProperties();
					Feature feature = new Feature();
					properties.setId(rs.getInt("id"));
					properties.setName(rs.getString("name"));
					
					Geometry geometry = null;
					try {
					    ObjectMapper mapper = new ObjectMapper();
					    geometry = mapper.readValue(rs.getString("geom"), Geometry.class);
						
					} catch (JsonParseException e) {
						logger.error(e.getMessage());
					} catch (JsonMappingException e) {
						logger.error(e.getMessage());
					} catch (IOException e) {
						logger.error(e.getMessage());
					}
					
					feature.setGeometry(geometry);
					feature.setProperties(properties);
					feature.setType(MapConstants.FEATURE);
					featureList.add(feature);
				}
				return featureList;
			}
		});
	}
}
