package com.project.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBOperation {
	
	@Autowired
	JdbcTemplate jdbctemp;
	
	public void addProduct() {
		String query = "INSERT INTO product VALUES(44, 'TV', 1219.2000)";
		jdbctemp.update(query);
	}
	public void addProduct2() {
		String query = "INSERT INTO product VALUES(?,?,?)";
		jdbctemp.update(query, 55, "mobile", 22.22);
	}
	
	
	
	public void deleteProduct() {
		String query = "DELETE FROM product WHERE id=8";
		jdbctemp.update(query);
	}
	public void deleteProduct2() {
		String query = "DELETE FROM product WHERE id=?";
		jdbctemp.update(query, 11);
	}
	
	
	
	public void updateProduct() {
		String query = "UPDATE product set name='Frizz' WHERE id=22";
		jdbctemp.update(query);
	}
	public void updateProduct2() {
		String query = "UPDATE product SET name=? WHERE id=?";
		jdbctemp.update(query, "Key", 33);
	}
}
