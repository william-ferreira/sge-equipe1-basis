import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { UsuarioModule } from './modulos/usuario/usuario.module';
import {EventoModule} from './modulos/evento/evento.module';
import { QuestaoModule } from './modulos/questao/questao.module';
import { EventoUsuarioModule } from './modulos/evento-usuario/evento-usuario.module';

const routes: Routes = [
    { path: 'usuarios', loadChildren: () => UsuarioModule, },
    { path: 'eventos', loadChildren: () => EventoModule, },
    { path: 'eventos-usuario', loadChildren: () => EventoUsuarioModule, },
    { path: 'perguntas', loadChildren :() => QuestaoModule},
    { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'} },
    { path: 'login-success', component: LoginSuccessComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
