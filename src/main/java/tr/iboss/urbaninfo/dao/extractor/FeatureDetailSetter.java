package tr.iboss.urbaninfo.dao.extractor;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tr.iboss.urbaninfo.geojson.Geometry;
import tr.iboss.urbaninfo.geojson.Properties;
import tr.iboss.urbaninfo.geojson.PropertiesDefault;
import tr.iboss.urbaninfo.geojson.PropertiesWithRoad;

@Service
public class FeatureDetailSetter {
	@Autowired
	private Logger logger;

	public Properties propertyDefaultSetter(ResultSet argRs) {
		PropertiesDefault properties = new PropertiesDefault();
		try {
			properties.setId(argRs.getInt("id"));
			properties.setName(argRs.getString("name"));
		} catch (SQLException e) {
			this.logger.error(e.getMessage());
		}

		return properties;
	}
	
	public Properties propertyWithRoadSetter(ResultSet argRs) {
		PropertiesWithRoad properties = new PropertiesWithRoad();
		try {
			properties.setId(argRs.getInt("id"));
			properties.setName(argRs.getString("name"));
			properties.setRoadId(argRs.getInt("road_id"));
		} catch (SQLException e) {
			this.logger.error(e.getMessage());
		}

		return properties;
	}
	
	public Geometry geometrySetter(ResultSet argRs) {
		Geometry geometry = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			geometry = mapper.readValue(argRs.getString("geom"), Geometry.class);

		} catch (JsonParseException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return geometry;
	}
}
