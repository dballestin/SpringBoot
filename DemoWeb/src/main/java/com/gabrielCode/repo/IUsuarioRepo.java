package com.gabrielCode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielCode.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

	public default Usuario findByNombre(String nombre) {
		Usuario usuario = null;
		List<Usuario> usuarios = findAll();
		for (final Usuario usu : usuarios) {
			if (nombre.equals(usu.getNombre())) {
				usuario = usu;
				break;
			}
		}
		return usuario;
	}
	
}
