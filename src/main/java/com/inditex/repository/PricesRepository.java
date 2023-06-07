package com.inditex.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inditex.entity.PricesEntity;

public interface PricesRepository extends CrudRepository<PricesEntity, Long> {
	
	List<PricesEntity> findByBrandIdAndProductIdOrderByPriorityDesc(Integer brandId, Long productId);
}
