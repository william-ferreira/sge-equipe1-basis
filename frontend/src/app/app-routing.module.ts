import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UsuarioModule } from './modulos/usuario/usuario.module';
import { EventoModule } from './modulos/evento/evento.module';
import { QuestaoModule } from './modulos/questao/questao.module';
import { EventoUsuarioModule } from './modulos/evento-usuario/evento-usuario.module';
import { InscricaoAdmModule } from './modulos/inscricao-adm/inscricao-adm.module';

import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { UsuarioGuardService } from './services/usuario-guard.service';
import { AdminGuardService } from './services/admin-guard.service';
import { VisitanteGuardService } from './services/visitante-guard.service';
import { FormularioComponent } from './modulos/usuario/components/formulario/formulario.component';

const routes: Routes = [

  // TODO: Criar paths separados para admin e usuario com seus respectivos guards
  { path: 'usuario', loadChildren: () => UsuarioModule },
  { path: 'eventos', loadChildren: () => EventoModule, },
  { path: 'eventos-usuario', loadChildren: () => EventoUsuarioModule, },
  { path: 'perguntas', loadChildren: () => QuestaoModule },
  { path: 'inscricao-adm', loadChildren: () => InscricaoAdmModule },

  { path: 'login', component: LoginComponent, },
  { path: 'logout', component: LogoutComponent },
  { path: 'cadastrar', component: FormularioComponent },

]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule { }
