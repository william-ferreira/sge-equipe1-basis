import { HttpErrorResponse } from '@angular/common/http';
import { identifierModuleUrl } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Usuario } from '../dominios/usuario';
import { UsuarioService } from '../modulos/usuario/services/usuario.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  usuarioLogado = new Usuario();

  constructor(public servico: UsuarioService) { }

  async authenticate(chave) {
    
    this.login(chave)
        
    if (this.usuarioLogado.id!=null) {
      return true;
    }
  
  }

  isUserLoggedIn() {
    if (this.usuarioLogado.id!=1 && this.usuarioLogado.id!=null) { // Diferente do ID reservado de administrador
      return true;
    }
  }

  isAdminLoggedIn() {
    if (this.usuarioLogado.id===1) {
      return true;
    }
  }

  isLoggedIn() {
    return ((!this.isUserLoggedIn() && this.isAdminLoggedIn())
     || (this.isUserLoggedIn() && !this.isAdminLoggedIn()))
  }

  login(chave) {
    this.servico.login(chave)
    .subscribe(usuario => {
      this.usuarioLogado = usuario
      
      sessionStorage.setItem('usuario', JSON.stringify(this.usuarioLogado))
    }, (erro: HttpErrorResponse) => {
      alert("Credenciais inválidas. Tente novamente.");
    });
  }

  logOut() {
    sessionStorage.removeItem('usuario')
    this.usuarioLogado = new Usuario();
  }

}
