package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	//http://localhost:8080/home
	
//	@RequestMapping("home")
//	public String home() {
//		System.out.println("Home Page");
//		return "home";
//	}

//	Using HttpServletRequest
	/*
	 * @RequestMapping("home") public String home(HttpServletRequest request) {
	 * System.out.println("Home Page");
	 * 
	 * HttpSession session = request.getSession(); String name =
	 * request.getParameter("name"); System.out.println("Home Page" + name);
	 * 
	 * session.setAttribute("name", name); return "home"; }
	 */

	// Using session as argumemts
	/*
	 * @RequestMapping("home") public String home(String name, HttpSession session)
	 * {
	 * 
	 * // HttpSession session = request.getSession(); // String name =
	 * request.getParameter("name"); System.out.println("Home Page: " + name);
	 * 
	 * session.setAttribute("name", name); return "home"; }
	 */

	// Using @RequestParam for binding input sent in URL to java object
	/*
	 * @RequestMapping("home") public String home(@RequestParam("name") String myname,
	 * HttpSession session) { System.out.println("Home Page: " + myname);
	 * 
	 * session.setAttribute("name", myname); return "home"; }
	 */

	// ModelAndView 
	/*
	 * @RequestMapping("home") public ModelAndView home(@RequestParam("name") String
	 * myName) { System.out.println("Home Page: " + myName);
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.addObject("name", myName);
	 * mv.setViewName("home"); return mv; }
	 */
	
	
//	http://localhost:8080/home?aid=101&aname=bob&lang1=
	// Object as a param 
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
		System.out.println("Home Page: " + alien);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
	}
	
	
	

}
