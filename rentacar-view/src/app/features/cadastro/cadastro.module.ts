import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroRoutingModule } from './cadastro-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { SetorComponent } from './setor/setor.component';


@NgModule({
  declarations: [SetorComponent],
  imports: [
    CommonModule,
    CadastroRoutingModule,
    SharedModule
  ]
})
export class CadastroModule { }
