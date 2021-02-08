import { InscricaoResposta } from "./inscricao-resposta";

export class Inscricao {
    id: number;
    idTipoSituacao: number;
    idUsuario: number;
    idEvento: number;
    resposta: InscricaoResposta[] = [];
    

    constructor() { }
}
