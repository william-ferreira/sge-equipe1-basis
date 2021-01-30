import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Evento } from 'src/app/dominios/evento';
import { EventoService } from '../../services/evento.service';
import { HttpErrorResponse } from '@angular/common/http';
import { TipoEvento } from 'src/app/dominios/tipoEvento';
import { TipoEventoService } from 'src/app/modulos/tipo_evento/services/tipo-evento.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  formEvento: FormGroup;
  evento = new Evento();
  
  tiposEventos: TipoEvento[] = [];
  tipoEventoSelecionado: TipoEvento;

  constructor( 
    private fb: FormBuilder,
    private eventoService: EventoService,
    private tipoEventoService: TipoEventoService
  ) { }

  ngOnInit(): void {
    this.listarTiposEventos();    
    this.formEvento = this.fb.group({
      titulo: '',
      dataInicio: '',
      dataTermino: '', 
      descricao: '',
      quantVagas: '',
      valor: '',
      localEvento: '',
      tipoEvento: ''
    });
  }

  listarTiposEventos(){
    this.tipoEventoService.getTipoEventos()
    .subscribe(tipos=>{
      this.tiposEventos = tipos;
    });
  }  

  salvar() {
    if (this.formEvento.invalid) {
      alert('Formulário inválido');
      return;
    }
    
    this.evento.setIdTipoEvento(this.tipoEventoSelecionado.id);    

    this.eventoService.salvarEvento(this.evento)
      .subscribe(evento => {
        console.log('Evento salvo', evento);
        console.log(this.evento);
        alert('Evento Salvo')
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
  }

}
