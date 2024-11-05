package com.gestion.gestionAlumnos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionAlumnos.entity.Alumno;
import com.gestion.gestionAlumnos.entity.Curso;
import com.gestion.gestionAlumnos.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService{

	@Autowired
	CursoRepository repository;
	
	@Override
	public List<Curso> findAll() {
		return repository.findAll();
	}

	@Override
	public Curso save(Curso curso) {
		return repository.save(curso);
	}
	
	@Override
	 public Curso updateCurso(Long id, Curso curso) {
	     if (repository.existsById(id)) {
	         curso.setId(id);
	         return repository.save(curso);
	     }
	     return null;
	 }

	 @Override
	 public Optional<Curso> findById(Long id) {
	     return repository.findById(id); 
	 }
	 @Override
	 public void deleteById(Long id) {
	     repository.deleteById(id); 
	 }
	 
	 @Override
	 public List<Curso> findByFechaFin(LocalDate fechaFin) {
	        return repository.findByFechaFin(fechaFin);
	    }
	 @Override
	    public List<Alumno> findAlumnosByDocenteId(Long docenteId) {
	        return repository.findAlumnosByDocenteId(docenteId);
	    }
}
