import { Component, OnInit } from '@angular/core';

import { Pagamento } from 'src/app/models/pagamento';
import { PagamentoService } from 'src/app/services/pagamento.service';

@Component({
  selector: 'rent-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent implements OnInit {

  pagamentos: Pagamento[];
  consultaRange: any;
  page = 1;
  pageSize = 5

  constructor(private pagamentoService: PagamentoService) { }

  ngOnInit() {
  }

  consutlar() {
    this.pagamentoService.consultar(this.consultaRange).subscribe((resp: Pagamento[]) => { this.pagamentos = resp });
  }

  valorTotal(): number {
    if (this.pagamentos && this.pagamentos.length > 0) {
      return this.pagamentos.map(p => p.valor).reduce((total, atual) => total += atual);
    }

    return null;
  }

}
