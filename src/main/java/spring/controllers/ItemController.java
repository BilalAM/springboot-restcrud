package spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.models.Item;
import spring.services.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		model.addAttribute("items", itemService.getAllItems());
		return "products";
	}

	@RequestMapping(value = "/item/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable int id, Model model) {
		model.addAttribute("item", itemService.getItem(id));
		return "view";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/create")
	public String create() {
		return "newproduct";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/new")
	public String addItem(@RequestParam String name, @RequestParam int quantity, @RequestParam double price) {
		Item item = new Item();
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		itemService.addItem(item);
		return "redirect:/items";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public String updateItem(@RequestParam String name, @RequestParam int quantity, @RequestParam double price,
			@RequestParam int id) {
		Item item = itemService.getItem(id);
		item.setId(id);
		item.setName(name);
		item.setPrice(price);
		item.setQuantity(quantity);
		itemService.updateItem(id, item);;
		return "redirect:/items";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	public String deleteItem(@RequestParam int id) {
		itemService.deleteItem(id);
		return "redirect:/items";
	}

}
