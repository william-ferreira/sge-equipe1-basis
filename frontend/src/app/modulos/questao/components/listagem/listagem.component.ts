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
      this.idEventoAux = idEvento
      this.buscarPerguntas(this.idEventoAux);
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
    this.perguntaServico.getPerguntasIdEvento(idEvento)
      .subscribe((perguntas: Pergunta[]) => {
        this.perguntas = perguntas;
      })
  }

  private mostrarDialogEditar(idPergunta: number) {
    this.perguntaServico.getPerguntaId(idPergunta)
      .subscribe((pergunta => {
        this.pergunta = pergunta
        this.mostrarDialog(true)
      }))
  }

  private mostrarDialogCadastro(edicao = false) {
    this.pergunta = new Pergunta;
    this.mostrarDialog();
  }

  private mostrarDialog(edicao = false) {
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }

  private fecharDialog(perguntaSalva: Pergunta) {
    let eventoPergunta = { idEvento: this.idEventoAux, idPergunta: perguntaSalva.id }

    this.perguntaServico.salvarPerguntaEvento(eventoPergunta)
      .subscribe()

    this.buscarPerguntas(this.idEventoAux)
    this.exibirDialog = false;
  }
}
