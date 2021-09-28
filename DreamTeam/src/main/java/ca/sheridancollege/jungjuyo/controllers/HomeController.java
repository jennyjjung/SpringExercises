package ca.sheridancollege.jungjuyo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.jungjuyo.beans.Player;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("player", new Player());
		return "index.html";		
	}
	
	
	
}
