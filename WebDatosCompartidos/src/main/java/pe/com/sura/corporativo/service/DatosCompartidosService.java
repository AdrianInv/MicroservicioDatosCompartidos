package pe.com.sura.corporativo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sura.corporativo.model.DatosCompartidos;
import pe.com.sura.corporativo.repository.DatosCompartidosRepository;

@Service
public class DatosCompartidosService {
	
	@Autowired
	private DatosCompartidosRepository datosCompartidosRepository;
	
	static final String SUSCRITO = "Suscrito";
	static final String NOSUSCRITO = "No Suscrito";
	
	
	public DatosCompartidos buscarDatosCompartidos(String numeroDocumento) {
		  return datosCompartidosRepository.findByNumeroDocumento(numeroDocumento);
	}
	
	public Boolean suscribir(DatosCompartidos datosCompartidos) {
		boolean resultado = false;
		DatosCompartidos nuevoDatosCompartidos = buscarDatosCompartidos(datosCompartidos.getNumerodocumento());
		if (nuevoDatosCompartidos == null) {
			DatosCompartidos datosCompartidosSuscritos = datosCompartidosRepository.save(datosCompartidos);
			if (datosCompartidosSuscritos != null)
				resultado = true;
		}else{	
			String fechaCancelacion = nuevoDatosCompartidos.getFechacancelacion();
			if (fechaCancelacion !=null ) {
				String fechaCancelacionNueva = null;
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				String fechaNuevaSuscripcion = format.format( new Date()   );
				int valor = datosCompartidosRepository.updateRenuevaSuscripcionByNumeroDocumento(fechaNuevaSuscripcion, fechaCancelacionNueva, SUSCRITO, datosCompartidos.getNumerodocumento());
				if (valor > 0)
					resultado = true;
			}
		}
        return resultado;
	}
	
	
	public Boolean desuscribir(DatosCompartidos datosCompartidos){
		String numeroDocumento = datosCompartidos.getNumerodocumento();
		DatosCompartidos nuevoDatosCompartidos = datosCompartidosRepository.findByNumeroDocumento(numeroDocumento);
		boolean resultado = false;
		if (nuevoDatosCompartidos != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String fechaCancelacionCadena = format.format( new Date()   );
			int valor = datosCompartidosRepository.updateCancelacionByNumeroDocumento(fechaCancelacionCadena,NOSUSCRITO, numeroDocumento);
			if (valor > 0)
				resultado = true;
		}
		return resultado;
	}

}
