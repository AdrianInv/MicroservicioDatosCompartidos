package com.sura.corporativo.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sura.corporativo.model.DatosCompartidos;

@Repository
public interface DatosCompartidosRepository extends JpaRepository<DatosCompartidos, Long> {
	
	@SuppressWarnings("unchecked")
	public DatosCompartidos save(DatosCompartidos datosCompartidosBean);
	
	@Query("SELECT s FROM DatosCompartidos s WHERE s.numerodocumento = ?1")
	public DatosCompartidos findByNumeroDocumento(String numeroDocumento);
	
	@Transactional
	@Modifying
	@Query("UPDATE DatosCompartidos s SET s.fechacancelacion = ?1, s.estado = ?2 WHERE s.numerodocumento = ?3 ")
	public int updateCancelacionByNumeroDocumento(String fechacancelacion, String estado, String numeroDocumento);
	
	@Transactional
	@Modifying
	@Query("UPDATE DatosCompartidos s SET s.fechasuscripcion = ?1, s.fechacancelacion = ?2, s.estado = ?3 WHERE s.numerodocumento = ?4 ")
	public int updateRenuevaSuscripcionByNumeroDocumento(String fechasuscripcion, String fechacancelacion, String estado, String numeroDocumento);

}
