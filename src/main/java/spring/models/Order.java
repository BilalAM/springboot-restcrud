package spring.models;

import java.time.LocalDate;
import java.util.*;

public class Order {

	private long id;
	private LocalDate date;
	private String customerName;
	private List<Item> items;

	public Order(String customerName, List<Item> items, LocalDate date) {
		this.customerName = customerName;
		this.items = items;
		this.date = date;
	}

	public Order(long id, LocalDate date, String customerName, List<Item> items) {
		this.id = id;
		this.date = date;
		this.customerName = customerName;
		this.items = items;
	}

	public Order() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
