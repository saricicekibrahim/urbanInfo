package tr.iboss.urbaninfo.dto;

public class BuildingDto {
 
    private Integer id;
    private String number;
    private String name;
    private Integer parcelId;
    private Integer roadId;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer argId) {
		this.id = argId;
	}
	public String getNumber() {
		return this.number;
	}
	public void setNumber(String argNumber) {
		this.number = argNumber;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String argName) {
		this.name = argName;
	}
	public Integer getParcelId() {
		return this.parcelId;
	}
	public void setParcelId(Integer argParcelId) {
		this.parcelId = argParcelId;
	}
	public Integer getRoadId() {
		return this.roadId;
	}
	public void setRoadId(Integer argRoadId) {
		this.roadId = argRoadId;
	}
}