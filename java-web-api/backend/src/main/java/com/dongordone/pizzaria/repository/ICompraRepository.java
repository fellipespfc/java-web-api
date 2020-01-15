package com.dongordone.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dongordone.pizzaria.model.Compra;

public interface ICompraRepository extends JpaRepository<Compra, Long> {

}
