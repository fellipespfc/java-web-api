package com.dongordone.pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dongordone.pizzaria.model.Cliente;
import com.dongordone.pizzaria.repository.IClienteRepository;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteRepository clientesRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clientesRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) 
	{
		Optional<Cliente> cliente = clientesRepository.findById(id);
		
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(cliente.get());	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente)
	{
		return clientesRepository.save(cliente);
	}
	
	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(HttpStatus.GONE)
	public ResponseEntity deletar(@PathVariable Long id)
	{
		Optional<Cliente> cliente = clientesRepository.findById(id);
		
		if (cliente.isPresent()) 
		{
			try {		
				clientesRepository.deleteById(id);	
			}
			catch(Exception ex)
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
						"Erro ao excluir registro do Banco de Dados: "+ 
								this.getClass()+ " , " + ex.getMessage());
			}
			
			return ResponseEntity.status(HttpStatus.OK).build();
			
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Cliente atualizar(@RequestBody Cliente cliente)
	{
		return clientesRepository.saveAndFlush(cliente);
	}
}
