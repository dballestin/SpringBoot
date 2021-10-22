package com.gabrielCode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielCode.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	Usuario findByNombre(String pNombre);
	
}
