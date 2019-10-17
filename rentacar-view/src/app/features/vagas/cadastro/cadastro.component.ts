import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { rotateXAnimation } from 'src/app/shared/animations/rotate-x.animation';

@Component({
  selector: 'rent-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css'],
  animations: [rotateXAnimation]
})
export class CadastroComponent implements OnInit {

  @Output() voltar = new EventEmitter<any>();

  constructor() { }

  ngOnInit() {
  }

  voltarCard() {
    this.voltar.emit();
  }

}
