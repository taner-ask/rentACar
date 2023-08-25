package javabootcamp.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javabootcamp.rentACar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
