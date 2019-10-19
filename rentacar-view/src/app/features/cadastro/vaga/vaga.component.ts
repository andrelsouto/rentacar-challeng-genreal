import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { VagaService } from './../../../services/vaga.service';
import { Vaga } from './../../../models/vaga';
import { Setor } from './../../../models/setor';

@Component({
  selector: 'rent-vaga',
  templateUrl: './vaga.component.html',
  styleUrls: ['./vaga.component.css']
})
export class VagaComponent implements OnInit {

  setores: Setor[];
  vaga: Vaga = { setor: { } };
  setor;
  css;
  message;

  constructor(private route: ActivatedRoute, private vagaService: VagaService) { }

  ngOnInit() {
    this.setores = this.route.snapshot.data['setores'];
    console
    .log(this.vaga);
  }


  cadastrar(vaga: Vaga){
    this.vagaService.cadastrar(vaga).subscribe(() => {
      this.vaga = { setor: { } };
      this.css = 'alert alert-success';
      this.message = 'Cadastro efetuado com sucesso';
    }, () => {
      this.css = 'alert alert-danger';
      this.message = 'Ocorreu um erro ao salvar.';
    });
  }

  select(id) {
    this.vaga.setor.id = id;
  }

}
