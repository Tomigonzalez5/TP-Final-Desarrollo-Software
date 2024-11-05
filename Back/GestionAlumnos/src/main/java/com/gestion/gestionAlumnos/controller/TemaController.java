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

import com.gestion.gestionAlumnos.entity.Tema;
import com.gestion.gestionAlumnos.service.TemaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tema")
public class TemaController {
	@Autowired
	TemaService service;
	
	@GetMapping
	public List<Tema> findTema() {
		return service.findAll();
	}
	
	@PostMapping("/add")
	public Tema createTema(@RequestBody Tema tema) {
		return service.save(tema);
	}

	@PutMapping("/update/{id}")
    public ResponseEntity<Tema> updateTema(@PathVariable Long id, @RequestBody Tema tema) {
       Tema updatedTema = service.updateTema(id, tema);
       return ResponseEntity.ok(updatedTema);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTema(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
