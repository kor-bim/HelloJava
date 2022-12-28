package kr.or.ddit.basic;

/**
 * 람다식 => 익명함수를 생성하기 위한 식<br>
 * 자바에서는 '매개변수를 가진 코드 블럭' => 런타임시 익명구현 객체로 생성된다.<br>
 * <br>
 * 형식)<br>
 * 인터페이스명 객체변서명 = 람다식;<br>
 * <br>
 * 람다식의 형식)<br>
 * (매개변수들 ,,,) -> (처리할 코드들;,,,,)<br>
 * <br>
 * => 람다식으로 변환할 수 있는 인터페이스는 추상메서드가 1개인 인터페이스만 처리할 수 있다.<br>
 * 이런 인터페이스를 '함수적 인터페이스' 라고 한다.<br>
 * 이 함수적 인터페이스를 만들 때는 @FunctionInterface 로 지정한다.
 */
public class T01_LamdaTest {
	public static void main(String[] args) {

		// 람다식을 사용하지 않는 경우
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}

			}
		});
		th1.start();

		// 람다식을 사용하는 경우
		Thread th2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("람다 - " + i);
			}
		}

		);
		th2.start();

	}
}
