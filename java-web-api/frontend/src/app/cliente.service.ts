import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  apiUrl = 'http://localhost:8080/clientes';

  constructor(private httpClient: HttpClient) { }

  listar() {
    return this.httpClient.get(this.apiUrl);
  }

  adicionar(cliente) {
    return this.httpClient.post(this.apiUrl, cliente);
  }

  atualizar(cliente) {
    return this.httpClient.put(this.apiUrl, cliente);
  }

  deletar(id) {
    return this.httpClient.delete(this.apiUrl + "/deletar/" + id, id);
  }
}

