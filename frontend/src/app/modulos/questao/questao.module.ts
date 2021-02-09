import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ListagemComponent } from './components/listagem/listagem.component';
import { QuestaoRoutingModule } from './questao-routing.module';
import { FormularioComponent } from './components/formulario/formulario.component';
import { PerguntaService } from './services/pergunta.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [ListagemComponent, FormularioComponent],
  providers: [
    PerguntaService
  ],
  imports: [
    CommonModule,
    QuestaoRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    ListagemComponent,
    FormularioComponent,
   
  ]
})
export class QuestaoModule { }
