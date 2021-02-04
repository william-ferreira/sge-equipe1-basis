import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventoRoutingModule } from './evento-routing.module';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListagemComponent } from './components/listagem/listagem.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventoService } from './services/evento-service/evento.service';


@NgModule({
  declarations: [FormularioComponent, ListagemComponent],
  providers:[
    EventoService
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    EventoRoutingModule,
    SharedModule
  ]
})
export class EventoModule { }
