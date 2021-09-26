package ca.sheridancollege.jungjuyo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.jungjuyo.beans.Container;
import ca.sheridancollege.jungjuyo.repositories.ContainerDepartment;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String goHome() {
		return "index.html";
	}
	
	@GetMapping("processContainer")
	public String process(@RequestParam int id,
						  @RequestParam String name,
						  @RequestParam double volume) {
		
		try {
			
			Container container = new Container(id, name, volume);
			if (volume <= 10) {
				ContainerDepartment.books.add(container);
			} else if (volume > 10 && volume <= 50) {
				ContainerDepartment.electronics.add(container);
			} else if (volume > 50) {
				if (name.contains("crate"))
					ContainerDepartment.furniture.add(container);
				else
					ContainerDepartment.bedding.add(container);
			} 
			
		} catch (IllegalArgumentException ex){
			
			return "error.html";
			
		}
		
		return "output.html";
	}
	
}
