package e_OOP;

public class CarTest {
	public static void main(String[] args) {

		Car c = new Car();
		System.out.println(c.color + ", " + c.gearType + ", " + c.door);

		Car c2 = new Car("Gold", "Auto", 2);
		System.out.println(c2.color + ", " + c2.gearType + ", " + c2.door);

		Car c3 = new Car("Gold");
		System.out.println(c3.color + ", " + c3.gearType + ", " + c3.door);

	}
}

class Car {

	String color;
	String gearType;
	int door;

	Car() {
		color = "black";
		gearType = "Stick";
		door = 4;
	}

	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}

	Car(String color) {
		
		this();
		this.color = color;
		
	}
}