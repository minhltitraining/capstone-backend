package cart.controller;

import java.util.List;
import java.util.Optional;

import cart.repo.CartRepo;
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

import cart.model.Cart;


@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartRepo cartRepo;

	@GetMapping("/all")
	public ResponseEntity<?> getAllCarts(){
		List<Cart> carts  = cartRepo.findAll();
		if (carts.size() > 0) {
			return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No carts available", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> createCart(@RequestBody Cart cart){
		try {
			cartRepo.save(cart);
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCartById(@PathVariable("id") String id){
		Optional<Cart> cart = cartRepo.findById(id);
		if (cart.isPresent()) {
			return new ResponseEntity<>(cart.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Cart cart){
		Optional<Cart> old_cart = cartRepo.findById(id);
		if (old_cart.isPresent()) {
			cartRepo.save(cart);
			return new ResponseEntity<>(cart, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		try {
			cartRepo.deleteById(id);
			return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
