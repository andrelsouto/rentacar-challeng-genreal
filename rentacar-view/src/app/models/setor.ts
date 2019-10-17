import { Vaga } from './vaga';
export interface Setor {

    id: string;
    descricao: string;
    vagas: Vaga[];
    setor_page: number;
    max_pages: number;
}
