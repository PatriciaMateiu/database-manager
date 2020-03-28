package net.codejava.dao;

import java.util.List;

import net.codejava.model.Product;

public interface ProductDAO {
	public int save(Product product);
	public int update(Product product);
	public Product get(Integer id);
	public int delete(Integer id);
	public List<Product> list();
	
}
