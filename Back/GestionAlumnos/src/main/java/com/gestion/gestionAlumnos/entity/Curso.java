package com.gestion.gestionAlumnos.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "tema_id")
	private Tema tema;
	@Column(name = "fecha_inicio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	@Column(name = "fecha_fin")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	@ManyToOne
	@JoinColumn(name = "docente_id")
	private Docente docente;
	@Column(name = "precio")
	private Double precio;
	//@ManyToMany(mappedBy = "alumnos_id")
	@ManyToMany
	@JoinTable (
			name="curso_alumno",
			joinColumns = @JoinColumn(name="curso_id"),
			inverseJoinColumns = @JoinColumn(name="alumno_id")
	)
	private List <Alumno> alumnos;
	
	public Curso() {}
	
	public Curso(Tema tema_id, LocalDate fecha_inicio, LocalDate fechaFin, Docente docente_id, Double precio, List <Alumno> alumnos) {
		this.tema = tema_id;
		this.fechaInicio = fecha_inicio;
		this.fechaFin = fechaFin;
		this.docente = docente_id;
		this.precio = precio;
		this.alumnos = alumnos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema_id) {
		this.tema = tema_id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fecha_inicio) {
		this.fechaInicio = fecha_inicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente_id) {
		this.docente = docente_id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	} 
}