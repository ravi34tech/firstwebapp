package com.model;

import java.util.Date;

public class UserDetails {

	private int id;
	private String userName;
	private String password;
	private Date loginDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", userName=" + userName + ", password=" + password + ", loginDate="
				+ loginDate + "]";
	}

}
