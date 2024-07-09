package com.vivelibre.prueba1.modelo;

import java.io.Serializable;

public class RequestAuth implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3193198969797221350L;
	private String username;
	private String password;
	
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
	
}
