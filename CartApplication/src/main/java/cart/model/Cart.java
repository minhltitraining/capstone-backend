package cart.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cartdb")
public class Cart {
	
	@Id
	private String id;
	private List<String> itemIds;
	public Cart(String id, List<String> itemIds) {
		super();
		this.id = id;
		this.itemIds = itemIds;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id='" + id + '\'' +
				", itemIds=" + itemIds +
				'}';
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}
	
}
