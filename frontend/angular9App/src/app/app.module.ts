import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarraSuperiorComponent } from './barra-superior/barra-superior.component';
import { HttpClientModule } from '@angular/common/http';
import { ListaPaisesComponent } from './lista-paises/lista-paises.component';
import { DetalheIndiceComponent } from './detalhe-indice/detalhe-indice.component';

@NgModule({
  declarations: [
    AppComponent,
    BarraSuperiorComponent,
    ListaPaisesComponent,
    DetalheIndiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
