package model;

public class Cash implements PaymentMethod{
	private double discount;
	
	public Cash(double discount) {
		this.discount = discount/100;
	}


	@Override
	public Double calculate(Double value) {
		return value - (value * discount);
	}

}
