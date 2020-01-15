package com.dongordone.pizzaria.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import javax.persistence.Id;

import com.dongordone.pizzaria.enums.TiposAdicionais;

@Entity
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private TiposAdicionais tipo;
	private BigDecimal preco;
	 

	@ManyToMany(mappedBy="ingredientes")
	private List<ItemCardapio> itemsCardapio;
	
	@ManyToMany(mappedBy="ingredientes")
	private List<Pedido> pedidos;
	
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
		Ingrediente other = (Ingrediente) obj;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TiposAdicionais getTipo() {
		return tipo;
	}
	public void setTipo(TiposAdicionais tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public List<ItemCardapio> getItemsCardapio() {
		return itemsCardapio;
	}
	public void setItemsCardapio(List<ItemCardapio> itemsCardapio) {
		this.itemsCardapio = itemsCardapio;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
