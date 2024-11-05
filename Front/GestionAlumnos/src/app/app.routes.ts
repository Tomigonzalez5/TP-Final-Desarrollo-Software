import { Routes } from '@angular/router';
import { AlumnoComponent } from './alumnos/components/alumno/alumno.component';
import { TemaComponent } from './temas/components/tema/tema.component';
import { DocenteComponent } from './docentes/components/docente/docente.component';
import { CursoComponent } from './cursos/components/curso/curso.component';

export const routes: Routes = [
  { path: 'alumnos', component: AlumnoComponent},
  { path: 'temas', component: TemaComponent},
  { path: 'docentes', component: DocenteComponent},
  { path: 'cursos', component: CursoComponent},
  { path: '', redirectTo: '/cursos', pathMatch: 'full' },
  { path: '**', redirectTo: '/cursos' }, // En caso de error en URL, se redirige al inicio, donde se encuentra Cursos
];
