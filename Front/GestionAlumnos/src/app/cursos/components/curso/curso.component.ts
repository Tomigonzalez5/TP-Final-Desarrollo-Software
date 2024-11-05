import { Component, OnInit } from '@angular/core';
import { Curso } from '../../model/curso.model';
import { CursoService } from '../../services/curso.service';
import { MatDialog } from '@angular/material/dialog';
import { CursoModalComponent } from '../curso-modal/curso-modal.component';
import { CommonModule } from '@angular/common';
import { AlumnoService } from '../../../alumnos/services/alumno.service';
import { Alumno } from '../../../alumnos/model/alumno.model';
import { FormsModule } from '@angular/forms';
import { DocenteService } from '../../../docentes/services/docente.service';
import { Docente } from '../../../docentes/model/docente.model'; 

@Component({
  selector: 'app-curso',
  standalone: true,
  // CommonModule para operaciones y FormsModule para el ngModel
  imports: [CommonModule, FormsModule],
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css'
})


export class CursoComponent implements OnInit{

  cursos: Curso[] = [];
  alumnos: Alumno[] = [];
  docentes: Docente[] = [];

  // inicializo las variables que contendrán el value ingresado en los inputs.
  fechaFin: string = '';
  docenteId: number = 0;

  cursosFiltrados: Curso[] = [];
  alumnosPorCurso: Alumno[] = [];

  constructor(
    private cursoService: CursoService,
    private alumnoService: AlumnoService,
    private docenteService: DocenteService,
    private dialog: MatDialog // Con MatDialog se manejan las acciones del Modal.
  ) {}

  ngOnInit(): void {
    this.getCursos();
    this.getAlumnos();
    this.getDocentes();
  }

  getAlumnos(): void {
    this.alumnoService.getAlumnos().subscribe((data) => {
      this.alumnos = data;
    })
  }

  getDocentes(): void {
    this.docenteService.getDocentes().subscribe((data) => {
      this.docentes = data;
    });
  }

  getCursos(): void {
    this.cursoService.getCursos().subscribe((data) => {
      this.cursos = data;
    });
  }

  deleteCurso(id: number): void {
    const confirmation = confirm('¿Estás seguro de eliminar este Curso?');
    if (confirmation) {
      this.cursoService.deleteCurso(id).subscribe(() => {
        this.getCursos();
      });
    }
  }

  updateCurso(curso: Curso): void {
    this.cursoService.updateCurso(curso.id, curso).subscribe(() => {
      this.getCursos();
    });
  }

  openModalForAdd(): void {
    const dialogRef = this.dialog.open(CursoModalComponent, {
      width: '650px',
      height: '450px',
      data: {
        fechaInicio: '',
        fechaFin: '',
        precio: '',
        tema: null,
        docente: null,
        alumnos: null,
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.cursoService.addCurso(result).subscribe(() => {
          this.getCursos();
        });
      }
    });
  }

  openModalForUpdate(curso : Curso): void {
    const dialogRef = this.dialog.open(CursoModalComponent, {
      width: '650px',
      height: '450px',
      data: curso,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.updateCurso(result);
      }
    });
  }

  findCursosByFechaFin(): void {
    if(this.fechaFin){
      this.cursoService.findCursosByFechaFin(this.fechaFin).subscribe((cursos) => {
        this.cursosFiltrados = cursos;
      })
    } else {
      this.cursosFiltrados = [];
    }
  }

  findAlumnosByDocente(): void {
    if(this.docenteId){
      this.cursoService.findAlumnosByCursosVigentes(this.docenteId).subscribe((alumnos) => {
        this.alumnosPorCurso = alumnos;
      })
    } else {
      this.alumnosPorCurso = [];
    }
  }
}
