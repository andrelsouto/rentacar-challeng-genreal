import { ConsultaComponent } from './consulta/consulta.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PagamentoRoutingModule } from './pagamento-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    ConsultaComponent
  ],
  imports: [
    CommonModule,
    PagamentoRoutingModule,
    SharedModule
  ]
})
export class PagamentoModule { }
