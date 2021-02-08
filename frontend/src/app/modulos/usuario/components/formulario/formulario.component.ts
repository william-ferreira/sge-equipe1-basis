import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { isValidDate } from '@fullcalendar/core';
import { Usuario } from 'src/app/dominios/usuario';
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  @Input() edicao = false;
  @Input() usuario = new Usuario();
  @Output() usuarioSalvo = new EventEmitter<Usuario>();

  formUsuario: FormGroup;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      if (params.id) {
        this.edicao = true;
        this.buscarUsuario(params.id);
      }
    });

    this.formUsuario = this.fb.group({
      nome: ['', Validators.minLength(3)],
      cpf: '',
      email: '',
      telefone: '',
      dataNascimento: ['', isValidDate],
    });
  }

  buscarUsuario(id: number) {
    this.usuarioService.buscarUsuarioPorId(id)
      .subscribe(usuario => this.usuario = usuario);
  }

  salvar() {
    if (this.formUsuario.invalid) {
      alert('Formulário inválido')
      return;
    } else if (this.edicao) {
      this.usuarioService.editarUsuario(this.usuario)
        .subscribe(usuario => {
          alert('Usuário editado com sucesso.');
          this.fecharDialog(usuario);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    } else {
      this.usuarioService.salvarUsuario(this.usuario)
        .subscribe(usuario => {
          console.log(usuario)
          console.log('usuário salvo', usuario);
          alert('Usuário salvo')
        }, (erro: HttpErrorResponse) => {
          console.log(this.usuario)
          console.log(erro);
          alert(erro.error.message);
        });
    }
  }

  fecharDialog(usuarioSalvo: Usuario) {
    this.usuarioSalvo.emit(usuarioSalvo);
  }
}
