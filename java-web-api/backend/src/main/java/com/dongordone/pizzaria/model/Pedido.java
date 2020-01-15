package com.dongordone.pizzaria.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	@JoinTable(name="pedido", joinColumns=
 	{@JoinColumn(name="cliente_id")}, inverseJoinColumns=
   	{@JoinColumn(name="item_cardapio_id")})
    private List<ItemCardapio> itemsCardapio;

	@ManyToMany
	@JoinTable(name="pedido", joinColumns=
 	{@JoinColumn(name="item_cardapio_id")}, inverseJoinColumns=
   	{@JoinColumn(name="cliente_id")})
    private List<Cliente> clientes;
	
	@ManyToMany
	@JoinTable(name="pedido_add_ingrediente", joinColumns=
 	{@JoinColumn(name="pedido_id")}, inverseJoinColumns=
   	{@JoinColumn(name="ingrediente_id")})
	private List<Ingrediente> ingredientes;
	
	@ManyToMany(mappedBy="pedidos")
	private List<Compra> compras;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemCardapio> getItemsCardapio() {
		return itemsCardapio;
	}

	public void setItemsCardapio(List<ItemCardapio> itemsCardapio) {
		this.itemsCardapio = itemsCardapio;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	

}