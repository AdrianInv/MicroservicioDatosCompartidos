package pe.com.sura.corporativo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.sura.corporativo.model.DatosCompartidos;
import pe.com.sura.corporativo.service.DatosCompartidosService;
import pe.com.sura.corporativo.util.HttpResponse;


@RestController
public class DatosCompartidosController {
	
	@Autowired
	private DatosCompartidosService datosCompartidosService;
	
	@PostMapping("/suscribir")
	public ResponseEntity<HttpResponse> suscribirDatosCompartidos(@RequestBody DatosCompartidos datosCompartidos) {
		Boolean resultado = datosCompartidosService.suscribir(datosCompartidos);
		if (resultado)
			 return new ResponseEntity<>( new HttpResponse("200", "SUCCESS","Cliente Suscrito"), HttpStatus.OK);
		else	 
			return new ResponseEntity<>( new HttpResponse("500", "ERROR",  "Error al suscribir cliente"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/desuscribir")
	public ResponseEntity<HttpResponse> desuscribirDatosCompartidos(@RequestBody DatosCompartidos datosCompartidos) {
		Boolean resultado = datosCompartidosService.desuscribir(datosCompartidos);
		if (resultado)
			 return new ResponseEntity<>( new HttpResponse("200", "SUCCESS","Cliente dado de alta"), HttpStatus.OK);
		else	 
			return new ResponseEntity<>( new HttpResponse("500", "ERROR",  "Error al dar de alta cliente"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
