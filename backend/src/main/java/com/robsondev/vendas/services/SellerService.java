package com.robsondev.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robsondev.vendas.dto.SellerDTO;
import com.robsondev.vendas.entities.Seller;
import com.robsondev.vendas.repositories.SellerRepository;

@Service
public class SellerService {
	@Autowired
private SellerRepository repository;
public List<SellerDTO> findAll(){
	List<Seller>result= repository.findAll();
	return result.stream().map(x-> new SellerDTO(x)).collect(Collectors.toList());
}
}
