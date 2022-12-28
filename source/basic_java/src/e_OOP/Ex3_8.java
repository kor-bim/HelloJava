package e_OOP;

public class Ex3_8 {
	public static void main(String[] args) {
		ExTest01 et01 = new ExTest01();
		ExTest02 et02 = new ExTest02(2);
	}
}

class ExTest01{
	int value;
	ExTest01() {
		
	}
}

class ExTest02{
	int value;
	ExTest02(int value){
		this.value=value;
	}
}