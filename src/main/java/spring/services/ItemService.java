package spring.services;

import spring.models.ItemRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.models.Item;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		itemRepo.findAll().forEach(items::add);
		return items;
	}

	public Item getItem(int id) {
		return itemRepo.findOne(id);
	}

	public void addItem(Item item) {
		itemRepo.save(item);
	}

	public void deleteItem(int id) {
		itemRepo.delete(id);
	}

	public void updateItem(int id, Item item) {
		itemRepo.save(item);
	}

}
