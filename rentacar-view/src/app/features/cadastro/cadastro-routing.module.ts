import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SetorComponent } from './setor/setor.component';
import { VagaComponent } from './vaga/vaga.component';
import { SetorResolver } from 'src/app/services/resolvers/setor.resolver';

const routes: Routes = [
  { path: '', children: [
    { path: 'setor', component: SetorComponent },
    { path: 'vaga', component: VagaComponent, resolve: { setores: SetorResolver } }
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroRoutingModule { }
