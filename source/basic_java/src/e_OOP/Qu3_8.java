package e_OOP;

public class Qu3_8 {
	public static void main(String[] args) {
		// 7. 3번의 add메서드를 호출하여라
		int a = MyAdd.add(10);
		// 8. 4번의 add메서드를 호출하여라
		MyAdd ma = new MyAdd(8);
		int b = ma.add(10, 20);
		// 9. 5번의 add메서드를 호출하여라
		long c = ma.add(10, 30000L);
		// 10.6번의 add메서드를 호출하여라
		float d = ma.add('A', 3.148F);
		// 추가1
		long e = ma.add(200L, 10);
		// 추가2
		long f = ma.add1(10, 20);
	}
}

class MyAdd {

	MyAdd(int a){
		
	}
	// 1. 클래스 변수 a를 선언하고 20의 값으로 초기화 하여라
	static int a = 20;
	// 2. 인스턴스변수 b를 선언하고 15의 값을 초기화 하여라
	int b = 15;

	// 3. int타입의 매개변수가 하나이며 변수 a의 합을 반환하는 클래스메서드를 add를 작성하여라
	static int add(int x) {
		int result = a + x;
		return result;
	}

	// 4. int타입의 매개변수가 두개이고 매개변수의 합을 반환하는 인스턴스메서드를 add를 작성하여라
	int add(int a, int b) {
		int result = a + b;
		return result;
	}

	// 5. int타입, long타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스메서드 add를 작성하여라
	long add(int a, long b) {
		long result = a + b;
		return result;
	}

	// 6. char타입, float타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스 메서드 add를 작성하여라
	float add(char a, float b) {
		float result = a + b;
		return result;
	}

	// 추가1. 인스턴스 매서드 add, 매개변수는 long타입 하나와 int 타입 하나이며 매개변수의 합을 반환하는 매서드
	long add(long a, int b) {
		long result = a + b;
		return result;
	}

	// 추가2. 인스턴스 메서드 add, 매개변수 int 타입 두개이며 두개의 합을 반환하는 매서드. 단 반환타입이 long타입 이어야
	// 한다.
	long add1(int a, int b) {
		long result = (long) a + b;
		return result;
	}
}