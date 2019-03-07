package pe.com.sura.corporativo.test.controller;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.sura.corporativo.controller.DatosCompartidosController;
import pe.com.sura.corporativo.model.DatosCompartidos;
import pe.com.sura.corporativo.service.DatosCompartidosService;



@RunWith(SpringRunner.class)
@WebMvcTest(DatosCompartidosController.class)
public class DatosCompartidosControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DatosCompartidosService datosCompartidosService;
	
		
	static DatosCompartidos datoCompartido;
	
	@BeforeClass
	public static void beforeClass() {
			datoCompartido = new DatosCompartidos ("DNI","70432003","20190226",null, "suscrito", "AFP INTEGRA", "WEB");
			
	}
	
	@Test
	public void testSuscribirClienteRespuestaOk() throws Exception {
	  	  
	   when(datosCompartidosService.buscarDatosCompartidos(any())).thenReturn(DatosCompartidosControllerTest.datoCompartido);
	   when(datosCompartidosService.suscribir(any())).thenReturn(true);
	   
	   ObjectMapper mapper = new ObjectMapper();
	   this.mockMvc.perform(post("/suscribir")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(mapper.writeValueAsString(DatosCompartidosControllerTest.datoCompartido)))
	            .andExpect(status().isOk());

	}
	
	@Test
	public void testSuscribirErrorClienteNoEncontrado() throws Exception {
	  	  
	   when(datosCompartidosService.buscarDatosCompartidos(DatosCompartidosControllerTest.datoCompartido.getNumerodocumento())).thenReturn(null);
	   when(datosCompartidosService.suscribir(DatosCompartidosControllerTest.datoCompartido)).thenReturn(false);
	   
	   ObjectMapper mapper = new ObjectMapper();
	   this.mockMvc.perform(post("/suscribir")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(mapper.writeValueAsString(DatosCompartidosControllerTest.datoCompartido)))
	            .andExpect(status().is(500));

	}
	
	@Test
	public void testSuscribirClienteErrorClienteNoSuscrito() throws Exception {
	  	  
	   when(datosCompartidosService.buscarDatosCompartidos(DatosCompartidosControllerTest.datoCompartido.getNumerodocumento())).thenReturn(DatosCompartidosControllerTest.datoCompartido);
	   when(datosCompartidosService.suscribir(DatosCompartidosControllerTest.datoCompartido)).thenReturn(false);
	   
	   ObjectMapper mapper = new ObjectMapper();
	   this.mockMvc.perform(post("/suscribir")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(mapper.writeValueAsString(DatosCompartidosControllerTest.datoCompartido)))
	            .andExpect(status().is(500));

	}
	
	@Test
	public void testDesuscribirClienteRespuestaOk() throws Exception {
	  	  
	   when(datosCompartidosService.buscarDatosCompartidos(any())).thenReturn(DatosCompartidosControllerTest.datoCompartido);
	   when(datosCompartidosService.desuscribir(any())).thenReturn(true);
	   
	   ObjectMapper mapper = new ObjectMapper();
	   this.mockMvc.perform(post("/desuscribir")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(mapper.writeValueAsString(DatosCompartidosControllerTest.datoCompartido)))
	            .andExpect(status().isOk());

	}
	
	@Test
	public void testDesuscribirErrorClienteNoEncontrado() throws Exception {
	  	  
	   when(datosCompartidosService.buscarDatosCompartidos(DatosCompartidosControllerTest.datoCompartido.getNumerodocumento())).thenReturn(null);
	   when(datosCompartidosService.desuscribir(DatosCompartidosControllerTest.datoCompartido)).thenReturn(false);
	   
	   ObjectMapper mapper = new ObjectMapper();
	   this.mockMvc.perform(post("/desuscribir")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(mapper.writeValueAsString(DatosCompartidosControllerTest.datoCompartido)))
	            .andExpect(status().is(500));

	}
	
	@Test
	public void testDesuscribirErrorClienteNoDesuscrito() throws Exception {
	  	  
	   when(datosCompartidosService.buscarDatosCompartidos(DatosCompartidosControllerTest.datoCompartido.getNumerodocumento())).thenReturn(DatosCompartidosControllerTest.datoCompartido);
	   when(datosCompartidosService.desuscribir(DatosCompartidosControllerTest.datoCompartido)).thenReturn(false);
	   
	   ObjectMapper mapper = new ObjectMapper();
	   this.mockMvc.perform(post("/desuscribir")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(mapper.writeValueAsString(DatosCompartidosControllerTest.datoCompartido)))
	            .andExpect(status().is(500));

	}
	
	public String asJsonString (Object objeto) throws JsonProcessingException {
		com.fasterxml.jackson.databind.ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(objeto);
		return json;
	}

}
