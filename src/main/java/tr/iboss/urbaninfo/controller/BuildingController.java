package tr.iboss.urbaninfo.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tr.iboss.urbaninfo.dto.BuildingDto;
import tr.iboss.urbaninfo.service.BuildingService;
 
@RestController
public class BuildingController {
	
	@Autowired
	BuildingService buildingService;
 
    @ApiOperation(value = "getWithLimit", nickname = "getWithLimit")
    @RequestMapping(method = RequestMethod.GET, path="/buildings", produces = "application/json")
    public List<BuildingDto> getWithLimit() {
    	return this.buildingService.getWithLimit();
    }
}