package com.gestion.gestionAlumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.gestionAlumnos.entity.Alumno;

public interface GestionAlumnosRepository extends JpaRepository<Alumno, Long>{
	public List<Alumno> findAllById(Long id);
}
