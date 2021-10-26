package com.inetum.curso.springboot.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.curso.springboot.model.Alumno;

public interface IAlumnoDao extends JpaRepository<Alumno, Integer> {

}
