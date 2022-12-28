package y_project;

public class ProductVO {
	String name;
	int price;
	int bonusPoint;

	public ProductVO(String name, int price) {
		this.name = name;
		this.price = price;
		this.bonusPoint = price/10;
	}
}
