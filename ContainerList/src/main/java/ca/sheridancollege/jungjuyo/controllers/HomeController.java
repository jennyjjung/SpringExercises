package ca.sheridancollege.jungjuyo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping
	public String goHome() {
		return "index.html";
	}
	
}
