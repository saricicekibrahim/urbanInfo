package tr.iboss.urbaninfo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.iboss.urbaninfo.dao.extractor.FeatureDefaultListExtractor;
import tr.iboss.urbaninfo.dao.extractor.FeatureWithRoadInfoListExtractor;
import tr.iboss.urbaninfo.geojson.Feature;

@Repository
public class MapDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_DEFAULT = "select id, name, st_asgeojson(geom) as geom from ";
	private final String SQL_WITH_ROAD = "select id, name, road_id, st_asgeojson(geom) as geom from ";
	
	public List<Feature> listDistricts() {
		return this.jdbcTemplate.query(this.SQL_DEFAULT + "district", 
				new FeatureDefaultListExtractor() {});
	}

	public List<Feature> listParcels() {
		return this.jdbcTemplate.query(this.SQL_WITH_ROAD + "parcel", 
				new FeatureWithRoadInfoListExtractor() {});
	}
}
