import { trigger, state, style, transition, animate } from '@angular/animations';

export const flyLeftToRigthAnimation =
    trigger('flyLeftRigth', [
        state('next', style({transform: 'translateX(0)'})),
        state('previous', style({transform: 'translateX(0)'})),
        transition('previous => *', [
        style({transform: 'translateX(100%)'}),
        animate(150)
        ]),
        transition('next => *', [
        style({transform: 'translateX(-100%)'}),
        animate(150)
        ])
    ]);

export const flyRigthToLeftAnimation =
    trigger('flyRigthLeft', [
        state('in', style({transform: 'translateX(0)'})),
        transition(':enter', [
        style({transform: 'translateX(-100%)'}),
        animate(150)
        ])
    ]);
