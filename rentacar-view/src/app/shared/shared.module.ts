import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
<<<<<<< HEAD
import { CardComponent } from './components/card/card.component';
import { PerPagePipe } from './pipes/per-page.pipe';
import { MenuComponent } from './components/menu/menu.component';
=======

import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { NgbDatepickerModule, NgbDatepickerI18n, NgbDateParserFormatter, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { CardComponent } from './components/card/card.component';
import { PerPagePipe } from './pipes/per-page.pipe';
import { MenuComponent } from './components/menu/menu.component';
import { DateRangeSelectComponent } from './components/date-range-select/date-range-select.component';
import { DateParserUtil } from './utils/date-parser.util';
import { DateLabelUtil } from './utils/date-label.util';
>>>>>>> ajustes

@NgModule({
  declarations: [
    CardComponent,
    PerPagePipe,
    MenuComponent,
<<<<<<< HEAD
=======
    DateRangeSelectComponent,
>>>>>>> ajustes
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
<<<<<<< HEAD
    FormsModule
=======
    FormsModule,
    SweetAlert2Module.forRoot(),
    NgbDatepickerModule,
    NgbPaginationModule
>>>>>>> ajustes
  ],
  exports: [
    CardComponent,
    PerPagePipe,
    MenuComponent,
    RouterModule,
    HttpClientModule,
<<<<<<< HEAD
    FormsModule
=======
    FormsModule,
    SweetAlert2Module,
    DateRangeSelectComponent,
    NgbDatepickerModule,
    NgbPaginationModule
  ],
  providers: [
    { provide: NgbDatepickerI18n, useClass: DateLabelUtil },
    { provide: NgbDateParserFormatter, useClass: DateParserUtil }
>>>>>>> ajustes
  ]
})
export class SharedModule { }
