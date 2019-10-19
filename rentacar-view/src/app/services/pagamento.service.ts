import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Pagamento } from './../models/pagamento';
import { Vaga } from 'src/app/models/vaga';
import { environment } from 'src/environments/environment';

const api_url = environment.api_url + 'pagamento/';

@Injectable({
  providedIn: 'root'
})
export class PagamentoService {

  constructor(private httpClient: HttpClient) { }

  consultarTotal(vaga: Vaga) {

    return this.httpClient.post<Pagamento>(api_url + 'consultar-total-a-pagar', vaga);
  }

  pagar(pagamento: Pagamento) {
    
    return this.httpClient.post<Pagamento>(api_url + 'pagar', pagamento);
  }

  consultar(periodo) {
    return this.httpClient.get<Pagamento[]>(api_url+ 'consultar-pagamentos', { params: { dtInicial: periodo.inicial, dtFinal: periodo.final } });
  }
}
