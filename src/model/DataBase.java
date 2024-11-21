package model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
	private static Map<String, String[]> products = new HashMap<String, String[]>();
	
	private static Map<String, PaymentMethod> payments = new HashMap<String, PaymentMethod>();

	static {
		products.put("at", new String[] { "Arroz Tatiana", "30" });
		products.put("ff", new String[] { "Feijão Feijó", "20" });
		products.put("msa", new String[] { "Macarrão Santa Amália", "15" });
		
		CreditCard cc = new CreditCard(5.0);
		DebitCard dc = new DebitCard(0.0);
		Cash c = new Cash(5.0);
		payments.put("cc", cc);
		payments.put("dc", dc);
		payments.put("c", c);
	}

	public static String[] selectProduct(String code) {
		return products.get(code);
	}
	
	public static PaymentMethod selectPayment(String payment) {
		return payments.get(payment);
	}
}
