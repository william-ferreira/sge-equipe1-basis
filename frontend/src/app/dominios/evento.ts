import { EventoPergunta } from './eventoPergunta';
import { TipoEvento } from './tipoEvento';

export class Evento{
    // TODO: perguntar se pode colocar o tipo primitivo, pois o dto nao pode
    id: number;
    titulo: string;
    dataInicio: Date;
    dataTermino: Date;
    descricao: string;
    quantVagas: number;
    valor: number;
    localEvento: string;
    tipoInscricao: boolean;
    idTipoEvento: number;
    pergunta: EventoPergunta[] = [];

    constructor(){}
}