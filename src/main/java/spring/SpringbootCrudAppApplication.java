package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.models.Item;
import spring.models.Review;
import spring.services.ItemService;
import spring.services.ReviewService;

@SpringBootApplication
public class SpringbootCrudAppApplication implements CommandLineRunner {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ReviewService reviewService;

	// main point
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Item item = itemService.getItem(2); for(Review r : item.getReviews()) {
		 * System.out.println(r.getReviewText()); }
		 */

	}
}
