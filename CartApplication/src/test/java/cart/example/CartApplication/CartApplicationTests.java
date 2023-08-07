package cart.example.CartApplication;

import cart.model.Cart;
import cart.repo.CartRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CartApplicationTests {
	@Autowired
	CartRepo cartRepo;
	public static Cart c1;
	public static Cart c2;

	@BeforeAll
	public static void setUp(){

		c1 = new Cart("james", Arrays.asList("1", "3", "7"));
		c2 = new Cart("david", Arrays.asList("4", "5", "6"));
	}
	@Test
	void testEmptyRepo() {
		List<Cart> cartList = cartRepo.findAll();
		assertEquals(cartList.size(), 0);
	}

	@Test
	void testAddCart(){
		cartRepo.save(c1);
		List<Cart> cartList = cartRepo.findAll();
		assertEquals(cartList.size(), 1);
		cartRepo.save(c2);
		cartList = cartRepo.findAll();
		assertEquals(cartList.size(), 2);
		cartRepo.deleteAll();
	}

	@Test
	void testGetCartById(){
		cartRepo.save(c1);
		cartRepo.save(c2);
		Optional<Cart> c = cartRepo.findById("james");
		assertEquals(c.isPresent(), true);
		assertEquals(c.get().toString(), c1.toString());
		c = cartRepo.findById("minh");
		assertEquals(c.isPresent(), false);
		c = cartRepo.findById("david");
		assertEquals(c.isPresent(), true);
		assertEquals(c.get().toString(), c2.toString());
		cartRepo.deleteAll();
	}
}
