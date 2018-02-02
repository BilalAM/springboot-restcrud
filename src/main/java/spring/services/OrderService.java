package spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.models.Order;
import spring.models.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public List<Order> getAllOrders() {
		List<Order> items = new ArrayList<>();
		orderRepo.findAll().forEach(items::add);
		return items;
	}

	public Order getItem(int id) {
		return orderRepo.findOne(id);
	}

	public void addItem(Order order) {
		orderRepo.save(order);
	}

	public void deleteOrder(int id) {
		orderRepo.delete(id);
	}

	public void updateOrder(int id, Order order) {

		orderRepo.save(order);
	}
}
