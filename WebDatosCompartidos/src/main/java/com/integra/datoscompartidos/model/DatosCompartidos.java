package com.integra.datoscompartidos.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity(name="datos_compartidos")
public class DatosCompartidos {
	
	@Setter
	@Getter
	@Column(nullable = false, length = 30)
	private String tipoDocumento;
	
	@Setter
	@Getter
	@Column(nullable = false)
	private Integer numeroDocumento;
	
	@Setter
	@Getter
	@Column(nullable = false, length = 8)
	private Integer fechaSuscripcion;
	
	@Setter
	@Getter
	@Column(nullable = true, length = 8)
	private Integer fechaCancelacion;
	
	@Setter
	@Getter
	@Column(nullable = false, length = 15)
	private String estado;
	
	@Setter
	@Getter
	@Column(nullable = false, length = 50)
	private String empresa;

	@Setter
	@Getter
	@Column(nullable = false, length = 20)
	private String canal;
	
	
	public DatosCompartidos (String tipoDocumento, Integer numeroDocumento, Integer fechaSuscripcion, Integer fechaCancelacion, String estado, String empresa, String canal) {
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaSuscripcion = fechaSuscripcion;
		this.fechaCancelacion = fechaCancelacion;
		this.estado = estado;
		this.empresa = empresa;
		this.canal = canal;
	}
	
	
	
	
	
	

}
