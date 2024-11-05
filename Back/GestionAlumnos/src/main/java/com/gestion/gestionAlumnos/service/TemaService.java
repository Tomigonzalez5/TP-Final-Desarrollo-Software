package com.gestion.gestionAlumnos.service;

import java.util.List;
import java.util.Optional;

import com.gestion.gestionAlumnos.entity.Tema;

public interface TemaService {
	public List<Tema> findAll();
	
	public Tema save(Tema tema);
	
	public Tema updateTema(Long id, Tema tema);
	
	public Optional<Tema> findById(Long id);
	
	public void deleteById(Long id);
}
