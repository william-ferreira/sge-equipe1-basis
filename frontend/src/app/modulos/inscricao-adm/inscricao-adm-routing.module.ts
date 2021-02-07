import { InscricaoService } from './../inscricao-adm/service/inscricao.service';
import { ListagemComponent } from './../inscricao-adm/components/listagem/listagem.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
{
  path:'',
  component:ListagemComponent
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers:[InscricaoService]
})
export class InscricaoAdmRoutingModule { }
