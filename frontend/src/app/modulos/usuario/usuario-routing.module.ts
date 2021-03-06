import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListagemComponent } from './components/listagem/listagem.component';
import { PerfilComponent } from './components/perfil/perfil.component';


const routes: Routes = [
  {
    path: '',
    component: ListagemComponent,
  },
  {
    path: 'cadastrar',
    component: FormularioComponent
  },
  {
    path: 'perfil',
    component: PerfilComponent
  },
  {
    path: 'formulario/:id',
    component: FormularioComponent
  },
  {
    path: 'formulario/:id',
    component: FormularioComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioRoutingModule { }
