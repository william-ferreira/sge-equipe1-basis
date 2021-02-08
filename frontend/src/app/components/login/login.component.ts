import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  chave = ''

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin() {
    if (this.loginservice.authenticate(this.chave)) {
      this.router.navigate([''])
    } else {
      alert("Credenciais de acesso inválidas. Por favor, tente novamente.")
    }
  }

  cadastrar() {
    this.router.navigate(['usuario/cadastrar'])
  }

}
