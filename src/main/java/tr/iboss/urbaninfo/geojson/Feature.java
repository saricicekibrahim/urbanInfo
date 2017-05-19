package tr.iboss.urbaninfo.geojson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature {

	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("geometry")
	@Expose
	private String geometry;
	@SerializedName("properties")
	@Expose
	private Properties properties;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGeometry() {
		return geometry;
	}

	public void setGeometry(String geometry) {
		this.geometry = geometry;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}