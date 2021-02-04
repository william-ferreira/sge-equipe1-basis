import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventoUsuarioRoutingModule } from './evento-usuario-routing.module';
import { ListagemComponent } from './components/listagem/listagem.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [ListagemComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    EventoUsuarioRoutingModule,
    SharedModule
  ]
})
export class EventoUsuarioModule { }
