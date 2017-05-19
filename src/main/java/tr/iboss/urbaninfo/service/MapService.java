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
	MapDao districtDao;
	
	public GeojsonCreator listAll() {
		return this.createFeatureCollection(this.districtDao.getAllDistricts());
	}
	
	public GeojsonCreator createFeatureCollection(List<Feature> argFeatureList){
		GeojsonCreator jsonResult = new GeojsonCreator();
		jsonResult.setFeatures(argFeatureList);
		jsonResult.setType(MapConstants.FEATURE_COLLECTION);
		return jsonResult;
	}
}
