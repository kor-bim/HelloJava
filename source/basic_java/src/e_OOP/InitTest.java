package e_OOP;

public class InitTest {
	public static void main(String[] args) {

		Init it = new Init(1);
		System.out.println(it.action);//명시적 -> 초기화블럭    (클래스)
		System.out.println(it.action2);//명시적 -> 초기화블럭 -> 생성자    (인스턴스)
		int[] a = new int[2];
	
		
	}
}

class Init {
	static int action = 100;//명시적 초기화
	int action2;

	Init(int action2) {//생성자 초기화
		this.action2 = action2;
	}

	static { //초기화블럭(클래스)
		action = 10;
	}
	
	{//초기화(인스턴스)
		action2=70;
	}
}