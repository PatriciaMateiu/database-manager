package net.codejava.dao;

import java.util.List;

import net.codejava.model.Clothing;

public interface ClothingDAO {

	public int save(Clothing clothing);
	public int update(Clothing clothing);
	public Clothing get(Integer id);
	public int delete(Integer id);
	public List<Clothing> list();
}

