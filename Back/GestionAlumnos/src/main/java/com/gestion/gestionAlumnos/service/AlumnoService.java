package com.gestion.gestionAlumnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestion.gestionAlumnos.entity.Alumno;

@Service
public interface AlumnoService {
	public List<Alumno> findAll();
	
	public Alumno save(Alumno alumno);
	
	public Alumno updateAlumno(Long id, Alumno alumno);
	
	public Optional<Alumno> findById(Long id);
	
	public void deleteById(Long id);
}
