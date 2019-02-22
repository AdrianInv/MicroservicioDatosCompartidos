package com.integra.datoscompartidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.integra.datoscompartidos.model.DatosCompartidos;
import com.integra.datoscompartidos.repository.DatosCompartidosRepository;
import com.integra.datoscompartidos.util.HttpResponse;

@Component
public class DatosCompartidosService {
	
	@Autowired
	DatosCompartidosRepository datosCompartidosRepository;
	
	
	public ResponseEntity<HttpResponse> save(DatosCompartidos datosCompartidos) {
		DatosCompartidos nuevoDatosCompartidos = datosCompartidosRepository.save(datosCompartidos);
 
		
		if (nuevoDatosCompartidos == null) {
			
			return new ResponseEntity<HttpResponse>(
					new HttpResponse("500", "ERROR", "Task creation failed", nuevoDatosCompartidos),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
 
		return new ResponseEntity<HttpResponse>(
				new HttpResponse("200", "SUCCESS", "Task created successfully", nuevoDatosCompartidos), HttpStatus.OK);
	}
	

}
