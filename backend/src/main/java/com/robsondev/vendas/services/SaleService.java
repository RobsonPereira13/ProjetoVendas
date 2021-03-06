package com.robsondev.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robsondev.vendas.dto.SaleDTO;
import com.robsondev.vendas.dto.SaleSuccessDTO;
import com.robsondev.vendas.dto.SaleSumDTO;
import com.robsondev.vendas.entities.Sale;

import com.robsondev.vendas.repositories.SaleRepository;
import com.robsondev.vendas.repositories.SellerRepository;


@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	
	//adicionando parametro para paginação 
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale>result= repository.findAll(pageable);
		return result.map(x-> new SaleDTO(x));
	}
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupBySeller();
	}
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupBySeller();
	}
}
