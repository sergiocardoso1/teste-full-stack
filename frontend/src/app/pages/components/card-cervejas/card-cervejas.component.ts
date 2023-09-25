import { Component, OnInit } from '@angular/core';
import { Cerveja } from 'src/app/models/cervejaModel';
import { CervejasService } from 'src/app/services/cervejasService/cervejas.service';

@Component({
  selector: 'app-card-cervejas',
  templateUrl: './card-cervejas.component.html',
  styleUrls: ['./card-cervejas.component.css']
})

export class CardCervejasComponent implements OnInit {
  cervejas: Cerveja[] = [];
  ordemNome: 'asc' | 'desc' = 'asc';
  ordemTipo: 'asc' | 'desc' = 'asc';
  ordemImagem: 'asc' | 'desc' = 'asc';
  ordemABV: 'asc' | 'desc' = 'asc';
  nameInput:string = "";

  constructor(private cervejaService: CervejasService) {}

  ngOnInit(): void {
    this.cervejaService.findAll().subscribe((cervejas) => {
      this.cervejas = cervejas;
    });
  }

  ordenarPor(atributo: string): void {
    switch (atributo) {
      case 'name':
        this.ordemNome = this.ordemNome === 'asc' ? 'desc' : 'asc';
        this.cervejas.sort((a, b) =>
          this.ordemNome === 'asc'
            ? a.name.localeCompare(b.name)
            : b.name.localeCompare(a.name)
        );
        break;
      case 'tipo':
        this.ordemTipo = this.ordemTipo === 'asc' ? 'desc' : 'asc';
        this.cervejas.sort((a, b) =>
          this.ordemTipo === 'asc'
            ? a.tagline.localeCompare(b.tagline)
            : b.tagline.localeCompare(a.tagline)
        );
        break;
      case 'abv':
        this.ordemABV = this.ordemABV === 'asc' ? 'desc' : 'asc';
        this.cervejas.sort((a, b) =>
          this.ordemABV === 'asc' ? a.abv - b.abv : b.abv - a.abv
        );
        break;
      default:
        break;
    }
  }

  findName() {
    console.log("Valor atual de nameInput:", this.nameInput); // Adicione este log para depuração
    if (this.nameInput.trim() !== "") {
      this.cervejaService.findByName(this.nameInput).subscribe(data => {
        this.cervejas = data;
      });
    } else {
      this.cervejaService.findAll().subscribe(data => {
        this.cervejas = data;
      });
    }
  }


}