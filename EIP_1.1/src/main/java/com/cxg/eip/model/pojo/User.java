package com.cxg.eip.model.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
	int id;
	String username;
	String password;
	String name;
	String position;
	String privilege;
	String email;
	
	public User() {
	}

	public User(String username, String password, String name, String position, String privilege, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.position = position;
		this.privilege = privilege;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", position="
				+ position + ", privilege=" + privilege + ", email=" + email + "]";
	}
	
}
