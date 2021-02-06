
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
    tipoInscricao = false;
    idTipoEvento: number;
   

    constructor(){}

    setIdTipoEvento(id: number){
        this.idTipoEvento = id;
    }
}