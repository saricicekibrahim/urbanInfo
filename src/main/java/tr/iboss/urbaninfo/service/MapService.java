package tr.iboss.urbaninfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.iboss.constant.MapConstants;
import tr.iboss.urbaninfo.dao.MapDao;
import tr.iboss.urbaninfo.geojson.Feature;
import tr.iboss.urbaninfo.geojson.GeojsonCreator;

@Service
public class MapService {
	
	@Autowired
	MapDao mapDao;
	
	public GeojsonCreator createFeatureCollection(List<Feature> argFeatureList){
		GeojsonCreator jsonResult = new GeojsonCreator();
		jsonResult.setFeatures(argFeatureList);
		jsonResult.setType(MapConstants.FEATURE_COLLECTION);
		return jsonResult;
	}
	
	public GeojsonCreator listDistricts() {
		return this.createFeatureCollection(this.mapDao.listDistricts());
	}

	public GeojsonCreator listParcels() {
		return this.createFeatureCollection(this.mapDao.listParcels());
	}

	public GeojsonCreator listPois() {
		return this.createFeatureCollection(this.mapDao.listPois());
	}

	public GeojsonCreator listRoads() {
		return this.createFeatureCollection(this.mapDao.listRoads());
	}
}
