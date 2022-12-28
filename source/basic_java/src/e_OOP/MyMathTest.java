package e_OOP;

public class MyMathTest {
	public static void main(String[] args) {
		//8. MethodTest클래스의 add1메서드를 호출하여라
		MethodTest.add1();
		//9. MethodTest클래스의 add2메서드를 호출하여라
		int a = MethodTest.add2(20);
		//10. MethodTest클래스의 add3메서드를 호출하여라
		MethodTest mt =new MethodTest();
		int b = mt.add3(20);
		//11. MethodTest클래스의 add4메서드를 호출하여라
		mt.add4();
	}
}

class MethodTest{
	// 1. 클래스 변수 a를 선언하고 10의 값으로 초기화 하여라
	static int a = 10;
	
	// 2. 클래수 변수 b를 선언하고 20의 값으로 초기화 하여라
	static int b = 20;
	
	// 3. 인스턴스 변수 c를 선언하고 50의 값으로 초기화 하여라
	int c = 50;

	// 4. 클래스 변수 a와 b의 값의 합을 출력하는 클래스 매서드 add1을 구현하라여라
	static void add1() {
		int result = a+b;
		System.out.println(result);
	}

	// 5. 클래수 변수 a,b 와 int타입의 매개변수 c의 합을 반환하는 클래스매서드 add2를 구현하여라
	static int add2(int c) {
		int result=MethodTest.a+MethodTest.b+c;
		return result;
	}
	
	// 6. 인스턴스변수 c와 int 타입의 매개변수 c의 합을 반환하는 인스턴스 메서드 add3를 구현하여라
	int add3(int c){
		int result = this.c +c;
		return result;
	}
	
	// 7. 인스턴스변수 c와 0~100사이의 임의의 정수의 합을 출력하는 인스턴스메서드를 구현하여라
	void add4(){
		int result =c+(int)(Math.random()*101);
		System.out.println(result);
	}
}

