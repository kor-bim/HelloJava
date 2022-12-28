package f_OOP2;

import java.util.Scanner;
import java.util.Vector;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class ProductTest {
	public static void main(String[] args) {

	}
}

class Product {

	String name;
	int price;
	int bonusPoint;
	int qty;
	int count;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		this.bonusPoint = price / 10;
	}
}

class NoteBook extends Product {
	NoteBook(String name, int price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return "NoteBook";
	}

}

class Styler extends Product {
	public Styler(String name, int price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return "Styler";
	}
}

class Fridge extends Product {
	public Fridge(String name, int price) {
		super(name, price);
	}

	@Override
	public String toString() {
		return "Fridge";
	}
}

class Buyer {
	String name;
	int money;
	int mileage;

	Vector item = new Vector();

	public Buyer(String name, int money) {
		this.name = name;
		this.money = money;
	}

	void buy(Product p, int qty) {
		if (money < p.price * qty) {
			System.out.println("돈가져와");
			return;
		}

		mileage += p.bonusPoint;
		money -= p.price;
		item.add(p);
		System.out.println(name + "고객님  " + p + ", " + qty + "개 " + "구매하셨습니다.");
	}

	// 1. 영수증
	void summary(Product p) {
		int sum = 0;

		System.out.println("\t영\t수\t증");
		System.out.println("구매목록" + "\t\t수량" + "\t가격");

		if (item.size() == 0) {
			System.out.println("구매 하신 물건이 없습니다.");
			return;
		}

		for (int i = 0; i < item.size(); i++) {
			if (item.get(i) instanceof Product) {
				Product p1 = ((Product) item.get(i));
				System.out.println(p1.name + "\t\t" + p1.count + "\t"
						+ p1.price);
				sum += p1.price * p1.count; // 총합=가격*수량
			}
		}
		System.out.println("총합\t\t\t" + sum + "\n" + name + " 고객님 " + money
				+ "만원 남아있고 마일리지는 " + mileage + "점 입니다." + "\n"
				+ "좋은하루 보내세요 호갱님~");
	}

	// 2. 환불
	void refund(Product p) {
		int sum = 0;
		if (item.isEmpty()) {
			System.out.println("구매하신 물건이 없습니다.");
		}
		if (item.remove(p)) {
			money += p.price; // 돈에 다시 환불한 돈 추가
			mileage -= p.bonusPoint; // 마일리지도 다시 추가
			System.out.println(p + "반품 하셨습니다.");
			summary(p);
		} else {
			System.out.println(p + "를 구매하신적 없습니다.");
		}

	}

}

// 3. 상품 수량 관리
class Product_QTY {

}

// 4.고객 목록 관리
class Mem_Manage {

}
