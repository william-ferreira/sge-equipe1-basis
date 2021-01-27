//import EventoPergunta from './'

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
    //TODO: colocar o tipo do array EventoPergunta
    pergunta: Array<any>;


    constructor(){}
}