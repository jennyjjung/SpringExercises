package ca.sheridancollege.jungjuyo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String process(Model model,
						  @RequestParam int id,
						  @RequestParam String name,
						  @RequestParam double volume) {
		
		try {
			
			Container container = new Container(id, name, volume);
			
			if (volume <= 10) {
				container.setDepartment("Books");
				ContainerDepartment.books.add(container);
			} else if (volume > 10 && volume <= 50) {
				container.setDepartment("Electronics");
				ContainerDepartment.electronics.add(container);
			} else if (volume > 50) {
				if (name.contains("crate")) {
					ContainerDepartment.furniture.add(container);
					container.setDepartment("Furniture");
				} else {
					ContainerDepartment.bedding.add(container);
					container.setDepartment("Bedding");
				}
			} 
			model.addAttribute(container);
			
		} catch (IllegalArgumentException ex){
			System.out.println(ex);
			return "error.html";
			
		}
		
		return "output.html";
	}
	
	@GetMapping("/record")
	public String goRecord(Model model) {
		model.addAttribute("books", ContainerDepartment.books);
		model.addAttribute("electronics", ContainerDepartment.electronics);
		model.addAttribute("furniture", ContainerDepartment.furniture);
		model.addAttribute("bedding", ContainerDepartment.bedding);
		
		return "record.html";
	}
	
}
