package com.sura.corporativo.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sura.corporativo.model.DatosCompartidos;
import com.sura.corporativo.repository.DatosCompartidosRepository;
import com.sura.corporativo.service.DatosCompartidosService;

@RunWith(SpringRunner.class)
@WebMvcTest(DatosCompartidosService.class)
public class DatosCompartidosServiceTest {
	
	@MockBean
	private DatosCompartidosRepository datosCompartidosRepository;
	
	@Autowired
	private DatosCompartidosService datosCompartidosService;
	
	static DatosCompartidos datoCompartidoNuevo;
	static DatosCompartidos datoCompartidoExistente;
	
	final String SUSCRITO = "Suscrito";
	final String NOSUSCRITO = "No Suscrito";
	
	
	@BeforeClass
	public static void beforeClass() {
		datoCompartidoNuevo = new DatosCompartidos (null,"DNI","70432003","20190226",null, "suscrito", "AFP INTEGRA", "WEB");
		datoCompartidoExistente = new DatosCompartidos (null,"DNI","70432003","20190226","20190318", "suscrito", "AFP INTEGRA", "WEB");
	}
	
	@Test
	public void buscarDatosCompartidosCorrectamente() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoNuevo.getNumerodocumento())).thenReturn(datoCompartidoNuevo);
		DatosCompartidos datoCompartidoTest = datosCompartidosService.buscarDatosCompartidos(datoCompartidoNuevo.getNumerodocumento());
		assertEquals(datoCompartidoNuevo, datoCompartidoTest);
	}
	
	@Test
	public void suscribeNuevosDatosCompartidosCorrectamente() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoNuevo.getNumerodocumento())).thenReturn(null);
		when(datosCompartidosRepository.save(datoCompartidoNuevo)).thenReturn(datoCompartidoNuevo);
		Boolean resultado = datosCompartidosService.suscribir(datoCompartidoNuevo);
		assertEquals(true, resultado);
	}
	
	@Test
	public void suscribeNuevosDatosCompartidosError() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoNuevo.getNumerodocumento())).thenReturn(null);
		when(datosCompartidosRepository.save(datoCompartidoNuevo)).thenReturn(null);
		Boolean resultado = datosCompartidosService.suscribir(datoCompartidoNuevo);
		assertEquals(false, resultado);
	}
	
	@Test
	public void suscribeDatosClienteExistenteCompartidosCorrectamente() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoExistente.getNumerodocumento())).thenReturn(datoCompartidoExistente);
		
		when(datosCompartidosRepository.updateRenuevaSuscripcionByNumeroDocumento(obtenerFechaActual(),null, SUSCRITO, datoCompartidoExistente.getNumerodocumento())).thenReturn(1);
		Boolean resultado = datosCompartidosService.suscribir(datoCompartidoExistente);
		assertEquals(true, resultado);
	}
	
	@Test
	public void suscribeDatosClienteExistenteCompartidosError() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoExistente.getNumerodocumento())).thenReturn(datoCompartidoExistente);
		when(datosCompartidosRepository.updateRenuevaSuscripcionByNumeroDocumento(obtenerFechaActual(), null, SUSCRITO, datoCompartidoExistente.getNumerodocumento())).thenReturn(0);
		Boolean resultado = datosCompartidosService.suscribir(datoCompartidoExistente);
		assertEquals(false, resultado);
	}
	
	@Test
	public void desuscribeDatosClienteExistenteCompartidosCorrectamente() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoExistente.getNumerodocumento())).thenReturn(datoCompartidoExistente);
		when(datosCompartidosRepository.updateCancelacionByNumeroDocumento(obtenerFechaActual(), NOSUSCRITO, datoCompartidoExistente.getNumerodocumento())).thenReturn(1);
		Boolean resultado = datosCompartidosService.desuscribir(datoCompartidoExistente);
		assertEquals(true, resultado);
	}
	
	@Test
	public void desuscribeDatosClienteNoExistenteCompartidosError() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoExistente.getNumerodocumento())).thenReturn(null);
		Boolean resultado = datosCompartidosService.desuscribir(datoCompartidoExistente);
		assertEquals(false, resultado);
	}
	
	@Test
	public void desuscribeDatosClienteExistenteCompartidosError() {
		when(datosCompartidosRepository.findByNumeroDocumento(datoCompartidoExistente.getNumerodocumento())).thenReturn(datoCompartidoExistente);
		when(datosCompartidosRepository.updateCancelacionByNumeroDocumento(obtenerFechaActual(), NOSUSCRITO,datoCompartidoExistente.getNumerodocumento())).thenReturn(-1);
		Boolean resultado = datosCompartidosService.desuscribir(datoCompartidoExistente);
		assertEquals(false, resultado);
	}
	
	public String obtenerFechaActual() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String fechaCadena = format.format(new Date());
		return fechaCadena;
	}

}
