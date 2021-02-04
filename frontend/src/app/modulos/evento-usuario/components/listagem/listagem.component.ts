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

}
