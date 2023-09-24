import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/authService/auth.service';

@Component({
  selector: 'app-card-login',
  templateUrl: './card-login.component.html',
  styleUrls: ['./card-login.component.css']
})
export class CardLoginComponent  implements OnInit{

  email:string = "sergiocardosodeveloper@gmail.com";
  senha:string = "123456";

  constructor(private authService:AuthService, private router: Router, private route: ActivatedRoute){

  }

  ngOnInit(): void {

  }

  fazerLogin() {
    this.authService.login(this.email, this.senha).subscribe(
      data => {
        const token = data.headers.get('Authorization');
  
        if (token != null) {
          localStorage.setItem('token', token);
  
          this.router.navigate(['/cervejas']);
        } else {
          this.exibirAlerta('Erro ao efetuar o login. \nEmail e/ou senha incorretos.');
        }
      },
      error => {
        this.exibirAlerta('Erro ao efetuar o login. \nEmail e/ou senha incorretos.');
      }
    );
  }

  exibirAlerta(mensagem: string) {
    alert(mensagem);
  }



}