import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';
import { AlumnoService } from '../../services/alumno.service';
import { Alumno } from '../../model/alumno.model';
import { AlumnoModalComponent } from '../alumno-modal/alumno-modal.component';

@Component({
  selector: 'app-alumno',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './alumno.component.html',
  styleUrl: './alumno.component.css',
})
export class AlumnoComponent implements OnInit {
  alumnos: Alumno[] = [];

  constructor(
    private alumnoService: AlumnoService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.getAlumnos();
  }

  getAlumnos(): void {
    this.alumnoService.getAlumnos().subscribe((data) => {
      this.alumnos = data;
    });
  }

  deleteAlumno(id: number): void {
    const confirmation = confirm('¿Estás seguro de eliminar este Alumno?');
    if (confirmation) {
    this.alumnoService.deleteAlumno(id).subscribe(() => {
      this.getAlumnos();
    });
  }
  }

  updateAlumno(alumno: Alumno): void {
    this.alumnoService.updateAlumno(alumno.id, alumno).subscribe(() => {
      this.getAlumnos();
    });
  }

  openModalForAdd(): void {
    const dialogRef = this.dialog.open(AlumnoModalComponent, {
      width: '650px',
      height: '296px',
      data: {
        nombre: '',
        fechaNacimiento: '',
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.alumnoService.addAlumno(result).subscribe(() => {
          this.getAlumnos();
        });
      }
    });
  }

  openModalForUpdate(alumno: Alumno): void {
    const dialogRef = this.dialog.open(AlumnoModalComponent, {
      width: '650px',
      height: '296px',
      data: alumno,
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.updateAlumno(result);
      }
    });
  }
}
