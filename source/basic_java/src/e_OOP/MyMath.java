package e_OOP;

public class MyMath {
	public static void main(String[] args) {
		// 12. add1메서드 호출
		MathTest.add1();
		// 13. add2메서드 호출
		MathTest mt = new MathTest();
		int a = mt.add2();
		// 14. add3메서드 호출
		MathTest.add3(10, 20);
		// 15. add4메서드 호출
		int b = mt.add4(10, 20);
		// 16. add5메서드 호출
		long c = mt.add5(10, 100);
		// 17. add6메서드 호출
		long d = mt.add6(10, 20, 30);
		// 18. add7메서드 호출
		String e = mt.add7("ABCD", (int)(Math.random() * 47+48));
	}
}

class MathTest {
	// 1. 클래스변수 a를 선언하고 10의 값으로 초기화 하여라
	static int a = 10;
	// 2. 클래스변수 b를 선언하고 20의 값으로 초기화 하여라
	static int b = 20;
	// 3. 인스턴스 변수 c를 선언하고 30의 값으로 초기화 하여라
	int c = 30;
	// 4. 인스턴스 변수 d를 선언하고 40의 값으로 초기화 하여라
	int d = 40;

	// 5. 클래스메서드 add1, 클래스변수 a,b의 합을 출력하는 메서드
	static void add1() {
		int result = a + b;
		System.out.println(result);
	}

	// 6. 인스턴스메서드 add2, 인스턴스변수 c,d의 합을 반환하는 메서드
	int add2() {
		int result = c + d;
		return result;
	}

	// 7. 클래스메서드 add3, 매개변수 int타입 두개를 받아 매개변수의 합을 출력하는 메서드
	static void add3(int a, int b) {
		int result = a + b;
		System.out.println(result);
	}

	// 8. 인스턴스메서드 add4, 매개변수 int타입 두개를를 받아 매개변수의 합을 반환하는 메서드
	int add4(int a, int b) {
		int result = a + b;
		return result;
	}

	// 9. 인스턴스메서드 add5, 매개변수 int타입 하나 long타입하나 매개변수의 합을 반환하는 메서드
	long add5(int a, long b) {
		long result = a + b;
		return result;
	}

	// 10. 인스턴스메서드 add6, 매개변수 long타입하나 int타입 두개, 매개변수 합을 반환하는 메서드
	long add6(long a, int b, int c) {
		long result = a + b + c;
		return result;
	}

	// 11. 인스턴스메서드 add7, 매개변수 문자열하나, 매개변수 48~94중 임의의 값과 문자열의 합을 반환하는 메서드
	String add7(String a, int b) {
		String result = a + b;
		return result;
	}
}
