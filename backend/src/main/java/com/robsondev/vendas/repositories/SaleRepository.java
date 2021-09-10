package com.robsondev.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.robsondev.vendas.dto.SaleSuccessDTO;
import com.robsondev.vendas.dto.SaleSumDTO;
import com.robsondev.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
@Query("SELECT new com.robsondev.vendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
		+ "FROM Sale AS obj GROUP BY obj.seller")	
List<SaleSumDTO> amountGroupBySeller();

@Query("SELECT new com.robsondev.vendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals)) "
		+ "FROM Sale AS obj GROUP BY obj.seller")	
List<SaleSuccessDTO> successGroupBySeller();
}