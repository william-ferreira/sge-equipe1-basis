import { Component, Input } from '@angular/core';
import { Pergunta } from 'src/app/dominios/pergunta';
import { PerguntaService } from '../../services/pergunta.service';

@Component({
  selector: 'app-listagem-questao',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent {

  @Input('idEvento') set eventoFn(idEvento: number) {
    if (idEvento) {
      this.buscarPerguntas(idEvento);
    }
  }

  @Input() isAdmin: boolean

  perguntas: Pergunta[] = [];
  pergunta: Pergunta;
  exibirDialog = false;
  idEventoAux: number;
  formularioEdicao: boolean
  isAdim = true;

  constructor(
    private perguntaServico: PerguntaService
  ) { }

  private buscarPerguntas(idEvento: number) {
    this.idEventoAux = idEvento
    this.perguntaServico.getPerguntasIdEvento(idEvento)
      .subscribe((perguntas: Pergunta[]) => {
        this.perguntas = perguntas;
      })
  }

  private mostrarDialogEditar(idPergunta: number) {
    this.perguntaServico.getPerguntaId(idPergunta)
      .subscribe((pergunta => {
        this.pergunta = pergunta
      }))
    this.mostrarDialog(true)
  }

  private mostrarDialog(edicao = false) {
    this.formularioEdicao = edicao;
    this.exibirDialog = true;
  }

  private fecharDialog(perguntaSalva: Pergunta) {
    this.buscarPerguntas(this.idEventoAux)
    this.exibirDialog = false;
  }
}
