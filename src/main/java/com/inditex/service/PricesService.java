package com.inditex.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.dto.PriceDTO;
import com.inditex.entity.PricesEntity;
import com.inditex.exception.DateException;
import com.inditex.exception.InvalidProductException;
import com.inditex.repository.PricesRepository;

@Service
public class PricesService {
	
	@Autowired
	private PricesRepository pricesRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public PriceDTO getPrice(Long productId, String dateStr, Integer brandId) throws InvalidProductException, DateException {
		
		List<PricesEntity> prices = pricesRepository.findByBrandIdAndProductId(brandId, productId);
		PricesEntity priceFinal = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		
		for (PricesEntity price : prices){
			
	        LocalDateTime startDate = LocalDateTime.parse(price.getStartDate(), formatter);
	        LocalDateTime endDate = LocalDateTime.parse(price.getEndDate(), formatter);
	        LocalDateTime date = LocalDateTime.parse(dateStr, formatter);

	        if (date.isAfter(startDate) && date.isBefore(endDate)) {
	        	if(priceFinal == null) {
	        		priceFinal = price;
	        	}else {
	        		if(price.getPriority() > priceFinal.getPriority()) {
	        			priceFinal = price;
	        		}
	        	}
	        } 
		}
		
		if(prices.isEmpty()) {
			throw new InvalidProductException("No existe esa combinacion producto/cadena");			
		}
		
		if(priceFinal == null){
			throw new DateException("No hay un precio definido para esa fecha");
		}
		
		return modelMapper.map(priceFinal, PriceDTO.class);
	}

}
