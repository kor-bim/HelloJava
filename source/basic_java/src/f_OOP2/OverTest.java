package f_OOP2;

public class OverTest {
	private static final String OverUP = null;

	public static void main(String[] args) {
		OverGo og = new OverGo();
		String a = og.overMethod();
		System.out.println(a);
		
		
		System.out.println(og.value);
		
		int b = og.getOverUpValue();
		System.out.println(b);
	}
}

class OverUp {
	int value = 10;

	String overMethod() {

		return "OverUp Method";
	}
}

class OverGo extends OverUp {
	int value = 20;

	@Override
	String overMethod() {

		return "OverGo Method";
	}

	String overMethod(int k) {

		return k + "OverGo Method";
	}
	
	int getOverUpValue(){
		return super.value;
	}
}
