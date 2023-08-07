package food.repo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import food.model.Food;

@Repository
public interface FoodRepository extends MongoRepository<Food, Long> {
	
}
