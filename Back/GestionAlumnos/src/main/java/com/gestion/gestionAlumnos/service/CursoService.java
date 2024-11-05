package com.gestion.gestionAlumnos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.gestion.gestionAlumnos.entity.Alumno;
import com.gestion.gestionAlumnos.entity.Curso;

public interface CursoService {
	public List<Curso> findAll();
	
	public Curso save(Curso curso);
	
	public Curso updateCurso(Long id, Curso curso);
	
	public Optional<Curso> findById(Long id);
	
	public void deleteById(Long id);
	
	public List<Curso> findByFechaFin(LocalDate fechaFin);
	
	public List<Alumno> findAlumnosByDocenteId(Long docenteId);

}
