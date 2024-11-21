package model;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private List<ItemEstoque> itens = new ArrayList<>();

	public void addProduct(Product product, int quantity) {
		for (ItemEstoque item : itens) {
			if (item.getProduct().equals(product)) {
				item.setQuantity(item.getQuantity() + quantity);
				return;
			}
		}
		itens.add(new ItemEstoque(product, quantity));
	}

	public void removeProduct(Product product, int quantity) {
		for (ItemEstoque item : itens) {
			if (item.getProduct().equals(product)) {
				if (item.getQuantity() >= quantity) {
					item.setQuantity(item.getQuantity() - quantity);
				}
			}
		}
	}

	public int hasProduct(Product product) {
		for (ItemEstoque item : itens) {
			if (item.getProduct().equals(product) && item.getQuantity() > 0) {
				return item.getQuantity();
			}
		}
		return -1;
	}
	
	public List<ItemEstoque> getItens() {
        return new ArrayList<>(itens); 
    }

}
