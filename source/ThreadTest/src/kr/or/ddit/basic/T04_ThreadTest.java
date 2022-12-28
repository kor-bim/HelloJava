package kr.or.ddit.basic;

public class T04_ThreadTest {
	/**
	 * 1~20억까지 합계를 구하는데 걸린 시간 체크하기<br>
	 * 전체 합계를 구하는 직업을 단독으로 처리했을때(1개의 쓰레드를 사용했을때) <br>
	 * 여러 쓰레드로 분할해서 작업할때의 시간을 확인해보자.
	 */
	public static void main(String[] args) {
		// 단독으로 처리할 때
		SumThread sm = new SumThread(1L, 2000000000L);
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리할 때의 처리 시간(㎳) : " + (endTime - startTime));
		System.out.println("\n\n");

		
		
		SumThread[] sumThs = new SumThread[] { 
				new SumThread(1L, 500000000L), 
				new SumThread( 500000001L, 1000000000L),
				new SumThread(1000000001L, 1500000000L), 
				new SumThread(1500000001L, 2000000000L) 
		};
		
		startTime = System.currentTimeMillis();
		
		for (SumThread th : sumThs) {
			th.start();
		}
		
		for (SumThread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("분할해서 처리할 때의 처리 시간(㎳) : " + (endTime - startTime));
	}
}

class SumThread extends Thread {
	private long max, min;

	public SumThread(long min, long max) {
		this.max = max;
		this.min = min;
	}

	@Override
	public void run() {
		long sum = 0L;
		for (long i = 0; i < max; i++) {
			sum += i;
		}
		System.out.println(min + "~" + max + "까지의 합 : " + sum);
	}

}
