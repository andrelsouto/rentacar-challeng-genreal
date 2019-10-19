import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VagasComponent } from './vagas.component';

import { SetorResolver } from 'src/app/services/resolvers/setor.resolver';


const routes: Routes = [
  {
<<<<<<< HEAD
    path: '', children: [{
      path: '', component: VagasComponent, resolve: { vagas: SetorResolver }
    }]
=======
    path: '', children: [
      {
        path: '', component: VagasComponent, resolve: { vagas: SetorResolver }
      }
  ]
>>>>>>> ajustes
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VagasRoutingModule { }
