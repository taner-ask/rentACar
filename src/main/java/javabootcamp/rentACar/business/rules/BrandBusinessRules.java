package javabootcamp.rentACar.business.rules;

import org.springframework.stereotype.Service;

import javabootcamp.rentACar.core.utilities.exceptions.BusinessException;
import javabootcamp.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists"); //java exception types
		}
	}
}
