import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inscrever',
  templateUrl: './inscrever.component.html',
  styleUrls: ['./inscrever.component.css']
})
export class InscreverComponent implements OnInit {

  listaPerguntas: any[] = [
    {
      titulo: 'Pergunta 1',
      resposta: ''
    },
    {
      titulo: 'Pergunta 2',
      resposta: ''
    },
    {
      titulo: 'Pergunta 3',
      resposta: ''
    },
    {
      titulo: 'Pergunta 4',
      resposta: ''
    },
    {
      titulo: 'Pergunta 5',
      resposta: ''
    },
    {
      titulo: 'Pergunta 6',
      resposta: ''
    },
    {
      titulo: 'Pergunta 7',
      resposta: ''
    },
    {
      titulo: 'Pergunta 8',
      resposta: ''
    },
    {
      titulo: 'Pergunta 9',
      resposta: ''
    },
    {
      titulo: 'Pergunta 10',
      resposta: ''
    },
    {
      titulo: 'Pergunta 11',
      resposta: ''
    },
  ]
  
  constructor() { }

  ngOnInit(): void {
  }
  verLista() {
  //   console.log(this.listaPerguntas);
    
  }
}
