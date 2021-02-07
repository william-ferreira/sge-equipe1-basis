import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { Evento } from 'src/app/dominios/evento';
import { EventoService } from '../../services/evento-service/evento.service';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css'],
})
export class ListagemComponent implements OnInit {

  visibleSidebar3;
  visibleSidebar4;

  eventos: Evento[] = [];
  evento = new Evento();
  exibirDialogEvento = false;
  formularioEdicao: boolean;
  exibirDialogPergunta: boolean;

  idEventoSel: number;
  idEvento: number;

  constructor(
    private servico: EventoService,
    private confirmationService: ConfirmationService,
  ) { }

  ngOnInit(): void {
    this.buscarEventos();
  }

  private buscarEventos() {
    this.servico.getEventos()
      .subscribe((eventos: Evento[]) => {
        this.eventos = eventos;
      });
  }

  mostrarDialogEditar(id: number) {
    this.servico.buscarEventoPorId(id)
      .subscribe(evento => {
        this.evento = evento;
        this.mostrarDialogEvento(true);
      });
  }

  mostrarDialogCadastroEvento() {
    this.evento = new Evento();
    this.mostrarDialogEvento();
  }

  mostrarDialogEvento(edicao = false) {
    this.exibirDialogEvento = true;
    this.formularioEdicao = edicao;
  }

  mostrarSideBar(idEvento: number) {
    this.servico.buscarEventoPorId(idEvento)
      .subscribe(evento => {
        this.evento = evento;
      });

    this.visibleSidebar4 = true
    this.idEventoSel = idEvento
  }


  fecharDialog(eventoSalvo: Evento) {
    this.exibirDialogEvento = false;
    this.buscarEventos();
  }
  mostrarDialogPerguntas() {
    this.exibirDialogPergunta = true;
  }

  confirmarDeletarEvento(id: number) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir o evento?',
      accept: () => {
        this.deletarEvento(id);
      }
    })
  }

  deletarEvento(id: number) {
    this.servico.deletarEvento(id)
      .subscribe(() => {
        alert('Evento Deletado');
        this.buscarEventos();
      },
        err => alert(err));
  }

  mostrarDialogPergunta(id: number) {
    this.exibirDialogPergunta = true;
  }

  mostrarDialogPerguntasPorEvento(idEvento: number) {
    this.idEventoSel = idEvento;
    this.mostrarDialogPergunta(this.idEventoSel);
  }

}
