package com.dongordone.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dongordone.pizzaria.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
