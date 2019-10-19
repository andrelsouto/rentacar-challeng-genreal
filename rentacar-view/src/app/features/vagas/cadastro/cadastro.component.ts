import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

import { VagaService } from './../../../services/vaga.service';
import { Vaga } from './../../../models/vaga';
import { rotateXAnimation } from 'src/app/shared/animations/rotate-x.animation';

@Component({
  selector: 'rent-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css'],
  animations: [rotateXAnimation]
})
export class CadastroComponent implements OnInit {

  @Output() voltar = new EventEmitter<any>();
  @Output() ocupacao = new EventEmitter<Vaga>();
  @Input('vaga') vagaParaOcupar: Vaga;

  constructor(private vagaService: VagaService) { }

  ngOnInit() {
  }

  ocuparVaga(vaga: Vaga) {
    this.vagaService.ocupar(vaga).subscribe((resp: Vaga) => {
      this.vagaParaOcupar = resp;
      this.ocupacao.emit(this.vagaParaOcupar);
      this.voltar.emit();
    });
  }

  voltarCard() {
    this.voltar.emit();
  }

}
