import { HttpClient, HttpParams } from '@angular/common/http';
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

  findId(id:number): Observable<Cerveja>{
    return this.httpClient.get<Cerveja>(`${this.baseURL}${"/"}${id}`);
  }

  findByName(nome: string): Observable<Cerveja[]> {
    const params = new HttpParams().set('nome', nome); // Cria um objeto de parâmetros com o nome como um RequestParam
    return this.httpClient.get<Cerveja[]>(`${this.baseURL}/buscarpornome`, { params });
  }

  findAll(): Observable<Cerveja[]>{
    return this.httpClient.get<Cerveja[]>(`${this.baseURL}`);
  }


}
