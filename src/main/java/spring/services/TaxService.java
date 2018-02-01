package spring.services;

import org.springframework.stereotype.Service;

@Service
public class TaxService {

	public double enforceTax(double price, double tax) {
		return price + ((tax / 100) * price);
	}

}
