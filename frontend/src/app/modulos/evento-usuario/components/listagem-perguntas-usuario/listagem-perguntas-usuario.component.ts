import { Component,Input } from '@angular/core';
import { Pergunta } from 'src/app/dominios/pergunta';
import { PerguntaService } from '../../../questao/services/pergunta.service';
import { Resposta } from 'src/app/dominios/resposta';
import { InscricaoService }from '../../../inscricao-adm/service/inscricao.service'


@Component({
  selector: 'app-listagem-perguntas-usuario',
  templateUrl: './listagem-perguntas-usuario.component.html',
  styleUrls: ['./listagem-perguntas-usuario.component.css']
})
export class ListagemPerguntasUsuarioComponent {

  
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
  idInscricao = 1;
  resposta: String;
  perguntasResposta: Resposta[] = [];
  
  

  constructor(
    private perguntaServico: PerguntaService,
    private inscricaoSerico: InscricaoService
  ) { }



  private buscarPerguntas(idEvento: number) {

    this.perguntaServico.getPerguntasIdEvento(idEvento)
      .subscribe((perguntas: Pergunta[]) => {
        this.perguntas = perguntas;
        this.construirPerguntaResposta()
      })
  }

  private construirPerguntaResposta() {
    this.perguntasResposta = [];
    this.perguntas.forEach(pergunta => {
      let perguntaResposta: Resposta = { 
        idInscricao: this.idInscricao,
        titulo: pergunta.titulo,
        resposta: '',
        idEvento: this.idEventoAux ,
        idPergunta: pergunta.id
      }
      console.log(perguntaResposta);
      
      this.perguntasResposta.push(perguntaResposta)
    });
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

  fecharDialog(perguntaSalva: Pergunta) {
    let eventoPergunta = { idEvento: this.idEventoAux, idPergunta: perguntaSalva.id }

    this.perguntaServico.salvarPerguntaEvento(eventoPergunta)
      .subscribe()

    this.buscarPerguntas(this.idEventoAux)
    this.exibirDialog = false;
  }


  
}