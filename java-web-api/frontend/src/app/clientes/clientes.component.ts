import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes = [];
  cliente = {};

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

  deletar(id){
    this.clienteService.deletar(id)
    .subscribe(() => {
      this.listar();
    });
  }

}
