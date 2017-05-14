package tr.iboss.urbaninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.iboss.urbaninfo.dao.BuildingDao;
import tr.iboss.urbaninfo.dto.BuildingDto;

@Service
public class BuildingService {
	
	@Autowired
	BuildingDao buildingDao;

	public List<BuildingDto> getWithLimit() {
		return this.buildingDao.getWithLimit();
	}

}
