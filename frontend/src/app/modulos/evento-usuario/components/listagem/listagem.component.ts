import { Component, OnInit } from '@angular/core';
import { Evento } from 'src/app/dominios/evento';
import { EventoService } from 'src/app/modulos/evento/services/evento-service/evento.service';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  eventos: Evento[] = [];
  exibirDialogPergunta = false;
  idEventoSel: number;

  constructor(
    private eventoServico: EventoService,
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
    console.log("entrou")
    this.exibirDialogPergunta = true;
  }

  mostrarDialogPerguntasPorEvento(idEvento: number) {
    this.idEventoSel = idEvento;
    this.mostrarDialogPergunta(this.idEventoSel);
  }

}
