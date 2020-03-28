package net.codejava.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.model.Clothing;


public class ClothingDAOImpl implements ClothingDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ClothingDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int save(Clothing clothing) {
		String sql = "INSERT INTO Clothing (name, size, quantity, price) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, clothing.getName(), clothing.getSize(), clothing.getQuantity(), clothing.getPrice());
	}

	@Override
	public int update(Clothing clothing) {
		String sql = "UPDATE Clothing SET name=?, size=?, quantity=?, price=? WHERE clothing_id=?";
		return jdbcTemplate.update(sql, clothing.getName(), clothing.getSize(), clothing.getQuantity(), clothing.getPrice(), clothing.getClothing_id());
	}

	@Override
	public Clothing get(Integer id) {
		String sql = "SELECT * FROM Clothing WHERE Clothing_id=" + id;
		ResultSetExtractor<Clothing> extractor =  new ResultSetExtractor<Clothing>() {

			@Override
			public Clothing extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if(rs.next()) {
					String name = rs.getString("name");
					Integer size = rs.getInt("size");
					Integer quantity = rs.getInt("quantity");
					Integer price = rs.getInt("price");
					return new Clothing(id, name, size, quantity, price);
					
				}
				return null;
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Clothing WHERE clothing_id="+id;
		return jdbcTemplate.update(sql);
		
	}

	@Override
	public List<Clothing> list() {
		String sql = "SELECT * FROM Clothing ";
		RowMapper<Clothing> rowMapper = new RowMapper<Clothing>() {

			@Override
			public Clothing mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("clothing_id");
				String name = rs.getString("name");
				Integer size = rs.getInt("size");
				Integer quantity = rs.getInt("quantity");
				Integer price = rs.getInt("price");
				return new Clothing(id, name, size, quantity, price);
				
			}
			
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	

}
