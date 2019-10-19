<<<<<<< HEAD
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

=======
import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

import { VagaService } from './../../../services/vaga.service';
import { Vaga } from './../../../models/vaga';
>>>>>>> ajustes
import { rotateXAnimation } from 'src/app/shared/animations/rotate-x.animation';

@Component({
  selector: 'rent-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css'],
  animations: [rotateXAnimation]
})
export class CadastroComponent implements OnInit {

  @Output() voltar = new EventEmitter<any>();
<<<<<<< HEAD

  constructor() { }
=======
  @Output() ocupacao = new EventEmitter<Vaga>();
  @Input('vaga') vagaParaOcupar: Vaga;

  constructor(private vagaService: VagaService) { }
>>>>>>> ajustes

  ngOnInit() {
  }

<<<<<<< HEAD
=======
  ocuparVaga(vaga: Vaga) {
    this.vagaService.ocupar(vaga).subscribe((resp: Vaga) => {
      this.vagaParaOcupar = resp;
      this.ocupacao.emit(this.vagaParaOcupar);
      this.voltar.emit();
    });
  }

>>>>>>> ajustes
  voltarCard() {
    this.voltar.emit();
  }

}
