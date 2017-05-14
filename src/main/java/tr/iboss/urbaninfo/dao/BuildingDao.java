package tr.iboss.urbaninfo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tr.iboss.urbaninfo.dto.BuildingDto;

@Repository
public class BuildingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * GeojsonDao<br />
	 * 
	 * @param argUnits
	 * @return
	 * 
	 * 		<b>created at</b> 21 Şub 2017 09:05:44
	 * @since 1.00.0.0
	 * @author Ibrahim Saricicek
	 */
	public List<BuildingDto> getWithLimit() {

		return this.jdbcTemplate.query("select * from building limit 100;",
				new RowMapper<BuildingDto>() {
					public BuildingDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						BuildingDto buildingDto = new BuildingDto();
						buildingDto.setId(rs.getInt("id"));
						buildingDto.setName(rs.getString("name"));
						buildingDto.setNumber(rs.getString("number"));
						return buildingDto;
					}
				});
	}
}
