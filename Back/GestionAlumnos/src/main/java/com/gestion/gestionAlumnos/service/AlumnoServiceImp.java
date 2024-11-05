package com.gestion.gestionAlumnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionAlumnos.entity.Alumno;
import com.gestion.gestionAlumnos.repository.GestionAlumnosRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {
	@Autowired
	GestionAlumnosRepository repository;
	
	@Override
	public List<Alumno> findAll() {
		return repository.findAll();
	}

	@Override
	public Alumno save(Alumno alumno) {
		return repository.save(alumno);
	}
	
	 @Override
	 public Alumno updateAlumno(Long id, Alumno alumno) {
	     if (repository.existsById(id)) {
	         alumno.setId(id);
	         return repository.save(alumno);
	     }
	     return null; 
	 }

	 @Override
	 public Optional<Alumno> findById(Long id) {
	     return repository.findById(id); 
	 }
	 @Override
	 public void deleteById(Long id) {
	     repository.deleteById(id); 
	 }
}
