import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { UsuarioModule } from './modulos/usuario/usuario.module';
import { InscricaoAdmModule  } from './modulos/inscricao-adm/inscricao-adm.module';
import { EventoModule } from './modulos/evento/evento.module';


const routes: Routes = [
  { path: 'usuarios', loadChildren: () => UsuarioModule, },
  { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros' } },
  { path: 'login-success', component: LoginSuccessComponent },
  { path: 'inscricao-adm', loadChildren: () => InscricaoAdmModule },
  {path: 'eventos',loadChildren:()=> EventoModule,},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
