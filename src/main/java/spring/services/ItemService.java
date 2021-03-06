package spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import spring.models.Item;
import spring.models.ReviewRepository;
import spring.models.ItemRepository;
import spring.models.Review;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private ReviewRepository reviewRepo;

	@Autowired
	private TaxService taxService;

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		itemRepo.findAll().forEach(items::add);
		return items;
	}

	public Item getItem(int id) {
		return itemRepo.findOne(id);
	}

	public void addItem(Item item) {
		double pricePerQuantity = getTotalPricePerQuantity(item);
		item.setPrice(taxService.enforceTax(pricePerQuantity, 11.5));
		itemRepo.save(item);
	}

	public void deleteItem(int id) {
		itemRepo.delete(id);
	}

	public void updateItem(int id, Item item) {

		itemRepo.save(item);
	}

	
	
	
	public void addReview(Item item, Review review) {
		item.getReviews().add(review);
		//itemRepo.save(item);
		reviewRepo.save(review);
	}

	public double getWholeSum() {
		double sum = 0;
		for (Item item : getAllItems()) {
			sum += (item.getPrice() * item.getQuantity());
		}
		return sum;
	}

	public double getTotalPricePerQuantity(Item item) {
		return item.getPrice() * item.getQuantity();
	}

}
