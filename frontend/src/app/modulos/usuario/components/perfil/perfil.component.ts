import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { Usuario } from 'src/app/dominios/usuario';
import { UsuarioService } from '../../services/usuario.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  usuario = new Usuario();
  usuarioLogado = JSON.parse(sessionStorage.getItem('usuario'))

  exibirDialog = false;
  formEdicao: boolean;
  
  constructor(
    public servico: UsuarioService,
    public confirmationService: ConfirmationService,
  ) { }

  ngOnInit(): void {
    console.log(this.usuario);
    this.buscarUsuario();
    console.log(this.usuario);
  }

  private buscarUsuario() {
    this.servico.buscarUsuarioPorId(this.usuarioLogado.id)
    .subscribe((usuario => {
      this.usuario = usuario
    }));
  }

  abrirDialogEditar(id: number) {
    this.servico.buscarUsuarioPorId(id)
      .subscribe(usuario => {
        this.usuario = usuario
        this.abrirDialog(true);
      }); 
  }

  abrirDialog(edicao = false) {
    this.exibirDialog = true;
    this.formEdicao = edicao;
  }

  fecharDialog(usuarioSalvo: Usuario) {
    console.log(usuarioSalvo);
    this.exibirDialog = false;
    this.buscarUsuario();
  }

  confirmarExcluirUsuario(id: number) {
    this.confirmationService.confirm({
        message: 'Tem certeza que deseja excluir sua conta?',
        accept: () => {
          this.removerUsuario(id);
        }
    });
  }

  removerUsuario(id?: number) {
    this.servico.removerUsuario(id)
      .subscribe(() => {
        this.buscarUsuario();
      },
      erro => alert(erro));
  }

}
