package com.robsondev.vendas.contorllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robsondev.vendas.dto.SaleDTO;
import com.robsondev.vendas.dto.SaleSuccessDTO;
import com.robsondev.vendas.dto.SaleSumDTO;
import com.robsondev.vendas.services.SaleService;


@RestController
@RequestMapping(value="/sales")

public class SaleController {
@Autowired
	private SaleService service;

@GetMapping
//adicionando parametro para paginação 
public ResponseEntity<Page< SaleDTO>> findAll(Pageable pageable){
	Page< SaleDTO>list = service.findAll(pageable);
	return ResponseEntity.ok(list);
	
}
@GetMapping(value="/amount-by-seller")

public ResponseEntity<List< SaleSumDTO>> amountGroupedBySeller(){
	List< SaleSumDTO>list = service.amountGroupedBySeller();
	return ResponseEntity.ok(list);
	
}
@GetMapping(value="/success-by-seller")

public ResponseEntity<List< SaleSuccessDTO>> successGroupedBySeller(){
	List< SaleSuccessDTO>list = service.successGroupedBySeller();
	return ResponseEntity.ok(list);
	
}
}
