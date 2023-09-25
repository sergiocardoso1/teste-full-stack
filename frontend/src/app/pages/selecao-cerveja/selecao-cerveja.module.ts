import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SelecaoCervejaComponent } from './selecao-cerveja.component';
import { ComponentsModule } from '../components/components.module';



@NgModule({
  declarations: [
    SelecaoCervejaComponent
  ],
  imports: [
    CommonModule,
    ComponentsModule
  ],
  exports:[
    SelecaoCervejaComponent
  ]
})
export class SelecaoCervejaModule { }
