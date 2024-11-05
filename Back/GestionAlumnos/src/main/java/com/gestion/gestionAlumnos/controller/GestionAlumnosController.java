package com.gestion.gestionAlumnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.gestion.gestionAlumnos.service.AlumnoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/alumno")
public class GestionAlumnosController {
	@Autowired
	AlumnoService service;
	
	@GetMapping
	public List<Alumno> findAlumno() {
		return service.findAll();
	}
	
	@PostMapping("/add")
	public Alumno createAlumno(@RequestBody Alumno alumno) {
		return service.save(alumno);
	}
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
       Alumno updatedAlumno = service.updateAlumno(id, alumno);
       return ResponseEntity.ok(updatedAlumno);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
