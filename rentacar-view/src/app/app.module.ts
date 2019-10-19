<<<<<<< HEAD
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
=======
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { LocationStrategy, HashLocationStrategy, registerLocaleData } from '@angular/common';
import localeBr from '@angular/common/locales/br';
import localeBrExtra from '@angular/common/locales/extra/br';
>>>>>>> ajustes

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
<<<<<<< HEAD
import { NgModule } from '@angular/core';
=======

registerLocaleData(localeBr, 'pt-BR', localeBrExtra);
>>>>>>> ajustes

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [{ provide: LocationStrategy, useClass: HashLocationStrategy }],
  bootstrap: [AppComponent]
})
export class AppModule { }
