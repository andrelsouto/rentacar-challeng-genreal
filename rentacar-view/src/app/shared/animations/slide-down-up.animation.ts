import { trigger, style, transition, animate } from '@angular/animations';

export const slideDownUpAnimation =
    trigger('slideDownUp', [
        transition(':enter', [
        style({ transform: 'translateY(-100%)' }),
        animate(350)
        ]),
        transition(':leave', [
        style({ transform: 'translateY(100%)' }),
        animate(350)
        ])
    ]);
