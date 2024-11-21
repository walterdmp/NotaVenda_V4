package model;

public class CreditCard implements PaymentMethod{
	private double fees;
	
	
	public CreditCard(double fees) {
		this.fees = fees/100;
	}


	@Override
	public Double calculate(Double value) {
		return value + (value * fees);
	}


	@Override
	public String toString() {
		return "Cartão de crédito";
	}

}
