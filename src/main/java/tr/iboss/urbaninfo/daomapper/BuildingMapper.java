package tr.iboss.urbaninfo.daomapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tr.iboss.urbaninfo.dto.BuildingDto;

public class BuildingMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		BuildingDto buildingDto = new BuildingDto();
		buildingDto.setId(rs.getInt("id"));
		buildingDto.setName(rs.getString("name"));
		buildingDto.setNumber(rs.getString("number"));
		return buildingDto;
	}
}
