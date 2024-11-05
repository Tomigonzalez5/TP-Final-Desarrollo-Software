package com.gestion.gestionAlumnos.service;

import java.util.List;
import java.util.Optional;

import com.gestion.gestionAlumnos.entity.Docente;

public interface DocenteService {
	public List<Docente> findAll();
	
	public Docente save(Docente docente);
	
	public Docente updateDocente(Long id, Docente docente);
	
	public Optional<Docente> findById(Long id);
	
	public void deleteById(Long id);
}
