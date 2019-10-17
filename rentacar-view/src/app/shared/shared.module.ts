import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CardComponent } from './components/card/card.component';
import { PerPagePipe } from './pipes/per-page.pipe';
import { MenuComponent } from './components/menu/menu.component';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    CardComponent,
    PerPagePipe,
    MenuComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule
  ],
  exports: [
    CardComponent,
    PerPagePipe,
    MenuComponent,
    RouterModule,
    HttpClientModule
  ]
})
export class SharedModule { }
