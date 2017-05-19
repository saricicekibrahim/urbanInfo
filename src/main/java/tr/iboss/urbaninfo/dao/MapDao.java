package tr.iboss.urbaninfo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import tr.iboss.constant.MapConstants;
import tr.iboss.urbaninfo.geojson.Feature;
import tr.iboss.urbaninfo.geojson.Properties;

@Repository
public class MapDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Feature> getAllDistricts() {
		return this.jdbcTemplate.query("select id, name, st_asgeojson(geom) as geom from building", new ResultSetExtractor<List<Feature>>() {
			@Override
			public List<Feature> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Feature> featureList = new ArrayList<Feature>();
				while (rs.next()) {
					Properties properties = new Properties();
					Feature feature = new Feature();
					properties.setId(rs.getInt("id"));
					properties.setName(rs.getString("name"));
					feature.setGeometry(rs.getString("geom"));
					feature.setProperties(properties);
					feature.setType(MapConstants.FEATURE);
					featureList.add(feature);
				}
				return featureList;
			}
		});
	}
}
