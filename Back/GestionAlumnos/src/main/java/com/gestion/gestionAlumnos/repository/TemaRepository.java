package com.gestion.gestionAlumnos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.gestionAlumnos.entity.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllById(Long id);
}
