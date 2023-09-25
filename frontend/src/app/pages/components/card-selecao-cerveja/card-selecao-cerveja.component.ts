import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cerveja } from 'src/app/models/cervejaModel';
import { CervejasService } from 'src/app/services/cervejasService/cervejas.service';

@Component({
  selector: 'app-card-selecao-cerveja',
  templateUrl: './card-selecao-cerveja.component.html',
  styleUrls: ['./card-selecao-cerveja.component.css']
})
export class CardSelecaoCervejaComponent implements OnInit{

  cerveja: Cerveja;
  paramValue:number | any;


  constructor(private cervejaService:CervejasService, private route: ActivatedRoute, private router: Router){
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

  }

   
  
  
  }
  