package com.vivelibre.prueba1.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vivelibre.prueba1.modelo.RequestAuth;
import com.vivelibre.prueba1.modelo.RespuestaAuth;


@Service
public class GetTokenService {
	Logger logger = LoggerFactory.getLogger(GetTokenService.class);
	
	
	public String getToken() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		RequestAuth requestAuth = new RequestAuth();
		requestAuth.setUsername("auth-vivelibre");
		requestAuth.setPassword("password");
		HttpEntity<RequestAuth> request = new HttpEntity<RequestAuth>(requestAuth, headers);

		ResponseEntity<RespuestaAuth> response = restTemplate.postForEntity(URI.create("http://auth-vivelibre:8080/token"), request , RespuestaAuth.class);
		
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			return response.getBody().getToken();
		} else {
			throw new Exception("Error al obtener el token");
		}
		
	}
	
	
}
