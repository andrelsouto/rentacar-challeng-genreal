import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'vagas', loadChildren: () => import('./vagas/vagas.module').then(mod => mod.VagasModule) },
  { path: 'cadastro', loadChildren: () => import('./cadastro/cadastro.module').then(mod => mod.CadastroModule) },
<<<<<<< HEAD
=======
  { path: 'pagamento', loadChildren: () => import('./pagamento/pagamento.module').then(mod => mod.PagamentoModule) },
>>>>>>> ajustes
  { path: '', redirectTo: 'vagas', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FeaturesRoutingModule { }
