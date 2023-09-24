import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { EsqueceuSenhaComponent } from './pages/esqueceu-senha/esqueceu-senha.component';
import { CervejasComponent } from './pages/cervejas/cervejas.component';

const routes: Routes = [
  {path:'login', component: LoginComponent, pathMatch:"full"},
  {path:'recuperarsenha', component: EsqueceuSenhaComponent, pathMatch:"full"},
  {path:'cervejas', component: CervejasComponent, pathMatch:"full"},



  {path:'**', redirectTo:'login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
