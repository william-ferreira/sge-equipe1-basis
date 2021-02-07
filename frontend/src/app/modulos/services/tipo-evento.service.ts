import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoEvento } from 'src/app/dominios/tipoEvento';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TipoEventoService {

  url = `${environment.apiUrl}/tipo-evento`;

  constructor(private http: HttpClient) { }

  getTipoEventos(): Observable<TipoEvento[]>{
    return this.http.get<TipoEvento[]>(`${this.url}`);
  }
}
