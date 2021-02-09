import { Component, OnInit } from '@angular/core';
import { Evento } from 'src/app/dominios/evento';
import { EventoService } from 'src/app/modulos/evento/services/evento-service/evento.service';
import { InscricaoService } from '../../../inscricao-adm/service/inscricao.service'

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  eventos: Evento[] = [];
  exibirDialogPergunta = false;
  idEventoSel: number;
  resposta: string;

  constructor(
    private eventoServico: EventoService,
    private inscricaoServico: InscricaoService,
  ) { }

  ngOnInit(): void {
    this.buscarEventos();
  }

  private buscarEventos(){
    this.eventoServico.getEventos()
    .subscribe((eventos: Evento[])=>{
        this.eventos = eventos;
    });
  }

  mostrarDialogPergunta(id: number) {
    this.exibirDialogPergunta = true;
  }

  mostrarDialogPerguntasPorEvento(idEvento: number) {
    this.idEventoSel = idEvento;
    this.mostrarDialogPergunta(this.idEventoSel);
  }

  inscreverEvento(){
    let inscricaoUsuario = {id:null,idTipoSituacao:1,idUsuario:4,idEvento:this.idEventoSel,resposta:[]}
    this.inscricaoServico.salvarInscricao(inscricaoUsuario)
    .subscribe(idInscricao => {console.log(idInscricao)
    })
  }

}
