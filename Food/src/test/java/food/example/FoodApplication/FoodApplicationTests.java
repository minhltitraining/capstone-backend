package food.example.FoodApplication;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.model.Food;
import com.repo.FoodRepository;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FoodApplicationTests {
	@Autowired
	FoodRepository foodRepo;
	public static Food f1;
	public static Food f2;

	@BeforeAll
	public static void setUp(){
		f1 = new Food(1L, "pizza", "domino", 5L, 1L);
		f2 = new Food(2L, "hamburger", "innout", 3L, 0L);
	}

	@Test
	void testEmptyRepo() {
		List<Food> foodList = foodRepo.findAll();
		assertEquals(foodList.size(), 0L);
		foodRepo.deleteAll();
	}

	@Test
	void testAddFood() {
		foodRepo.save(f1);
		List<Food> foodList = foodRepo.findAll();
		assertEquals(foodList.size(), 1);
		foodRepo.save(f2);
		foodList = foodRepo.findAll();
		assertEquals(foodList.size(), 2);
		foodRepo.deleteAll();
	}

	@Test
	void testGetFoodById(){
		foodRepo.save(f1);
		foodRepo.save(f2);
		Optional<Food> f = foodRepo.findById(1L);
		assertEquals(f.isPresent(), true);
		assertEquals(f.get().toString(), f1.toString());
		f = foodRepo.findById(3L);
		assertEquals(f.isPresent(), false);
		f = foodRepo.findById(2L);
		assertEquals(f.isPresent(), true);
		assertEquals(f.get().toString(), f2.toString());
		foodRepo.deleteAll();
	}

}

