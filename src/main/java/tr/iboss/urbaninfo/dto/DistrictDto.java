package tr.iboss.urbaninfo.dto;

public class DistrictDto {
 
    private Integer id;
    private String name;
    private String geometry;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer argId) {
		this.id = argId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String argName) {
		this.name = argName;
	}
	public String getGeometry() {
		return this.geometry;
	}
	public void setGeometry(String argGeometry) {
		this.geometry = argGeometry;
	}
}