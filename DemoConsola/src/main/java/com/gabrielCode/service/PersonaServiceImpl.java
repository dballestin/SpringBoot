package com.gabrielCode.service;

import com.gabrielCode.repository.IPersona;
import com.gabrielCode.repository.PersonaRepoImpl1;

public class PersonaServiceImpl implements IPersonaService {
	IPersona repo;

	@Override
	public void registrarHandler(String pNombre) {
		
		repo = new PersonaRepoImpl1();
		
		repo.registrar(pNombre);
	}
}
