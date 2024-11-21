package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorVenda {
	private List<SaleItem> sale = new ArrayList<>();

	public void realizarVenda(Sale venda, Estoque estoque) {
        for (SaleItem itemV : venda.getListItens()) {
            boolean itemAdicionado = false;
            for (ItemEstoque itemE : estoque.getItens()) {
                if (itemE.getProduct().equals(itemV.getProduct())) {
                    if (itemE.getQuantity() >= itemV.getQuantity()) {
                        sale.add(itemV);
                        estoque.removeProduct(itemE.getProduct(), itemV.getQuantity());
                        itemAdicionado = true;
                        break;
                    }
                }
            }
            
            if (!itemAdicionado) {
                System.out.println("Estoque insuficiente para o produto: " + itemV.getProduct().getDescription());
            }
        }
    }

	public List<SaleItem> getEstoqueVendido() {
		return new ArrayList<>(sale);
	}

}
