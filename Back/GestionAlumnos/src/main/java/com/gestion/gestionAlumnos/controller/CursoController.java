package com.gestion.gestionAlumnos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestionAlumnos.entity.Alumno;
import com.gestion.gestionAlumnos.entity.Curso;
import com.gestion.gestionAlumnos.service.CursoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/curso")
public class CursoController {
	
	@Autowired
	CursoService service;
	
	@GetMapping
	public List<Curso> findCurso() {
		return service.findAll();
	}
	
	@PostMapping("/add")
	public Curso createCurso(@RequestBody Curso curso) {
		return service.save(curso);
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
       Curso updatedCurso = service.updateCurso(id, curso);
       return ResponseEntity.ok(updatedCurso);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
	
	@GetMapping("/fecha-fin/{fechaFin}")
	public List<Curso> getCursosByFechaFin(@PathVariable("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin) {
	    return service.findByFechaFin(fechaFin);
	}
	
	@GetMapping("/docente/{docenteId}/alumnos-actuales")
    public List<Alumno> getAlumnosByDocenteId(@PathVariable Long docenteId) {
        return service.findAlumnosByDocenteId(docenteId);
    }

}
