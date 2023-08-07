package food.controller;

import java.util.List;
import java.util.Optional;

import food.repo.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import food.model.Food;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepo;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllFood(){
		List<Food> food = foodRepo.findAll();
		if (food.size() > 0){
			return new ResponseEntity<List<Food>>(food, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No food available", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> createFood(@RequestBody Food food){
		try {
			foodRepo.save(food);
			return new ResponseEntity<Food>(food, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getFoodById(@PathVariable("id") Long id){
		Optional<Food> food = foodRepo.findById(id);
		if (food.isPresent()){
			return new ResponseEntity<>(food.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Food not found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Food food){
		Optional<Food> old_food = foodRepo.findById(id);
		if (old_food.isPresent()){
			foodRepo.save(food);
			return new ResponseEntity<>(food, HttpStatus.OK);
		} else {
			return  new ResponseEntity<>("Food not found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		try {
			foodRepo.deleteById(id);
			return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
