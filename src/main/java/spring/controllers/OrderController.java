package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.services.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	
	
}
