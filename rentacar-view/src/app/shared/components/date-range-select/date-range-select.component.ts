import { Component, OnInit, Input, Output, EventEmitter, AfterViewInit } from '@angular/core';

import { DateParserUtil } from '../../utils/date-parser.util';

@Component({
  selector: 'rent-date-range-select',
  templateUrl: './date-range-select.component.html',
  styleUrls: ['./date-range-select.component.css']
})
export class DateRangeSelectComponent implements AfterViewInit {

  inicial: any;
  final: any;

  @Input() periodo!: any;
  @Output() periodoChange = new EventEmitter<any>();
  @Output() consultar = new EventEmitter<any>();

  constructor(private dateUtil: DateParserUtil) { }

  ngAfterViewInit() {
    this.periodo = { }
  }

  onDateSelectIni(date) {
    this.periodo.inicial = this.dateUtil.parseToString(`${date.day}/${date.month}/${date.year}`);
    this.periodoChange.emit(this.periodo);
  }

  onDateSelectFim(date) {
    this.periodo.final = this.dateUtil.parseToString(`${date.day}/${date.month}/${date.year}`);
    this.periodoChange.emit(this.periodo);
  }

}
