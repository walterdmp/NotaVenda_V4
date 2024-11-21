package model;

public class ItemEstoque {
	private Product product;
	private int quantity;
	
	public ItemEstoque(Product product, int quantity) {
		this.product = product;
		setQuantity(quantity);
	}

	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Produto: " + product.getDescription() + ", quantidade: " + quantity + "\n";
	}
	
	
	
}
