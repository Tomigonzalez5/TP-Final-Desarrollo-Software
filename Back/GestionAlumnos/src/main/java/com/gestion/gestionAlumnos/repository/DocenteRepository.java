package com.gestion.gestionAlumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.gestionAlumnos.entity.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long>{
	public List<Docente> findAllById(Long id);
}
