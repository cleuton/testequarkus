import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaPaisesComponent } from './lista-paises/lista-paises.component';
import { DetalheIndiceComponent } from './detalhe-indice/detalhe-indice.component';


const routes: Routes = [
  { path: '', component: ListaPaisesComponent },
  { path: 'indices', component: DetalheIndiceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
