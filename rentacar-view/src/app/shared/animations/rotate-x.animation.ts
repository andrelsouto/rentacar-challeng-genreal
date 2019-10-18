import { trigger, style, transition, animate } from '@angular/animations';

export const rotateXAnimation =
    trigger('rotateXAnimation', [
        transition(':enter', [
        style({ transform: 'rotateY(180deg)' }),
        animate(350)
        ]),
        transition(':leave', [
        style({ transform: 'rotateY(-180deg)' }),
        animate(350)
        ])
    ]);