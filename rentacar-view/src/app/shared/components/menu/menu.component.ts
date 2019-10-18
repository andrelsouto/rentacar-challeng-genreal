import { Component, OnInit, HostListener } from '@angular/core';

import { environment } from 'src/environments/environment';
import { slideDownUpAnimation } from '../../animations/slide-down-up.animation';

const doc_url = environment.documentacao_url;

@Component({
  selector: 'rent-menu',
  templateUrl: './menu.component.html',
  animations: [slideDownUpAnimation],
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  showMenu = true;
  showBody = false;
  url = doc_url;

  constructor() { }

  ngOnInit() {
    if (window.innerWidth > 1090) {
      this.showMenu = true;
      this.showBody = true;
    }
  }

  @HostListener('window:resize') onResize() {
    if (window.innerWidth > 1090) {
      this.showMenu = true;
      this.showBody = true;
    } else {
      this.showBody = true;
      this.showMenu = false;
    }
  }

  toggleMenu() {
    this.showMenu = !this.showMenu;
    this.showBody = !this.showBody;
  }

}
