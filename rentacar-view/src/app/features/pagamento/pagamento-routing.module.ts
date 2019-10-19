import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ConsultaComponent } from './consulta/consulta.component';


const routes: Routes = [
  { path: '', children: [
    { path: 'consulta', component: ConsultaComponent }
  ] 
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagamentoRoutingModule { }
