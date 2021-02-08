import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/dominios/usuario';
import { environment } from 'src/environments/environment'

@Injectable()
export class UsuarioService {

  url = `${environment.apiUrl}/usuarios`;
  urlLogin = `${environment.apiUrl}/login`; // modularizar em outro serviço próprio de login

  constructor(private http: HttpClient) {  }

  buscarUsuarioPorId(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/${id}`)
  }

  login(key: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.urlLogin}/${key}`)
  }

  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.url}`)
  }

  salvarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(this.url, usuario);
  }

  editarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(this.url, usuario);
  }

  removerUsuario(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

}
