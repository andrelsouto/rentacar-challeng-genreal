import { Component, OnInit, Input, AfterViewInit, Output, EventEmitter } from '@angular/core';

import { PagamentoService } from './../../../services/pagamento.service';
import { SweetAlertOptions } from 'sweetalert2'
import { Vaga } from './../../../models/vaga';
import { Pagamento } from 'src/app/models/pagamento';

@Component({
  selector: 'rent-liberar',
  templateUrl: './liberar.component.html',
  styleUrls: ['./liberar.component.css']
})
export class LiberarComponent implements OnInit, AfterViewInit {

  @Input() vaga!: Vaga;
  @Output() liberacao = new EventEmitter<Vaga>();
  options: SweetAlertOptions = {
    confirmButtonText: 'Fechar'
  }
  pagamento: Pagamento;

  constructor(private pagamentoService: PagamentoService) { }

  ngOnInit() {
    this.pagamentoService.consultarTotal(this.vaga).subscribe(rest => {
      this.pagamento = rest;
      this.pagamento.vagas = [this.vaga];
    });
  }

  ngAfterViewInit() {
  }

  pagar(pag: Pagamento) {

    this.pagamentoService.pagar(pag).subscribe((r: Pagamento) => {
      this.vaga = r.vagas[0];
      this.pagamento = r;
    });
  }

}
