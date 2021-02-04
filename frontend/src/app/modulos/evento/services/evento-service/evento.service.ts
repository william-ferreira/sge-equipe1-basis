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
    return this.http.get<Evento[]>(this.url);
  }
  
  buscarEventoPorId(id: number): Observable<Evento>{
    return this.http.get<Evento>(`${this.url}/${id}`);
  }

  salvarEvento(evento: Evento): Observable<Evento>{
    return this.http.post<Evento>(this.url, evento);
  }

  editarEvento(evento: Evento): Observable<Evento>{
    return this.http.put<Evento>(this.url, evento);
  }

  deletarEvento(id:number): Observable<any>{
    return this.http.delete(`${this.url}/${id}`);
  }
}


