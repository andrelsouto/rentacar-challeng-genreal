import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Setor } from '../models/setor';
import { environment } from 'src/environments/environment';

const api_url = environment.api_url;

@Injectable({
  providedIn: 'root'
})
export class SetorService {


  constructor(private httpClient: HttpClient) { }

  getVagas() {
    return this.httpClient.get<Setor[]>(api_url + 'setor/listar');
  }
}
