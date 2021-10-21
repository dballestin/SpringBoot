package com.gabrielCode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielCode.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
