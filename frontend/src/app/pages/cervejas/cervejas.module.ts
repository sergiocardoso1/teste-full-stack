import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CervejasComponent } from './cervejas.component';
import { ComponentsModule } from '../components/components.module';



@NgModule({
  declarations: [
    CervejasComponent
  ],
  imports: [
    CommonModule,
    ComponentsModule
  ],
  exports:[
    CervejasComponent
  ]
})
export class CervejasModule { }
