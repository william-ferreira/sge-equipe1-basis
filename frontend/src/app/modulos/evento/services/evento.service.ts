import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {Evento} from 'src/app/dominios/evento';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  url = `${environment.apiUrl}/eventos`;

  constructor(private http: HttpClient) { }

  getEventos(): Observable<Evento[]>{
    return this.http.get<Evento[]>(`${this.url}`);
  }

  salvarEvento(evento: Evento): Observable<Evento>{
    return this.http.post<Evento>(this.url, evento);
  }
}


