package com.integra.datoscompartidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integra.datoscompartidos.model.DatosCompartidos;
import com.integra.datoscompartidos.service.DatosCompartidosService;
import com.integra.datoscompartidos.util.*;

@RestController
@RequestMapping(value="/datoscompartidos")
public class DatosCompartidosController {
	
	@Autowired
	DatosCompartidosService datosCompartidosService;
	
	@PostMapping("/guardar")
	public ResponseEntity<HttpResponse> saveDatosCompartidos(@RequestBody DatosCompartidos datosCompartidos) {
		return datosCompartidosService.save(datosCompartidos);
	}

}
