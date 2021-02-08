import { EventoService } from './../../../inscricao-adm/service/evento.service';
import { ConfirmationService } from 'primeng';
import { InscricaoService } from './../../../inscricao-adm/service/inscricao.service';
import { Component, OnInit } from '@angular/core';
import { Evento } from 'src/app/dominios/evento';
import { Inscricao } from './../../../../dominios/inscricao';
import { DetalhesInscricao } from 'src/app/dominios/detalhesInscricao';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {
  inscricoes: Inscricao[] = [];
  inscricoesUsuario: DetalhesInscricao[] = [];
  inscricoesEvento: Inscricao[] = [];
  evento = new Evento();
  eventos: Evento[] = [];
  inscricao = new Inscricao();
  exibirDialog = false;
  formularioEdicao: boolean;
  constructor(
    private servico: InscricaoService,
    private confirmationService: ConfirmationService,
    private servicoEvento: EventoService,
  ) { }

  ngOnInit(): void {
    this.buscarInscricoesUsuario(4);
  }
  private buscarInscricoes() {
    this.servico.getInscricoes()
      .subscribe((inscricoes: Inscricao[]) => {
        this.inscricoes = inscricoes;
        console.log(this.inscricoes)
      });

  }

  private buscarInscricoesUsuario(idUsuario: number) {
    this.servico.buscarDetalhesInscricaoUsuario(idUsuario)
      .subscribe((detalheInscricoesUsario: DetalhesInscricao[]) => {
        this.inscricoesUsuario = detalheInscricoesUsario
        console.log(this.inscricoesUsuario)
      })
  }

  mostrarDialog(edicao = false) {
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }

  fecharDialog(inscricaoSalva: Inscricao) {
    console.log(inscricaoSalva);
    this.exibirDialog = false;
    this.buscarInscricoes();
  }

  confirmarDeletarInscricao(id: number) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja cancelar a Inscrição?',
      accept: () => {
        console.log(id)
        this.deletarInscricao(id);
      }
    });
  }

  cancelarInscricao(detalheInscricao: DetalhesInscricao) {
    console.log(detalheInscricao);

    this.confirmationService.confirm({
      message: 'Tem certeza que deseja cancelar a Inscrição?',
      accept: () => {
        this.servico.cancelarInscricaoEvento(detalheInscricao)
          .subscribe(() => {
            alert('Inscricao cancelada');
            this.buscarInscricoesUsuario(3);
          })
      }
    });
  }

  deletarInscricao(id?: number) {
    this.servico.deletarInscricao(id)
      .subscribe(() => {
        alert('Inscricao cancelada');
        this.buscarInscricoes();
      },
        err => alert(err));
  }

  listarInscricoesUsuario(id: number) {

    this.servico.getInscricoes()
      .subscribe((inscricoes: Inscricao[]) => {
        let aux: Inscricao[] = []
        for (let inscricao of inscricoes) {
          if (inscricao.idUsuario === id) {
            for (let evento of this.eventos) {
              if (evento.id === inscricao.idEvento) {
                this.evento = evento
              }
            }
          }
        }
        this.inscricoes = aux;

      })

  }
}
