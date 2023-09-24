import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cerveja } from 'src/app/models/cervejaModel';

@Injectable({
  providedIn: 'root'
})
export class CervejasService {

  private baseURL:string = 'http://localhost:8080/cervejas';

  constructor(private httpClient:HttpClient) {

  }

  findByName(nome:string): Observable<Cerveja[]>{
    return this.httpClient.get<Cerveja[]>(`${this.baseURL}${"/find-nome"}${nome}`);
  }

  findAll(): Observable<Cerveja[]>{
    return this.httpClient.get<Cerveja[]>(`${this.baseURL}`);
  }


}
