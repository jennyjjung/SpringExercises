package ca.sheridancollege.jungjuyo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ca.sheridancollege.jungjuyo.beans.Breed;
import ca.sheridancollege.jungjuyo.beans.BreedGroup;
import ca.sheridancollege.jungjuyo.beans.Dog;
import ca.sheridancollege.jungjuyo.repositories.BreedRepository;
import ca.sheridancollege.jungjuyo.repositories.DogRepository;

@Controller
public class HomeController {
	
	@Autowired
	private BreedRepository breedRepo;
	@Autowired
	private DogRepository dogRepo;
	
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/breeds")
	public String breeds(Model model) {
		model.addAttribute("breed", new Breed());
		model.addAttribute("breeds", breedRepo.getBreeds());
		return "breeds.html";
	}
	
	@GetMapping("/addBreed")
	public String addBreed(Model model, @ModelAttribute Breed breed) {
		breedRepo.addBreed(breed);		
		return "redirect:/breeds";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("dog", new Dog());
		model.addAttribute("breeds", breedRepo.getBreeds());
		
		return "register.html";
	}
	
	@GetMapping("/addDog")
	public String addDog(Model model, @ModelAttribute Dog dog) {
		dogRepo.addDog(dog);
		return "redirect:/register";
	}
	
	@GetMapping("/viewDogList")
	public String viewDogList(Model model) {
		model.addAttribute("dogs", dogRepo.getDogs());
		return "viewDogList.html";
	}
	
	@GetMapping("/edit/{id}")
	public String loadEdit(Model model, @PathVariable int id) {
		
		Dog d = dogRepo.getDogById(id);
		model.addAttribute("dog", d);
		model.addAttribute("breeds", breedRepo.getBreeds());
		
		return "editDog.html";
	}
	
	@GetMapping("/editDog")
	public String editDog(@ModelAttribute Dog dog) {
		
		dogRepo.editDog(dog);
		
		return "redirect:/viewDogList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDog(@PathVariable int id) {
		
		dogRepo.deleteDog(id);
		
		return "redirect:/viewDogList";
	}
	
	@GetMapping("/viewShowList")
	public String viewShowList(Model model) {
		
		ArrayList<Breed> breeds = breedRepo.getBreeds();
		ArrayList<BreedGroup> groupList = new ArrayList<BreedGroup>();
		
		for (int i = 0; i < breeds.size(); i++) {
			
			String breed = breeds.get(i).getName();

			BreedGroup breedGroup = new BreedGroup(breed, 
					dogRepo.getMaleClass(breed).size(),
					dogRepo.getFemaleClass(breed).size(),
					dogRepo.getMaleSpecialty(breed).size(),
					dogRepo.getFemaleSpecialty(breed).size());
			
			groupList.add(breedGroup);
			
		}
		
		
		model.addAttribute("group", groupList);
		
		return "viewShowList.html";
	}

}
