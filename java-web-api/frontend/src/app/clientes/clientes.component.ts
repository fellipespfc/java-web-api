import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../cliente.service';
import { isDate } from 'util';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes = [];
  cliente = {};
  selectedIds = [];

  constructor(private clienteService: ClienteService) {

  }


  ngOnInit() {
    this.listar();
  }

  listar() {
    this.clienteService.listar().
      subscribe(resposta => this.clientes = <any>resposta);
  }

  adicionar() {
    this.clienteService.adicionar(this.cliente)
      .subscribe(() => {
        this.cliente = {};
        this.listar();
      });
  }

  selectIds(id){

    const index = this.selectedIds.indexOf(id);

    if(index != -1)
    {
      this.selectedIds.splice(index, 1)
      
    }
    else{
      this.selectedIds.push(id);
    } 
  }

  deletar(){
    this.clienteService.deletar(this.selectedIds)
    .subscribe(() => {
      this.selectedIds = [];
      this.listar();
    });
  }

}
