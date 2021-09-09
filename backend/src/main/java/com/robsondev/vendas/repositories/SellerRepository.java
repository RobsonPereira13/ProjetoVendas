package com.robsondev.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robsondev.vendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
