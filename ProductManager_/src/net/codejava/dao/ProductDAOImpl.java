package net.codejava.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.model.Product;

public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	public ProductDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Product p) {
		String sql = "INSERT INTO Product(name, price, quantity, volume) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, p.getName(), p.getPrice(), p.getQuantity(), p.getVolume());

	}

	@Override
	public int update(Product p) {
		String sql = "UPDATE Product SET name=?, price=?, quantity=?, volume=? WHERE product_id=?";
		return jdbcTemplate.update(sql, p.getName(), p.getPrice(), p.getQuantity(), p.getVolume(), p.getId());
	}

	@Override
	public Product get(Integer id) {
		String sql = "SELECT * FROM Product WHERE product_id=" + id;
		ResultSetExtractor<Product> extractor = new ResultSetExtractor<Product>() {

			@Override
			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					Integer price = rs.getInt("price");
					Integer quantity = rs.getInt("quantity");
					String volume = rs.getString("volume");
					
					return new Product(id, name, price, quantity, volume);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Product WHERE product_id="+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Product> list() {
		String sql = "SELECT * FROM Product	";
		RowMapper<Product> rowMapper = new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("product_id");
				String name = rs.getString("name");
				Integer price = rs.getInt("price");
				Integer quantity = rs.getInt("quantity");
				String volume = rs.getString("volume");
				return new Product(id, name, price, quantity, volume);
				
			}
			
		};
		return jdbcTemplate.query(sql, rowMapper);
		
	}

}
