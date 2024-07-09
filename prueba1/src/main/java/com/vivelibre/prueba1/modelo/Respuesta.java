package com.vivelibre.prueba1.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Respuesta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4748772296837259892L;
	private String token;
	private LocalDate hoy;
	
	public Respuesta(String token, LocalDate hoy) {
		super();
		this.token = token;
		this.hoy = hoy;
	}
	@JsonGetter("auth-vivelibre-token")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMMM dd, yyyy")
	@JsonGetter("date")
	public LocalDate getHoy() {
		return hoy;
	}
	public void setHoy(LocalDate hoy) {
		this.hoy = hoy;
	}
	
	
}
