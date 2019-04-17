package com.springjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.entities.Magazines;


public interface MagazineRepository extends CrudRepository<Magazines,Long>{

}
