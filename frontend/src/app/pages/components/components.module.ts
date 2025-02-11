import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CardLoginComponent } from './card-login/card-login.component';
import { CardCervejasComponent } from './card-cervejas/card-cervejas.component';
import { CardEsqueceuSenhaComponent } from './card-esqueceu-senha/card-esqueceu-senha.component';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import { CardSelecaoCervejaComponent } from './card-selecao-cerveja/card-selecao-cerveja.component';





@NgModule({
  declarations: [
    CardLoginComponent,
    CardCervejasComponent,
    CardEsqueceuSenhaComponent,
    MenuBarComponent,
    CardSelecaoCervejaComponent,

  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    
  ],
  exports:[
    CardLoginComponent,
    CardCervejasComponent,
    CardEsqueceuSenhaComponent,
    MenuBarComponent,
    CardSelecaoCervejaComponent

  ]
})
export class ComponentsModule { }
