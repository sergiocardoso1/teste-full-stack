import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Comentario } from 'src/app/models/comentarioModel';

@Injectable({
  providedIn: 'root'
})
export class ComentarioService {

  private baseURL:string = 'http://localhost:8080/comentarios';

  constructor(private httpClient:HttpClient) {

  }

  create(objDto: any){
    return this.httpClient.post<any>(this.baseURL, objDto);
  }

  findCervejaId(id:number): Observable<Comentario[]>{
    return this.httpClient.get<Comentario[]>(`${this.baseURL}${"/cerveja/"}${id}`);
  }
}
