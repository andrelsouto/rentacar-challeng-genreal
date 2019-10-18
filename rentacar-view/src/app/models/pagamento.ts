import { Vaga } from './vaga';
export interface Pagamento {

    id: string;
    valor: number;
    dtPagamento: string;
    vagas: Vaga[];
    totalAPagar: number;
    totalAPago: number;
    troco: number;
}
