import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VagasRoutingModule } from './vagas-routing.module';
import { VagasComponent } from './vagas.component';
import { SharedModule } from '../../shared/shared.module';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LiberarComponent } from './liberar/liberar.component';


@NgModule({
  declarations: [
    VagasComponent,
    CadastroComponent,
    LiberarComponent
  ],
  imports: [
    CommonModule,
    VagasRoutingModule,
    SharedModule
  ]
})
export class VagasModule { }
