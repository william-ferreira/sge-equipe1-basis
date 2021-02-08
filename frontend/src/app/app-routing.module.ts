import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { UsuarioModule } from './modulos/usuario/usuario.module';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { UsuarioGuardService } from './services/usuario-guard.service';
import { AdminGuardService } from './services/admin-guard.service';
import { VisitanteGuardService } from './services/visitante-guard.service';
import { FormularioComponent } from './modulos/usuario/components/formulario/formulario.component';

const routes: Routes = [

  // TODO: Criar paths separados para admin e usuario com seus respectivos guards
  { path: 'usuario', loadChildren: () => UsuarioModule },
  { path: 'login', component: LoginComponent, },
  { path: 'logout', component: LogoutComponent },
  { path: 'cadastrar', component: FormularioComponent },
  //{ path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'} },
  //{ path: 'login-success', component: LoginSuccessComponent },

]

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule { }
