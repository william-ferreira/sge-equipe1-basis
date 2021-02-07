import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { UsuarioModule } from './modulos/usuario/usuario.module';
import { EventoModule } from './modulos/evento/evento.module';
import { QuestaoModule } from './modulos/questao/questao.module';
import { EventoUsuarioModule } from './modulos/evento-usuario/evento-usuario.module';
import { InscricaoAdmModule } from './modulos/inscricao-adm/inscricao-adm.module';

const routes: Routes = [
  { path: 'usuarios', loadChildren: () => UsuarioModule, },
  { path: 'eventos', loadChildren: () => EventoModule, },
  { path: 'eventos-usuario', loadChildren: () => EventoUsuarioModule, },
  { path: 'perguntas', loadChildren: () => QuestaoModule },
  { path: 'inscricao-adm', loadChildren: () => InscricaoAdmModule },
  { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros' } },
  { path: 'login-success', component: LoginSuccessComponent },
]
@NgModule({
    imports: [
      RouterModule.forRoot(routes)
    ],
    exports: [RouterModule]
  })
export class AppRoutingModule { }
