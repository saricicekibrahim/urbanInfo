package tr.iboss.urbaninfo.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tr.iboss.urbaninfo.geojson.GeojsonCreator;
import tr.iboss.urbaninfo.service.MapService;
 
@RestController
public class MapController {
	
	@Autowired
	MapService mapService;
 
    @ApiOperation(value = "list all districts", nickname = "list all districts")
    @RequestMapping(method = RequestMethod.GET, path="/districts", produces = "application/json")
    public GeojsonCreator listDistricts() {
    	return this.mapService.listDistricts();
    }
    
    @ApiOperation(value = "list all parcels", nickname = "list all parcels")
    @RequestMapping(method = RequestMethod.GET, path="/parcels", produces = "application/json")
    public GeojsonCreator listParcels() {
    	return this.mapService.listParcels();
    }
    
    @ApiOperation(value = "list all pois", nickname = "list all pois")
    @RequestMapping(method = RequestMethod.GET, path="/pois", produces = "application/json")
    public GeojsonCreator listPois() {
    	return this.mapService.listPois();
    }
    
    @ApiOperation(value = "list all roads", nickname = "list all roads")
    @RequestMapping(method = RequestMethod.GET, path="/roads", produces = "application/json")
    public GeojsonCreator listRoads() {
    	return this.mapService.listRoads();
    }
}