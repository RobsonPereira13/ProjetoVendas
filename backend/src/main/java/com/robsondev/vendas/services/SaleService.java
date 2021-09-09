package com.robsondev.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.robsondev.vendas.dto.SaleDTO;

import com.robsondev.vendas.entities.Sale;

import com.robsondev.vendas.repositories.SaleRepository;


@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	//adicionando parametro para paginação 
	public Page<SaleDTO> findAll(Pageable pageable){
		Page<Sale>result= repository.findAll(pageable);
		return result.map(x-> new SaleDTO(x));
	}
}
