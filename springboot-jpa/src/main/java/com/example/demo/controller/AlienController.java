package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.SpringbootJpaApplication;
import com.example.demo.dao.AlienDao;
import com.example.demo.model.Alien;

@Controller
public class AlienController {

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
	
	
	//http://localhost:8080/getAlien?aid=101
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv = new ModelAndView("ShowAliens.jsp");
		
//		Alien alien = alienDao.findById(Integer.parseInt(aid)).orElse(null); //for string input
//		Alien alien = alienDao.findById(aid).orElse(null);
		Alien alien = alienDao.findById(aid).orElse(new Alien());
		
		mv.addObject("alien",alien);
		
		
		System.out.println(alienDao.findByTech("Python").toString());
		System.out.println(alienDao.findByAidGreaterThan(aid).toString());
		System.out.println(alienDao.findByTechSorted("Java").toString());
		
		
		return mv;
		
	}
	
	
	@RequestMapping("/updateAlien")
	public String updateAlien(@RequestParam int aid, @RequestParam String aname) {
		
//		getAlien(aid);
//		ModelAndView mv = new ModelAndView("ShowAliens.jsp");
		
		Alien alien = new Alien(aid, aname);
		alienDao.save(alien);
		
//		getAlien(alien.getAid());
		
		return "redirect: /getAlien";

//		mv.addObject("alien",alien);
//		return mv;

	}
	
	@RequestMapping("/getAlienWithName")
	public ModelAndView getByAname(String aname) {
		
		Optional<Alien> alien = alienDao.getByAname(aname);
		System.out.println(alien.toString());
		
		ModelAndView mv = new ModelAndView("ShowAliens.jsp");
		mv.addObject("alien", alien.get());
	
		return mv;
	}
	
	
	
}
