import { Setor } from './../../../models/setor';
import { Component, OnInit } from '@angular/core';

import { SetorService } from 'src/app/services/setor.service';

@Component({
  selector: 'rent-setor',
  templateUrl: './setor.component.html',
  styleUrls: ['./setor.component.css']
})
export class SetorComponent implements OnInit {

  setor: Setor = { };
  css: string;
  message;

  constructor(private setService: SetorService) { }

  ngOnInit() {
  }

  cadastrar(setor: Setor) {

    this.setService.cadastrarSetor(setor).subscribe(() => {
      this.setor = {};
      this.css = 'alert alert-success';
      this.message = 'Cadastro efetuado com sucesso';
    }, () => {
      this.css = 'alert alert-danger';
      this.message = 'Ocorreu um erro ao salvar.';
    });
  }

}
