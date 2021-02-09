import { UsuarioService } from './services/usuario.service';
import { InscricaoService } from './services/inscricao.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventoRoutingModule } from './evento-routing.module';
import { FormularioComponent } from './components/formulario/formulario.component';
import { ListagemComponent } from './components/listagem/listagem.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventoService } from './services/evento-service/evento.service';
import { QuestaoModule } from '../questao/questao.module';

import { InscreverComponent } from './components/inscrever/inscrever.component';
import { SidebarModule } from 'primeng/sidebar';
import { VirtualScrollerModule } from 'primeng/virtualscroller';
import { GerenciarComponent } from './components/gerenciar/gerenciar.component';

@NgModule({
  declarations: [FormularioComponent, ListagemComponent, InscreverComponent, GerenciarComponent,],
  providers: [
    EventoService, InscricaoService, UsuarioService
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    EventoRoutingModule,
    SharedModule,
    QuestaoModule,
    SidebarModule,
    VirtualScrollerModule,
    SharedModule,
  ]
})
export class EventoModule { }
