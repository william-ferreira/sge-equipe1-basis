import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Evento } from 'src/app/dominios/evento';
import { EventoService } from '../../services/evento-service/evento.service';
import { HttpErrorResponse } from '@angular/common/http';
import { TipoEvento } from 'src/app/dominios/tipoEvento';
import { TipoEventoService } from 'src/app/modulos/evento/services/tipo_evento/services/tipo-evento.service';
import { ActivatedRoute } from '@angular/router';
import { SelectItem } from 'primeng';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  @Input() evento = new Evento();
  @Input() edicao = false;
  @Output() eventoSalvo = new EventEmitter<Evento>();

  formEvento: FormGroup;
  tiposEventos: TipoEvento[] = [];

  tipos: SelectItem[] = [];

  constructor(
    private fb: FormBuilder,
    private eventoService: EventoService,
    private tipoEventoService: TipoEventoService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.listarTiposEventos();

    this.route.params.subscribe(params => {
      if (params.id) {
        this.edicao = true;
        this.buscarEvento(params.id);
      }
    });

    this.formEvento = this.fb.group({
      titulo: ['', Validators.required],
      dataInicio: ['', Validators.required],
      dataTermino: ['', Validators.required],
      descricao: '',
      quantVagas: '',
      valor: '',
      localEvento: '',
      tipoInscricao: '',
      idTipoEvento: ['', Validators.required],
    });
  }

  buscarEvento(id: number) {
    this.eventoService.buscarEventoPorId(id)
      .subscribe(evento => {
        this.evento = evento;
      })
  }

  listarTiposEventos() {
    this.tipoEventoService.getTipoEventos()
      .subscribe(tipos => {
        this.tiposEventos = tipos;
        this.tipos = this.tiposEventos.map(tipo => {
          return {
            value: tipo.id,
            label: tipo.descricao
          }
        })
      });
  }

  salvar() {
    if (this.formEvento.invalid) {
      alert('Formulário inválido');
      return;
    }

    if (this.edicao) {
      this.eventoService.editarEvento(this.evento)
        .subscribe(evento => {
          alert('Evento Editado');
          this.fecharDialog(evento);
        }, (err: HttpErrorResponse) => {
          alert(err.error.message);
        });
    }
    else {
      this.eventoService.salvarEvento(this.evento)
        .subscribe(evento => {
          alert('Evento Salvo');
          this.fecharDialog(evento);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
  }

  fecharDialog(eventoSalvo: Evento) {
    this.eventoSalvo.emit(eventoSalvo);
  }

  dataTerminoMaiorDataInicio() {
    return this.evento.dataTermino && this.evento.dataInicio && this.evento.dataTermino >= this.evento.dataInicio;
  }

}
