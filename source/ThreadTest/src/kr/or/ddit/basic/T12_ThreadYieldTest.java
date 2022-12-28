package kr.or.ddit.basic;

/**
 * yield() 메서드에 대하여<br>
 * <br>
 * 1. 현재 실행 대기중인 동등한 우선순위 이상의 다른 쓰레드에게 실행기회를 제공한다.(양보)<br>
 * 2. 현재 실행중인 쓰레드의 상태를 Runnable상태로 바꾼다.(Waiting이나 Blocked상태로 바뀌지 않는다)<br>
 * 3. yield()를 실행한다고 해서 현재 실행중인 쓰레드가 곧바로 runnable로 상태로 전이된다고 확신할 수 없다.
 * 
 */
public class T12_ThreadYieldTest {
	public static void main(String[] args) {
		Thread th1 = new YieldThread1();
		Thread th2 = new YieldThread2();
		
		th1.start();
		th2.start();
	}
}

/**
 * 양보 기능 테스트용 쓰레드 클래스
 */
class YieldThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("YieldThread 1 : " + i);
			Thread.yield(); // 양보하기
		}
	}
}

class YieldThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("YieldThread 2 : " + i);

		}
	}
}