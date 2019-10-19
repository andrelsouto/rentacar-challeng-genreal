import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VagasRoutingModule } from './vagas-routing.module';
import { VagasComponent } from './vagas.component';
import { SharedModule } from '../../shared/shared.module';
import { CadastroComponent } from './cadastro/cadastro.component';
<<<<<<< HEAD
=======
import { LiberarComponent } from './liberar/liberar.component';
>>>>>>> ajustes


@NgModule({
  declarations: [
    VagasComponent,
<<<<<<< HEAD
    CadastroComponent
=======
    CadastroComponent,
    LiberarComponent
>>>>>>> ajustes
  ],
  imports: [
    CommonModule,
    VagasRoutingModule,
    SharedModule
  ]
})
export class VagasModule { }
