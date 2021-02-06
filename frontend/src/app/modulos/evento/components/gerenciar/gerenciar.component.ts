import { Component, Input, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { Evento } from 'src/app/dominios/evento';
import { InscricaoService } from '../../services/inscricao.service';
import { Inscricao } from './../../../../dominios/inscricao';
import { PreInscricaoListagem } from './../../../../dominios/preInscricaoDetalhes';


@Component({
  selector: 'app-gerenciar',
  templateUrl: './gerenciar.component.html',
  styleUrls: ['./gerenciar.component.css']
})
export class GerenciarComponent implements OnInit {
  @Input('idEvento') set eventoFn(idEvento: number) {
    this.IdentificarInscricoesEvento(idEvento);
  }

  @Input() inscricao = new Inscricao();

  inscricoes: Inscricao[] = [];
  inscricoesEvento: Inscricao[] = [];
  eventosInscricao: Evento[] = [];
  detalhesPreInscricao: PreInscricaoListagem[] = [];
  exibirDialog = false;
  formularioEdicao: boolean;


  constructor(
    private servico: InscricaoService,
    private confirmationService: ConfirmationService,
   

  ) { }

  ngOnInit(): void {

  }
  private buscarInscricoes() {
    this.servico.getInscricoes()
      .subscribe((inscricoes: Inscricao[]) => {
        this.inscricoes = inscricoes;
      });
  }

  buscarDetalhesInscricaoEvento() {
    for (let inscricaoEvento of this.inscricoesEvento) {
      if (inscricaoEvento.idTipoSituacao === 1) {
        console.log(inscricaoEvento);
        this.servico.obterListagemPorIdUsuario(inscricaoEvento.idUsuario)
          .subscribe(listagem => this.detalhesPreInscricao = listagem);
        console.log(this.detalhesPreInscricao);
      }
    }

  }
  
  confirmarDeletarInscricao(id: number) {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja cancelar a Inscrição?',
      accept: () => {
        this.deletarInscricao(id);
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

  IdentificarInscricoesEvento(idEvento: number) {
    this.inscricoesEvento = []
    this.servico.getInscricoes()
      .subscribe((inscricoes: Inscricao[]) => {
        for (let inscricao of inscricoes) {
          if (inscricao.idEvento === idEvento) {
            if (inscricao.idTipoSituacao === 1) {
              this.inscricoesEvento.push(inscricao)
            }
          }
        }
        this.buscarDetalhesInscricaoEvento();
      })
  }

  recusarInscricao(preInscricaoListagem: PreInscricaoListagem) {
    console.log(preInscricaoListagem)
    this.servico.recusarInscricaoEvento(preInscricaoListagem.id)
      .subscribe(() => {
        alert('Inscricao Recusada');
        this.buscarDetalhesInscricaoEvento();
      })
  }


  aprovarInscricao(preInscricaoListagem: PreInscricaoListagem) {


    this.servico.aprovarInscricaoEvento(preInscricaoListagem.id)
      .subscribe(() => {
        alert('Inscricao Aprovada');
        this.buscarDetalhesInscricaoEvento();
      })
  }



mostrarDialog(edicao = false) {
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }


  fecharDialog(inscricaoSalva: Inscricao) {
    this.exibirDialog = false;
    this.buscarInscricoes();
  }


}
