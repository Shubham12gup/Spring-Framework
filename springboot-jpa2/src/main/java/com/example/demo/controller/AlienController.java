package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.SpringbootJpaApplication;
import com.example.demo.dao.AlienDao;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	
//	--------------- REST API ---------------
//	Returnig data instead of redirecting to view page

    private final SpringbootJpaApplication springbootJpaApplication;
	
	@Autowired
	AlienDao alienDao;

    AlienController(SpringbootJpaApplication springbootJpaApplication) {
        this.springbootJpaApplication = springbootJpaApplication;
    }
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		
		alienDao.save(alien);
		return "home.jsp";
	}
	
	//http://localhost:8080/aliens
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		
		return alienDao.findAll().toString();
	}
	
	//http://localhost:8080/alien/101
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getAlien(@PathVariable("aid") int aid) {
		
		return alienDao.findById(aid).toString();
	
	}
	
	
	
}
