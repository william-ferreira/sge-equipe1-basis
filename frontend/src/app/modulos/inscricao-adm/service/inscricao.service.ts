import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from './../../../../environments/environment';

import { Inscricao } from './../../../dominios/inscricao';
import { DetalhesInscricao } from 'src/app/dominios/detalhesInscricao';
import { InscricaoResposta } from 'src/app/dominios/inscricao-resposta';

@Injectable()
export class InscricaoService {

  url = `${environment.apiUrl}/inscricoes`;
  urlInscricaReposta = `${environment.apiUrl}/respostas`

  constructor(private http: HttpClient) { }

  buscarInscricaoPorId(id: number): Observable<Inscricao> {
    return this.http.get<Inscricao>(`${this.url}/${id}`);
  }
  getInscricoes(): Observable<Inscricao[]> {
    return this.http.get<Inscricao[]>(`${this.url}`);
  }

  salvarInscricao(inscricao: Inscricao): Observable<Inscricao> {
    return this.http.post<Inscricao>(this.url, inscricao);
  }

  salvarInscricaoResposta(inscricaoResposta: InscricaoResposta): Observable<InscricaoResposta>{
    return this.http.post<InscricaoResposta>(this.urlInscricaReposta, inscricaoResposta);
  }

  // editarUsuario(usuario: Usuario): Observable<Usuario> {
  //   return this.http.put<Usuario>(this.url, usuario);
  // }
  cancelarInscricaoEvento(detalhesInscricao: DetalhesInscricao): Observable <DetalhesInscricao>{
    return this.http.put<DetalhesInscricao>(`${this.url}/cancelar-inscricao-evento/`,detalhesInscricao );
  }


  deletarInscricao(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  buscarDetalhesInscricaoUsuario(idUsuario: number): Observable<DetalhesInscricao[]> {
    return this.http.get<DetalhesInscricao[]>(`${this.url}/detalhes-inscricao/${idUsuario}`);
  }

  buscarDetalhesInscricaoEvento(idEvento: number): Observable<Inscricao[]> {
    return this.http.get<Inscricao[]>(`${this.url}/detalhes-inscricao/${idEvento}`);
  }


}
