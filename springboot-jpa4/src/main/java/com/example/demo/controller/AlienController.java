package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SpringbootJpaApplication;
import com.example.demo.dao.AlienDao;
import com.example.demo.model.Alien;

//Use RestController it defines every mmethod will return data and not redirect to any view page. 
//Also we don't have to use @ResponseBody if we are using RestController
@RestController
public class AlienController {

	
	@Autowired
	AlienDao alienDao;

	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
//	@PostMapping("/alien")
//	@PostMapping(path="/alien", consumes = "application/json", produces = "application/xml")
	@PostMapping(path="/alien", consumes = "application/json")
	public Alien addAlien(@RequestBody Alien alien) {
		
		alienDao.save(alien);
		return alien;
	}
	
	@GetMapping(path="/aliens")
	public List<Alien> getAliens() {
		
		return alienDao.findAll();
	}
	
	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return alienDao.findById(aid);
	
	}
	
//	@DeleteMapping("/alien/{aid}")
//	public Alien deleteAlien(@PathVariable int aid) {
//		
//		Alien alien = alienDao.getOne(aid);	
//		alienDao.delete(alien);
//		
//		return alien;
//		
//	}
	
//	Above method Deletes data but gives error in response, so change the return type to String 
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		
		Alien alien = alienDao.getOne(aid);	
		alienDao.delete(alien);
		
		return "ALien Deleted....";
		
	}
	
	@PutMapping(path="/alien", consumes = "application/json")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		
		alienDao.save(alien);
		return alien;
	}
	
	
}
