package f_OOP2;

public class InnerTest {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		i.method2(50);
	}
}

class Outer {
	int value = 10;

	class Inner {// 인스턴스 클래스
		int value = 20;

		void method2(int value) {
			System.out.println(value);//인자값
			System.out.println(this.value);//20
			System.out.println(Outer.this.value);//10
		}
	}

	static class Inner2 {// static 클래스

	}

	void method() {
		class Inner {// 지역 클래스

		}
	}
}
