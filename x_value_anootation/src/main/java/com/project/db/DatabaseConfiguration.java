package com.project.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.project.newdb.PostgralDB;

@Component("dbCre")
public class DatabaseConfiguration {
	
	@Value("DB Config...........")
	private String name;
	
	@Value("${db.mysql.port}")
	private int dbPort;
	
	@Value("${db.mysql.url}")
	private String dbURL;
	
	@Value("${db.mysql.username}")
	private String dbUsername;
	
	@Value("${db.mysql.password}")
	private String dbPass;
	
	@Autowired
	private PostgralDB postgralDB;
	
	
	
	
	
	public int getDbPort() {
		return dbPort;
	}
	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}
	public String getDbURL() {
		return dbURL;
	}
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	public String getDbUsername() {
		return dbUsername;
	}
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	public String getDbPass() {
		return dbPass;
	}
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}
	public PostgralDB getPostgralDB() {
		return postgralDB;
	}
	public void setPostgralDB(PostgralDB postgralDB) {
		this.postgralDB = postgralDB;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
