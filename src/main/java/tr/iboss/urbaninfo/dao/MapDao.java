package tr.iboss.urbaninfo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tr.iboss.constant.MapConstants;
import tr.iboss.urbaninfo.dao.extractor.FeatureDefaultListExtractor;
import tr.iboss.urbaninfo.dao.extractor.FeatureWithRoadInfoListExtractor;
import tr.iboss.urbaninfo.dao.extractor.PoiListExtractor;
import tr.iboss.urbaninfo.geojson.Feature;

@Repository
public class MapDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_DEFAULT = "select id, name, st_asgeojson(geom) as geom from ";
	private final String SQL_WITH_ROAD = "select id, name, road_id, st_asgeojson(geom) as geom from ";
	
	public List<Feature> listDistricts() {
		return this.jdbcTemplate.query(this.SQL_DEFAULT + MapConstants.DISTRICT_TABLE_NAME, 
				new FeatureDefaultListExtractor() {});
	}

	public List<Feature> listParcels() {
		return this.jdbcTemplate.query(this.SQL_WITH_ROAD + MapConstants.PARCEL_TABLE_NAME, 
				new FeatureWithRoadInfoListExtractor() {});
	}

	public List<Feature> listPois() {
		return this.jdbcTemplate.query("select id, name, type, subtype, st_asgeojson(geom) as geom from " +
				MapConstants.POI_TABLE_NAME, 
				new PoiListExtractor() {});
	}

	public List<Feature> listRoads() {
		return this.jdbcTemplate.query(this.SQL_DEFAULT + MapConstants.ROAD_TABLE_NAME, 
				new FeatureDefaultListExtractor() {});
	}
}
