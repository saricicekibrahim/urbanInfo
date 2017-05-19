package tr.iboss.urbaninfo.geojson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class Properties {
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("id")
	@Expose
	private Integer id;

	public String getName() {
		return this.name;
	}

	public void setName(String argName) {
		this.name = argName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer argId) {
		this.id = argId;
	}
}