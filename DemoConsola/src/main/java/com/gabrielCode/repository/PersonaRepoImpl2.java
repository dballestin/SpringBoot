package com.gabrielCode.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("persona2")
public class PersonaRepoImpl2 implements IPersona {

	private static Logger log = LoggerFactory.getLogger(PersonaRepoImpl2.class);

	@Override
	public void registrar(String nombre) {
		log.info("se registro FELIZMENTE...a:" + nombre);
	}
}
