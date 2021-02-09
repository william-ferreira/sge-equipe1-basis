import { Component,Input, Output } from '@angular/core';
import { Pergunta } from 'src/app/dominios/pergunta';
import { PerguntaService } from '../../../questao/services/pergunta.service';
import { Resposta } from 'src/app/dominios/resposta';
import { InscricaoService }from '../../../inscricao-adm/service/inscricao.service'
import { InscricaoResposta } from 'src/app/dominios/inscricao-resposta';
import { Inscricao } from 'src/app/dominios/inscricao';
import { EventEmitter } from 'events';
import { Usuario } from 'src/app/dominios/usuario';
import { HttpErrorResponse } from '@angular/common/http';


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

  @Input('resposta') set respostaFn(resposta: string){
    if(resposta){
      this.resposta = resposta;
      this.respostas.push(resposta);      
    }
  }

  perguntas: Pergunta[] = [];
  pergunta: Pergunta;
  exibirDialog = false;
  idEventoAux: number;
  formularioEdicao: boolean
  isAdim = true;
  idInscricao = 1;
  resposta: string;
  respostas: string[] = [];
  perguntasResposta: InscricaoResposta[] = [];

  idInscricaoAux: number;
  
  constructor(
    private perguntaServico: PerguntaService,
    private inscricaoServico: InscricaoService,
  ) { }

  private buscarPerguntas(idEvento: number) {

    this.perguntaServico.getPerguntasIdEvento(idEvento)
      .subscribe((perguntas: Pergunta[]) => {
        this.perguntas = perguntas;
        this.construirPerguntaResposta()
      })
  }

  public construirInscricao(){
    let inscricao = new Inscricao();

    let usuario = new Usuario();
    usuario = JSON.parse(sessionStorage.getItem('usuario'));

    this.construirPerguntaResposta();
    
    inscricao.resposta = this.perguntasResposta;
    inscricao.idEvento = this.idEventoAux;
    inscricao.idUsuario = usuario.id;
    inscricao.idTipoSituacao = 1;
    inscricao.id = null;    

    this.inscricaoServico.salvarInscricao(inscricao)
    .subscribe(inscricao => {
      this.idInscricaoAux = inscricao.id;
      console.log("Inscricao Pré-pergunta: ",inscricao);

      this.salvaInscricaoResposta(this.idInscricaoAux);
      alert("Inscrição realizada com sucesso!")
      this.fecharDialogInscricao();
    }, (erro: HttpErrorResponse) => {
      alert(erro.error.message);
    });
  }

  private salvaInscricaoResposta(idInscricao: number){
    this.perguntasResposta.forEach(resposta =>{
      resposta.idInscricao = idInscricao;
      console.log(resposta);
      
      this.inscricaoServico.salvarInscricaoResposta(resposta).subscribe();
    });
  }

  private construirPerguntaResposta() {
    this.perguntasResposta = [];
    this.perguntas.forEach(pergunta => {
      let inscricaoResposta: InscricaoResposta = { 
        idInscricao: null,
        resposta: pergunta.resposta,
        idEvento: this.idEventoAux ,
        idPergunta: pergunta.id
      }
      console.log(inscricaoResposta);
      
      this.perguntasResposta.push(inscricaoResposta)
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

  fecharDialogInscricao(){
    this.exibirDialog = false;
  }

  fecharDialog(perguntaSalva: Pergunta) {
    let eventoPergunta = { idEvento: this.idEventoAux, idPergunta: perguntaSalva.id }

    this.perguntaServico.salvarPerguntaEvento(eventoPergunta)
      .subscribe()

    this.buscarPerguntas(this.idEventoAux)
    this.exibirDialog = false;
  } 
}