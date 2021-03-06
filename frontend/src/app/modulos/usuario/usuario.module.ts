import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsuarioRoutingModule } from './usuario-routing.module';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListagemComponent } from './components/listagem/listagem.component';
import { CardModule } from 'primeng';
import { SharedModule } from 'src/app/shared/shared.module';
import { UsuarioService } from './services/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CpfPipe } from './components/pipes/cpf.pipe';
import { TelefonePipe } from './components/pipes/telefone.pipe';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PerfilComponent } from './components/perfil/perfil.component';


@NgModule({
  declarations: [
    FormularioComponent, 
    ListagemComponent,
    PerfilComponent, 
    CpfPipe, 
    TelefonePipe, PerfilComponent
  ],
  providers: [
    UsuarioService,
    CpfPipe,
    TelefonePipe
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    UsuarioRoutingModule,
    SharedModule,
    HttpClientModule
  ]
})
export class UsuarioModule { }
