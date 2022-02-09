import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pais } from '../pais';

@Component({
  selector: 'app-lista-paises',
  templateUrl: './lista-paises.component.html',
  styleUrls: ['./lista-paises.component.css']
})
export class ListaPaisesComponent implements OnInit {

  paises!: Pais[];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.paises = [];
    this.http.get<any>("/pais/").subscribe(dados => {
      this.paises = dados.countries;
    });
  }

}
