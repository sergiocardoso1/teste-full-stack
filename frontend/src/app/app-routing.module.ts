import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { EsqueceuSenhaComponent } from './pages/esqueceu-senha/esqueceu-senha.component';
import { CervejasComponent } from './pages/cervejas/cervejas.component';
import { AuthGuard } from './services/authGuardService/AuthGuard';
import { SelecaoCervejaComponent } from './pages/selecao-cerveja/selecao-cerveja.component';

const routes: Routes = [
  {path:'login', component: LoginComponent, pathMatch:"full"},
  {path:'recuperarsenha', component: EsqueceuSenhaComponent, pathMatch:"full"},
  {path:'cervejas', component: CervejasComponent, pathMatch:"full", canActivate: [AuthGuard]},
  {path:'cervejas/:id', component: SelecaoCervejaComponent, pathMatch:"full", canActivate: [AuthGuard]},



  {path:'**', redirectTo:'login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
