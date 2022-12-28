package kr.or.ddit.basic;

public class T09_ThreadDaemonTest {
	public static void main(String[] args) {
		Thread autoSave = new AutoSaveThread();

		// 데몬스레드로 설정하기 -> start()메서드 호출 전에 설정해야한다.
		autoSave.setDaemon(true);
		autoSave.start();

		try {
			for (int i = 1; i <= 20; i++) {
				System.out.println("작업" + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메인 쓰레드 종료");
	}
}

/**
 * 자동 저장하는 쓰레드(3초에 한번씩)
 */
class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업내용을 저장합니다");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save();
		}
	}
}
