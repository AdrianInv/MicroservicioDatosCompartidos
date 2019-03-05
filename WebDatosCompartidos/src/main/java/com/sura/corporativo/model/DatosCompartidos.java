package com.sura.corporativo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "datos_compartidos")

public class DatosCompartidos {
	
	
	public DatosCompartidos (Integer idDatoCompartido, String tipoDocumento, String numeroDocumento, String fechaSuscripcion, String fechaCancelacion, String estado, String empresa, String canal) {
		this.tipodocumento = tipoDocumento;
		this.numerodocumento = numeroDocumento;
		this.fechasuscripcion = fechaSuscripcion;
		this.fechacancelacion = fechaCancelacion;
		this.estado = estado;
		this.empresa = empresa;
		this.canal = canal;
	}
	
	public DatosCompartidos () {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer iddatocompartido;
		
	@Column(name = "tipodocumento",nullable = false, length = 30)
	private String tipodocumento;
	
	@Column(name = "numerodocumento",nullable = false, length = 20)
	private String numerodocumento;
	
	@Column(name = "fechasuscripcion", nullable = false)
	private String fechasuscripcion;
	
	@Column (name = "fechacancelacion", nullable = true)
	private String fechacancelacion;
	
	@Column(name = "estado", nullable = false, length = 15)
	private String estado;
	
	@Column(name = "empresa", nullable = false, length = 50)
	private String empresa;
	
	@Column(name = "canal", nullable = false, length = 20)
	private String canal;

	
	public Integer getIddatocompartido() {
		return iddatocompartido;
	}

	public void setIddatocompartido(Integer iddatocompartido) {
		this.iddatocompartido = iddatocompartido;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getFechasuscripcion() {
		return fechasuscripcion;
	}

	public void setFechasuscripcion(String fechasuscripcion) {
		this.fechasuscripcion = fechasuscripcion;
	}

	public String getFechacancelacion() {
		return fechacancelacion;
	}

	public void setFechacancelacion(String fechacancelacion) {
		this.fechacancelacion = fechacancelacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}
	
	
	
     
	
	
	
	
	
	
	
	

}
