package tr.iboss.urbaninfo.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import tr.iboss.constant.MapConstants;
import tr.iboss.urbaninfo.geojson.Feature;

public class FeatureDefaultListExtractor implements ResultSetExtractor<List<Feature>> {
	@Override
	public List<Feature> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Feature> featureList = new ArrayList<Feature>();
		while (rs.next()) {
			Feature feature = new Feature();
			FeatureDetailSetter propertySetter = new FeatureDetailSetter();
			feature.setProperties(propertySetter.propertyDefaultSetter(rs));
			feature.setGeometry(propertySetter.geometrySetter(rs));
			feature.setType(MapConstants.FEATURE);
			featureList.add(feature);
		}
		return featureList;
	}
}