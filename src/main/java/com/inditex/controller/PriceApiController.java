package com.inditex.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.dto.PriceDTO;
import com.inditex.service.PricesService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-05T17:43:06.231643+02:00[Europe/Madrid]")
@RestController
public class PriceApiController implements PriceApi {
    
    @Autowired
	private PricesService pricesService;

    @org.springframework.beans.factory.annotation.Autowired
    public PriceApiController() {}

    public ResponseEntity<PriceDTO> getPrice(@Parameter(in = ParameterIn.PATH, description = "Id of product", required=true, schema=@Schema()) @PathVariable("productId") Long productId,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Date when the price applies" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "date", required = true) String date,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Brand of the group where the price applies" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "brandId", required = true) Integer brandId) {

		return new ResponseEntity<PriceDTO>(pricesService.getPrice(productId, date, brandId) ,HttpStatus.OK);
    }

}
