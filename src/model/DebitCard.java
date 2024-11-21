package model;

public class DebitCard implements PaymentMethod{

	private double fees;
	 
	
	public DebitCard(double fees) {
		this.fees = fees/100;
	}
	
	
	@Override
	public Double calculate(Double value) {
		return value + (value * fees);
	}

}
