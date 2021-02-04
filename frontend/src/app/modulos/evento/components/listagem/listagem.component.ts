import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { Evento } from 'src/app/dominios/evento';
import { EventoService } from '../../services/evento-service/evento.service';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  eventos: Evento[] = [];
  evento = new Evento();
  exibirDialog = false;
  formularioEdicao: boolean;

  constructor(
    private servico : EventoService,
    private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
    this.buscarEventos();       
  }

  private buscarEventos(){
    this.servico.getEventos()
    .subscribe((eventos: Evento[])=>{
        this.eventos = eventos;
    });
  }

  mostrarDialogEditar(id: number){
    this.servico.buscarEventoPorId(id)
    .subscribe(evento => {
      this.evento = evento;
      this.mostrarDialog(true);
    });
  }

  mostrarDialogCadastro(){
    this.evento = new Evento();
    this.mostrarDialog();
  }

  mostrarDialog(edicao = false){
    this.exibirDialog = true;
    this.formularioEdicao = edicao;
  }

  fecharDialog(eventoSalvo: Evento){
    this.exibirDialog = false;
    this.buscarEventos();
  }
  
  confirmarDeletarEvento(id: number){
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir o evento?',
      accept: () =>{
          this.deletarEvento(id);
      }
    })
  }

  deletarEvento(id: number){
    this.servico.deletarEvento(id)
    .subscribe( () => {
        alert('Evento Deletado');
        this.buscarEventos();
    },
    err => alert(err));
  }

}
