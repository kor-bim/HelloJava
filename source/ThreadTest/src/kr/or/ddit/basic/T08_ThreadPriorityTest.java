package kr.or.ddit.basic;

public class T08_ThreadPriorityTest {
	public static void main(String[] args) {
		Thread th1 = new Thread1();
		Thread th2 = new Thread1();
		Thread th3 = new Thread1();
		Thread th4 = new Thread1();
		Thread th5 = new Thread1();
		Thread th6 = new Thread1();
		Thread th7 = new Thread1();
		Thread th8 = new Thread1();
		Thread th9 = new Thread1();
		Thread th10 = new Thread2();

		// 우선 순위는 start()메서드를 호출하기 전에 설정해야한다.
		th1.setPriority(Thread.MIN_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		th3.setPriority(Thread.MIN_PRIORITY);
		th4.setPriority(Thread.MIN_PRIORITY);
		th5.setPriority(Thread.MIN_PRIORITY);
		th6.setPriority(Thread.MIN_PRIORITY);
		th7.setPriority(Thread.MIN_PRIORITY);
		th8.setPriority(Thread.MIN_PRIORITY);
		th9.setPriority(Thread.MIN_PRIORITY);
		th10.setPriority(Thread.MAX_PRIORITY);

		System.out.println("th1의 우선순위 : " + th1.getPriority());
		System.out.println("th2의 우선순위 : " + th2.getPriority());

		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
		th6.start();
		th7.start();
		th8.start();
		th9.start();
		th10.start();

		try {
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();
			th6.join();
			th7.join();
			th8.join();
			th9.join();
			th10.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("최대 우선순위 : " + Thread.MAX_PRIORITY);
		System.out.println("최소 우선순위 : " + Thread.MIN_PRIORITY);
		System.out.println("보통 우선순위 : " + Thread.NORM_PRIORITY);
	}
}

// 대문자를 출력하는 메서드
class Thread1 extends Thread {
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);

			// 아무것도 하지않는 반복문(시간때우기용)
			for (int i = 1; i < 1000000000; i++) {

			}

		}
	}
}

// 소문자를 출력하는 메서드
class Thread2 extends Thread {
	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println(ch);

			// 아무것도 하지않는 반복문(시간때우기용)
			for (int i = 1; i < 1000000000; i++) {

			}

		}
	}
}
