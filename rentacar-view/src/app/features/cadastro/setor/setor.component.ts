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

  constructor(private setService: SetorService) { }

  ngOnInit() {
  }

  cadastrar(setor: Setor) {

    this.setService.cadastrarSetor(setor).subscribe();
  }

}
