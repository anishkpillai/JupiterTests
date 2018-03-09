package com.jupiter.product;

public class CompareRatingStrategy implements ICompareStrategy {

	private int starRating;
	
	public CompareRatingStrategy(int starRating){
		this.starRating=starRating;
	}

	public boolean compareProduct(Product product) {
		return (product.getStarRating() == starRating);
	}

}
