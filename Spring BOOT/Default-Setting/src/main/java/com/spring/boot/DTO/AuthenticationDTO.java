package com.spring.boot.DTO;

public class AuthenticationDTO {

	private String id;
	private String password;
	private int enabled;
	private String authority;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public String toString() {
		
		return "[Authentication = id:" + id + ", password:" + password + ", enabled:" + enabled + ", authority:" + authority + "]";
	}
}
