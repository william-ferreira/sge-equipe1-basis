import { InscricaoService } from './../inscricao-adm/service/inscricao.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventoUsuarioRoutingModule } from './evento-usuario-routing.module';
import { ListagemComponent } from './components/listagem/listagem.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { QuestaoModule } from '../questao/questao.module';
import { ListagemPerguntasUsuarioComponent } from './components/listagem-perguntas-usuario/listagem-perguntas-usuario.component';


@NgModule({
  declarations: [ListagemComponent, ListagemPerguntasUsuarioComponent],
  providers:[InscricaoService],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    EventoUsuarioRoutingModule,
    SharedModule,
    QuestaoModule
  ]
})
export class EventoUsuarioModule { }
