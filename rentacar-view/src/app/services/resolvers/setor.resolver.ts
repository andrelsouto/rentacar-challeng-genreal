import { Setor } from '../../models/setor';
import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { Observable } from 'rxjs';
import { SetorService } from '../setor.service';

@Injectable({ providedIn: 'root' })
export class SetorResolver implements Resolve<Setor[]> {

  constructor(private SetorService: SetorService) { }

  resolve(route: ActivatedRouteSnapshot): Observable<Setor[]> | Promise<Setor[]> | Setor[] {

    console.log(route);
    return this.SetorService.getVagas();
  }
}