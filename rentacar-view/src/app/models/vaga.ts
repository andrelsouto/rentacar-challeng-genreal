import { Setor } from './setor';
import { Pagamento } from './pagamento';

export interface Vaga {
    id: string;
    setor: Setor;
    descricao: string;
    pagamentos: Pagamento[];
    dhOcupacao: string;
    situacao: any;
    ocupar: boolean;
}
