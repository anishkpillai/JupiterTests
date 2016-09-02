package com.jupiter.product;

public class ComparePriceStrategy implements ICompareStrategy {

	private Double price;
	
	public ComparePriceStrategy(Double price){
		this.price=price;
	}
	
	public boolean compareProduct(Product product) {
		return (product.getPrice() <= price);
	}

}
