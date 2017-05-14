package tr.iboss.urbaninfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tr.iboss.urbaninfo.dto.BuildingDto;

@Service
public class BuildingService {

	public List<BuildingDto> getWithLimit() {
		List<BuildingDto> buildingList = new ArrayList<BuildingDto>();
		BuildingDto buildingDto = new BuildingDto();
		buildingDto.setId(5);
		buildingDto.setName("Uysal Apt.");
		
		buildingList.add(buildingDto);
		
		buildingDto = new BuildingDto();
		buildingDto.setId(6);
		buildingDto.setName("Bahçesaray Apt.");
		
		buildingList.add(buildingDto);
		return buildingList;
	}

}
