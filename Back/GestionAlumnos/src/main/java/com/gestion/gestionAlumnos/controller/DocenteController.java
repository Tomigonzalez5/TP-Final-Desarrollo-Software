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

import com.gestion.gestionAlumnos.entity.Docente;
import com.gestion.gestionAlumnos.service.DocenteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/docente")
public class DocenteController {
	@Autowired
	DocenteService service;
	
	@GetMapping
	public List<Docente> findDocente() {
		return service.findAll();
	}
	
	@PostMapping("/add")
	public Docente createDocente(@RequestBody Docente docente) {
		return service.save(docente);
	}

	@PutMapping("/update/{id}")
    public ResponseEntity<Docente> updateDocente(@PathVariable Long id, @RequestBody Docente docente) {
       Docente updatedDocente = service.updateDocente(id, docente);
       return ResponseEntity.ok(updatedDocente);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
