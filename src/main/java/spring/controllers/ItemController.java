package spring.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.models.Item;
import spring.models.Review;
import spring.services.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		model.addAttribute("items", itemService.getAllItems());
		model.addAttribute("sum", itemService.getWholeSum());
		return "products";
	}

	@RequestMapping(value = "/item/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable int id, Model model) {
		model.addAttribute("item", itemService.getItem(id));
		model.addAttribute("reviews", itemService.getItem(id).getReviews());
		return "view";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create() {
		return "newproduct";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public String addItem(@RequestParam String name, @RequestParam int quantity, @RequestParam double price,
			@RequestParam String description, @RequestParam String image) {
		Item item = new Item();
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.setDescription(description);
		item.setImage(image);
		itemService.addItem(item);
		return "redirect:/items";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String updateItem(@RequestParam String name, @RequestParam int quantity, @RequestParam double price,
			@RequestParam String description, @RequestParam String image, @RequestParam int id) {
		Item item = itemService.getItem(id);
		item.setId(id);
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		item.setDescription(description);
		item.setImage(image);
		itemService.updateItem(id, item);
		return "redirect:/items";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public String deleteItem(@RequestParam int id) {
		itemService.deleteItem(id);
		return "redirect:/items";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/review")
	public String reviewItem(@RequestParam int id, @RequestParam String reviewContent) {
		Item item = itemService.getItem(id);
		Review review = new Review();
		review.setReviewedItem(item);
		review.setTimeStamp(LocalDateTime.now().toString());
		review.setReviewText(reviewContent);
		itemService.addReview(item, review);
		return "redirect:/item/view/" + id;
	}

}
