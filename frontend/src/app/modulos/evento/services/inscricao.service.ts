import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from './../../../../environments/environment';

import { Inscricao } from './../../../dominios/inscricao';
import { DetalhesInscricao } from 'src/app/dominios/detalhesInscricao';
import { PreInscricaoListagem } from './../../../dominios/preInscricaoDetalhes';

@Injectable()
export class InscricaoService {

  url = `${environment.apiUrl}/inscricoes`;

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

  editarInscricao(inscricao: Inscricao): Observable<Inscricao> {
    return this.http.put<Inscricao>(this.url, inscricao);
  }

  deletarInscricao(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
  aprovarInscricaoEvento(idPreInscricao: number): Observable <PreInscricaoListagem>{
    return this.http.patch<PreInscricaoListagem>(`${this.url}/aprovar-inscricao-evento/${idPreInscricao}`, {} );
  }
  
  recusarInscricaoEvento(idPreInscricao: number): Observable <PreInscricaoListagem>{
    return this.http.patch<PreInscricaoListagem>(`${this.url}/recusar-inscricao-evento/${idPreInscricao}`, {} );
  }
 

  buscarDetalhesInscricaoUsuario(idUsuario: number): Observable<DetalhesInscricao[]> {
    return this.http.get<DetalhesInscricao[]>(`${this.url}/detalhes-inscricao/${idUsuario}`);
  }

  obterListagemPorIdUsuario(idUsuario: number): Observable<PreInscricaoListagem[]> {
    return this.http.get<PreInscricaoListagem[]>(`${this.url}/inscricoes-usuario/${idUsuario}/listagem`);
  }

  buscarDetalhesInscricaoEvento(idEvento: number): Observable<Inscricao[]> {
    return this.http.get<Inscricao[]>(`${this.url}/detalhes-inscricao/${idEvento}`);
  }


}
