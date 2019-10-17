import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SetorComponent } from './setor/setor.component';

const routes: Routes = [
  { path: '', children: [
    { path: 'setor', component: SetorComponent }
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroRoutingModule { }
