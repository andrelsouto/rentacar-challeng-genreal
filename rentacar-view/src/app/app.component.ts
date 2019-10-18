import { Component } from '@angular/core';

@Component({
  selector: 'rent-root',
  template: `
    <div class="d-flex">
        <rent-menu></rent-menu>
    </div>
  `,
  styles: []
})
export class AppComponent {
  title = 'rentacar';
}
