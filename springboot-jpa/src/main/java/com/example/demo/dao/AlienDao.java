package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienDao extends CrudRepository<Alien, Integer>{
	
	
	public String getByAid(int aid);
	public Optional<Alien> getByAname(String aname);
//	public String getByAnameLikeString(String aname);
	
	public List<Alien> findByTech(String tech);
	public List<Alien> findByAidGreaterThan(int aid);
//	public List<Alien> findByAidMatchesRegex();
	
	
	/*
	 * Spaces matter for the below query after "?1", use space other wise it will give error
	 */ 
	@Query("from Alien where tech= ?1 order by aname desc")
	public List<Alien> findByTechSorted(String tech);
	
}
