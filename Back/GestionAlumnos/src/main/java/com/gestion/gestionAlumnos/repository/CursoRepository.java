package com.gestion.gestionAlumnos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestion.gestionAlumnos.entity.Alumno;
import com.gestion.gestionAlumnos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	public List<Curso> findAllById(Long id);
	
	@Query("SELECT c FROM Curso c WHERE DATE(c.fechaFin) = :fechaFin")
    List<Curso> findByFechaFin(@Param("fechaFin") LocalDate fechaFin);
	
	@Query("SELECT c.alumnos FROM Curso c WHERE c.docente.id = :docenteId")
    List<Alumno> findAlumnosByDocenteId(@Param("docenteId") Long docenteId);
}

