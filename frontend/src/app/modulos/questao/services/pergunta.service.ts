import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EventoPergunta } from 'src/app/dominios/eventoPergunta';
import { Pergunta } from 'src/app/dominios/pergunta';
import { environment } from 'src/environments/environment';

@Injectable()
export class PerguntaService {

  url = `${environment.apiUrl}/perguntas`
  urlEventoPergunta = `${environment.apiUrl}/evento-pergunta`

  constructor(private http: HttpClient) { }

  getPerguntas(): Observable<Pergunta[]> {
    return this.http.get<Pergunta[]>(this.url);
  }

  getPerguntaId(id: number): Observable<Pergunta> {
    return this.http.get<Pergunta>(`${this.url}/${id}`);
  }

  salvarPergunta(pergunta: Pergunta): Observable<Pergunta> {
    return this.http.post<Pergunta>(this.url, pergunta)
  }

  editarPergunta(pergunta: Pergunta): Observable<Pergunta> {
    return this.http.put<Pergunta>(this.url, pergunta)
  }

  getPerguntasIdEvento(id: number): Observable<Pergunta[]> {
    return this.http.get<Pergunta[]>(`${this.url}/evento-pergunta/${id}`);
  }

  salvarPerguntaEvento(eventoPergunta: EventoPergunta): Observable<EventoPergunta> {
    return this.http.post<EventoPergunta>(this.urlEventoPergunta, eventoPergunta);
  }
}
