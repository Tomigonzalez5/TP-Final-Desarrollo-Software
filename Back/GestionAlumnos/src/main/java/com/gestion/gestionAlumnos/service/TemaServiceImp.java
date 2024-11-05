package com.gestion.gestionAlumnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestionAlumnos.entity.Tema;
import com.gestion.gestionAlumnos.repository.TemaRepository;

@Service
public class TemaServiceImp implements TemaService{
	@Autowired
	TemaRepository repository;
	
	@Override
	public List<Tema> findAll() {
		return repository.findAll();
	}

	@Override
	public Tema save(Tema tema) {
		return repository.save(tema);
	}
	
	@Override
	public Tema updateTema(Long id, Tema tema) {
	    if (repository.existsById(id)) {
	        tema.setId(id); 
	        return repository.save(tema); 
	    }
	    return null; 
	}

	@Override
	public Optional<Tema> findById(Long id) {
	    return repository.findById(id); 
	}
	@Override
	public void deleteById(Long id) {
	    repository.deleteById(id); 
	}
}
