package com.jupiter.product;

public class CompareTitleStrategy implements ICompareStrategy {
	
	private String title;
		
	public CompareTitleStrategy(String title){
		this.title=title;
	}

	public boolean compareProduct(Product product) {
		return product.getTitle().equals(title);
	}

}
