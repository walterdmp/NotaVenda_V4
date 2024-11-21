package view;

import model.Estoque;
import model.Sale;

public class Main {

	public static void main(String[] args) {
		Sale sale = new Sale();
		sale.createSaleItem("at", 2);
		sale.createSaleItem("ff", 1);
		sale.createSaleItem("msa", 2);
		
		Estoque estoque = new Estoque();
		estoque.addProduct(sale.getListItens().get(0).getProduct(), 2);
		estoque.addProduct(sale.getListItens().get(1).getProduct(), 2);
		estoque.addProduct(sale.getListItens().get(2).getProduct(), 1);
		
		sale.getGv().realizarVenda(sale, estoque);
		
		sale.setPaymentMethod("cc");
		
		System.out.println("Itens Venda: ");
		for (Object item : sale.getItems()) {
			System.out.println(item);
		}
		
		System.out.println("Itens Estoque Vendidos: ");
		for (Object item : sale.getGv().getEstoqueVendido()) {
			System.out.println(item);
		}
		
		System.out.println("Estoque Atual: ");
		for (Object item : estoque.getItens()) {
			System.out.println(item);
		}
		
		
		System.out.println(String.format("Total: %.2f", sale.getTotal(sale.getGv().getEstoqueVendido())));
		
		System.out.println(String.format("Forma de pagamento: %s", sale.getPaymentMethod()));
		
		System.out.println(String.format("Preço final: %.2f", sale.getFinalPrice(sale.getGv().getEstoqueVendido())));

	}

}
