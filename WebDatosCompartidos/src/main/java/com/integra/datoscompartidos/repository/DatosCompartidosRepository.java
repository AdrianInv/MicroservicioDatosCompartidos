package com.integra.datoscompartidos.repository;


import org.springframework.data.repository.CrudRepository;

import com.integra.datoscompartidos.model.DatosCompartidos;

public interface DatosCompartidosRepository extends CrudRepository<DatosCompartidosRepository, String> {
	
	DatosCompartidos save(DatosCompartidos datosCompartidosBean);

}
