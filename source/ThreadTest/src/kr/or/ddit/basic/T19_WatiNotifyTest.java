package kr.or.ddit.basic;

/**
 * wait()메서드 => 동기화 영역에서 락을 풀고 wait-set영역(공유 객체별 존재)로 이동시킨다.<br>
 * notify() 또는 notifyAll() 메서드 => wait-set영역에 있는 쓰레드를 깨워서 실행할 수 있도록 한다.<br>
 * (notify()는 하나, notifyAll()은 wait-set에 있는 전부를 깨운다.)<br>
 * wait()과 notify(), notifyAll()메서드는 동기화 영역에서만 실행 할 수 있고, Object클래스에서 제공하는 메서드
 * 이다.<br>
 */
public class T19_WatiNotifyTest {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		ThreadA tha = new ThreadA(workObj);
		ThreadB thb = new ThreadB(workObj);
		tha.start();
		thb.start();
	}
}

/**
 * 공통으로 사용할 객체
 */
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA()에서 작업중...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	public synchronized void methodB() {
		System.out.println("methodB()에서 작업중...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}

/**
 * WorkObject의 methodA()메서드만 호출하는 쓰레드
 */
class ThreadA extends Thread {
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			workObj.methodA();
		}
		System.out.println("ThreadA 종료");
	}
}

/**
 * WorkObject의 methodA()메서드만 호출하는 쓰레드
 */
class ThreadB extends Thread {
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			workObj.methodB();
		}
		System.out.println("ThreadB 종료");
	}
}