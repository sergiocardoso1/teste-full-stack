import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentsModule } from './pages/components/components.module';
import { LoginModule } from './pages/login/login.module';
import { CervejasModule } from './pages/cervejas/cervejas.module';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthTokenInterceptor } from './services/interceptorService/auth-token.interceptor';
import { EsqueceuSenhaModule } from './pages/esqueceu-senha/esqueceu-senha.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ComponentsModule,
    HttpClientModule,
    LoginModule,
    CervejasModule,
    EsqueceuSenhaModule,

  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthTokenInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
