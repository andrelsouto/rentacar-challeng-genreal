import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'perPage'
})
export class PerPagePipe implements PipeTransform {

  qtd_de_pagina: number;

  transform(value: any[], total: number, qtd_por_pagina: number, pagina: number): any {
    this.qtd_de_pagina = Math.ceil(total / qtd_por_pagina);
    const index_inicial = pagina * qtd_por_pagina - qtd_por_pagina;
    const index_final = pagina * qtd_por_pagina < total ? (pagina * qtd_por_pagina) - 1 : total - 1;
    const retorno = value.filter((v, idx) => {
      return idx >= index_inicial && idx <= index_final ? v : null;
    });
    return retorno;
  }

}
