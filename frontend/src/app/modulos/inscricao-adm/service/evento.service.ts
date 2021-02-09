import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Evento } from 'src/app/dominios/evento';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class EventoService {

  url = `${environment.apiUrl}/eventos`;

  constructor(private http: HttpClient) { }

  getEventos(): Observable<Evento[]>{
    return this.http.get<Evento[]>(`${this.url}`);
  }

  buscarEventoPorId(id:number):Observable<Evento>{
    return this.http.get<Evento>(`${this.url}/${id}`);
  }

  salvarEvento(evento: Evento): Observable<Evento>{
    return this.http.post<Evento>(`${this.url}`, evento);
  }
}