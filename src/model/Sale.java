package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private List<SaleItem> list = new ArrayList<>();
	private PaymentMethod paymentMethod;
	private GerenciadorVenda gv;
	
	public Sale() {
		this.gv = new GerenciadorVenda();
	}

	public GerenciadorVenda getGv() {
		return gv;
	}

	public void setPaymentMethod(String payment) {
		paymentMethod = DataBase.selectPayment(payment);
	}
	
	public String getPaymentMethod() {
		return paymentMethod.toString();
	}
	
	public void createSaleItem(String code, int quantity) {
		SaleItem item = new SaleItem();
		item.createProduct(code, quantity);
		this.list.add(item);
	}
	
	public double getTotal(List<SaleItem> lista) {
		double total = 0;
		
		for (SaleItem saleItem : lista) {
			total += saleItem.getSubtotal();
		}
		
		return total;
	}
	
	public List<String> getItems(){
		List<String> itemStr =  new ArrayList<>();
		for(SaleItem saleItem : list) {
			itemStr.add(saleItem.toString());
		}
		return itemStr;
	}
	
	public List<SaleItem> getListItens() {
        return new ArrayList<>(list); 
    }
	
	public double getFinalPrice(List<SaleItem> lista) {
		return paymentMethod.calculate(getTotal(lista));
	}
}