import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cerveja } from 'src/app/models/cervejaModel';
import { ComentarioDTO } from 'src/app/models/comentarioDTO copy';
import { Comentario } from 'src/app/models/comentarioModel';
import { CervejasService } from 'src/app/services/cervejasService/cervejas.service';
import { ComentarioService } from 'src/app/services/comentarioService/comentario.service';

@Component({
  selector: 'app-card-selecao-cerveja',
  templateUrl: './card-selecao-cerveja.component.html',
  styleUrls: ['./card-selecao-cerveja.component.css']
})
export class CardSelecaoCervejaComponent implements OnInit{
  comentarios: Comentario[] = [];
  cerveja: Cerveja;
  paramValue:number | any;
  comentarioInput:string = "";


  constructor(private cervejaService:CervejasService, private comentarioService:ComentarioService, private route: ActivatedRoute, private router: Router){
    this.paramValue = this.route.snapshot.paramMap.get('id');
    this.cerveja = {
      id:0,
      name:"",
      abv: 0,
      tagline: "",
      image_url : ""
    }
  }

  ngOnInit(): void {
    this.cervejaService.findId(this.paramValue).subscribe(data => {
      this.cerveja = data;
    });
    this.comentarioService.findCervejaId(this.paramValue).subscribe((data) => {
      this.comentarios = data;
    });

  }

  cadastrarComentario(){

    if(this.comentarioInput.length > 5){
      var objDto:Comentario = {
        id : 0,
        comentario : this.comentarioInput,
        cervejaId : this.paramValue
     
      }

      this.comentarioService.create(objDto).subscribe(
        response =>{
          this.exibirAlerta('Comentário enviado com sucesso!');
        },error => {
          this.exibirAlerta('Erro ao enviar o comentário, tente novamente!');
        }
      )
    }
  }

  exibirAlerta(mensagem: string) {
    alert(mensagem);
  }
}
  