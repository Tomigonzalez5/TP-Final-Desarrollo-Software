package com.gestion.gestionAlumnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionAlumnos.entity.Docente;
import com.gestion.gestionAlumnos.repository.DocenteRepository;

@Service
public class DocenteServiceImp implements DocenteService{
	@Autowired
	DocenteRepository repository;
	
	@Override
	public List<Docente> findAll() {
		return repository.findAll();
	}

	@Override
	public Docente save(Docente docente) {
		return repository.save(docente);
	}
	
	@Override
	public Docente updateDocente(Long id, Docente docente) {
	    if (repository.existsById(id)) {
	        docente.setId(id); 
	        return repository.save(docente);
	    }
	    return null;
	}

	@Override
	public Optional<Docente> findById(Long id) {
	    return repository.findById(id); 
	}
	@Override
	public void deleteById(Long id) {
	    repository.deleteById(id); 
	}
}
