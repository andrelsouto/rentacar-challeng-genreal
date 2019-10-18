import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from './../../environments/environment';
import { Vaga } from './../models/vaga';

const api_url = environment.api_url;

@Injectable({
  providedIn: 'root'
})
export class VagaService {

  constructor(private httpClient: HttpClient) { }

  cadastrar(vaga: Vaga) {
    return this.httpClient.post<Vaga>(api_url + 'vaga/cadastrar', vaga);
  }
}
