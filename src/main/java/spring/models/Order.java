package spring.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order")
public class Order {

	// LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;

	@Column(name = "timedate")
	private String date;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "totalbill")
	private double total;

	public Order() {

	}

	public Order(String date, String customerName, double total) {

	}

	public Order(int oid, String date, String customerName, double total) {
		this.oid = oid;
		this.date = date;
		this.customerName = customerName;
		this.total = total;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
