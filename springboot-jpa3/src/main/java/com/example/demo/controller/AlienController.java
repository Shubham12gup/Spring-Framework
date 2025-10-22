package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dao.AlienDao;
import com.example.demo.model.Alien;

@Controller
public class AlienController {

//	--------------- Content Negotiation ---------------
//	Restricting the content type, data will be returned in the defined format only.
//	If someone tries to fetch data in other than the defined format it will give 406(Not acceptable) error.
//	Also add jackson dataformatter xml dependency for converting object to xml.
	
	
	@Autowired
	AlienDao alienDao;

	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		
		alienDao.save(alien);
		return "home.jsp";
	}
	
//	http://localhost:8080/aliens
//	# For content negotiation use produces attribute in RequestMapping annotation
//	@RequestMapping(path="/aliens", produces = "application/xml")
//	@RequestMapping(path="/aliens", produces = {"application/xml", "application/json"})

	@RequestMapping(path="/aliens")
	@ResponseBody
	public List<Alien> getAliens() {
		
		return alienDao.findAll();
	}
	
	//http://localhost:8080/alien/101
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return alienDao.findById(aid);
	
	}
	
	
	
}
