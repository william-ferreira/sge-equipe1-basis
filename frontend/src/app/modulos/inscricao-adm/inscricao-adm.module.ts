import { SharedModule } from 'src/app/shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { InscricaoAdmRoutingModule } from './inscricao-adm-routing.module';
import { ListagemComponent } from './components/listagem/listagem.component';


@NgModule({
  declarations: [ListagemComponent],
  imports: [
    CommonModule,
    InscricaoAdmRoutingModule,
    SharedModule,
  ]
})
export class InscricaoAdmModule { }
