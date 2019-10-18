import { Component, OnInit, Input } from '@angular/core';

import { flyLeftToRigthAnimation } from '../../animations/fly-left-rigth.animation';

@Component({
  selector: 'rent-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
  animations: [
    flyLeftToRigthAnimation
  ]
})
export class CardComponent implements OnInit {

  @Input() vaga = '';
  @Input() left = true;
  @Input()
  placa;

  constructor() { }

  ngOnInit() {
  }

}
