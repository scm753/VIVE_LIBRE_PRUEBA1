package com.vivelibre.prueba1;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivelibre.prueba1.modelo.Respuesta;
import com.vivelibre.prueba1.service.GetTokenService;

@RestController
public class ControllerPrueba {
	Logger logger = LoggerFactory.getLogger(ControllerPrueba.class);

	@Autowired
	private GetTokenService getTokenService;
	
	@GetMapping("/get-token")
	public ResponseEntity<Respuesta> getToken() {
		try {
			String token = getTokenService.getToken();
			Respuesta respuesta = new Respuesta(token, LocalDate.now());
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
