import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import { Location } from '@angular/common';
import { Pais } from '../pais';
import { Indice } from '../indice';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-detalhe-indice',
  templateUrl: './detalhe-indice.component.html',
  styleUrls: ['./detalhe-indice.component.css']
})
export class DetalheIndiceComponent implements OnInit {

  pais!: Pais;
  indices!: Indice[];

  constructor(private router:Router, private activatedRoute:ActivatedRoute,
    private location: Location, private http: HttpClient) { }

  ngOnInit(): void {
    this.pais = history.state;
    console.log(this.pais);
    this.indices = [];
    this.http.get<any>("/index/" + this.pais.id).subscribe(dados => {
      this.indices = dados[1];
      console.log(this.indices);

    });

  }

  voltar(): void {
    this.location.back();
  }

}
