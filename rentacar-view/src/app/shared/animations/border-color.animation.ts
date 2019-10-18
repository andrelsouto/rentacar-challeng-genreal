import { trigger, state, style, transition, animate, keyframes } from '@angular/animations';

export const borderColorAnimation =
    trigger('borderColor', [
        state('vazia', style({borderColor: 'green'})),
        state('ocupada', style({borderColor: 'red'})),
        transition('* => vazia', [
            animate('2s', keyframes([
                style({borderColor: 'blue'}),
                style({borderColor: 'red'}),
                style({borderColor: 'orange'})
            ]))
        ]),
        transition('* => ocupada', [
            animate('2s', keyframes([
                style({borderColor: 'blue'}),
                style({borderColor: 'red'}),
                style({borderColor: 'orange'})
            ]))
        ])
    ]);
