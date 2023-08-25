package javabootcamp.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javabootcamp.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	boolean existsByName(String name);  //spring jpa keywords
}
