<<<<<<< HEAD
import { ActivatedRoute } from '@angular/router';
=======
import { ActivatedRoute, Router } from '@angular/router';
>>>>>>> ajustes
import { OnInit, Component, HostListener } from '@angular/core';


import { Setor } from './../../models/setor';
import { borderColorAnimation } from 'src/app/shared/animations/border-color.animation';
<<<<<<< HEAD
=======
import { Vaga } from 'src/app/models/vaga';
>>>>>>> ajustes

@Component({
  selector: 'rent-vagas',
  templateUrl: './vagas.component.html',
  styleUrls: ['./vagas.component.css'],
  animations: [borderColorAnimation]
})
export class VagasComponent implements OnInit {

  vagas: Setor[];
  perPage: number;
  left = true;

<<<<<<< HEAD
  constructor(private activateRoute: ActivatedRoute) { }
=======
  constructor(private activateRoute: ActivatedRoute, private router: Router) { }
>>>>>>> ajustes

  ngOnInit() {
    this.vagas = this.activateRoute.snapshot.data['vagas'];
    this.vagas.forEach(v => v.setor_page = 1);
    this.setNumberOfPage();
  }

<<<<<<< HEAD
=======
  atulizarVaga(vaga: Vaga) {
    this.vagas.forEach((setor) => {
      setor.vagas.forEach((vagaSetor) => {
        if (vagaSetor.id === vaga.id) {
          vagaSetor.situacao = vaga.situacao;
          vagaSetor.placaVeiculo = vaga.placaVeiculo;
          vagaSetor.dhOcupacao = vaga.dhOcupacao;
        }
      })
    });
  }

>>>>>>> ajustes
  @HostListener('window:resize') onResize() {
    this.setNumberOfPage();
    this.vagas.forEach(v => {
      v.setor_page = 1;
      v.vagas.forEach(vaga => vaga.ocupar = false);
    });
  }

  nextPage(setor) {
    setor.setor_page++;
    this.left = true;
  }

  previousPage(setor) {
    setor.setor_page--;
    this.left = false;
  }

  exibirCadastro(vaga) {
    vaga.ocupar = !vaga.ocupar;
  }

  private setNumberOfPage() {
    const width = window.innerWidth;
    if (width <= 600) {
      this.perPage = 1;
    } else if (width <= 1090) {
      this.perPage = 2;
    } else if (width <= 1475) {
      this.perPage = 3;
    } else if (width <= 1800) {
      this.perPage = 4;
    } else {
      this.perPage = 5;
    }
    this.setMaxPages();
  }

  private setMaxPages() {
    
    this.vagas.forEach(v => v.max_pages = Math.ceil(v.vagas.length / this.perPage));
  }

}
