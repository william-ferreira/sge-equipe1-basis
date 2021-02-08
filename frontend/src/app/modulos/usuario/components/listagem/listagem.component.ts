import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from 'src/app/dominios/usuario';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})

export class ListagemComponent implements OnInit {

  usuarios: Usuario[] = [];
  usuario = new Usuario();
  exibirDialog = false;
  formEdicao: boolean;

  constructor(
    public servico: UsuarioService,
    public confirmationService: ConfirmationService,
  ) { }

  ngOnInit(): void {
    this.buscarUsuarios();
  }

  private buscarUsuarios() {
    this.servico.getUsuarios()
    .subscribe((usuarios: Usuario[]) => {
      this.usuarios = usuarios;
    });
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
    this.buscarUsuarios();
  }

  confirmarExcluirUsuario(id: number) {
    this.confirmationService.confirm({
        message: 'Tem certeza que deseja excluir o usuário?',
        accept: () => {
          this.removerUsuario(id);
        }
    });
  }

  removerUsuario(id?: number) {
    this.servico.removerUsuario(id)
      .subscribe(() => {
        this.buscarUsuarios();
      },
      erro => alert(erro));
  }

}
