import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CardComponent } from './components/card/card.component';
import { PerPagePipe } from './pipes/per-page.pipe';
import { MenuComponent } from './components/menu/menu.component';

@NgModule({
  declarations: [
    CardComponent,
    PerPagePipe,
    MenuComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    CardComponent,
    PerPagePipe,
    MenuComponent,
    RouterModule,
    HttpClientModule,
    FormsModule
  ]
})
export class SharedModule { }
