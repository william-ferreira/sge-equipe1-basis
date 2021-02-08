import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EventoPergunta } from 'src/app/dominios/eventoPergunta';
import { Pergunta } from 'src/app/dominios/pergunta';
import { PerguntaService } from '../../services/pergunta.service';

@Component({
  selector: 'app-formulario-questao',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  @Input('idPergunta') set eventoFn(idPergunta: number) {
    if (idPergunta) {
      this.buscarPergunta(idPergunta);
    }
  }
  
  @Input() edicao = false
  @Output() perguntaSalva = new EventEmitter<Pergunta>();

  pergunta: Pergunta
  formPergunta: FormGroup

  constructor(
    private fb: FormBuilder,
    private perguntaService: PerguntaService
  ) { }

  ngOnInit(): void {
    this.pergunta = new Pergunta()
    this.carregarForm()
  }

  salvar() {
    if (this.edicao) {
      alert('Edicao da pergunta')

    } else {
      this.perguntaService.salvarPergunta(this.pergunta)
        .subscribe(pergunta => {
          alert('Pergunta Salva')
          this.fecharDialog(pergunta)
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message)
        })
    }
  }

  buscarPergunta(idPergunta: number) {
    this.perguntaService.getPerguntaId(idPergunta)
      .subscribe(pergunta => {
        this.pergunta = pergunta;
      })
  }

  fecharDialog(perguntaSalva: Pergunta) {
    this.carregarForm()
    alert('Inscrição realizada com sucesso.')
    this.perguntaSalva.emit(perguntaSalva);
  }

  carregarForm() {
    this.formPergunta = this.fb.group({
      titulo: '',
      obrigatoriedade: '',
    });
  }

}
