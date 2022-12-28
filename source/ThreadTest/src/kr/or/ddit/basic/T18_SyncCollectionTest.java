package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Vector, HashTable등 예전부터 존재하던 Collection 클래스들은 내부에 동기화 처리가 되어있다. 그런데 최근에 새로
 * 구성된 Collection들은 동기화 처리가 되어있지 않다. 그래서 동기화가 필요한 프로그램에서 이런 Collection들을 사용하려면
 * 동기화 처리를 한후에 사용해야 한다.
 */
public class T18_SyncCollectionTest {
	// 동기화 처리를 하지 않을 경우..
	private static List<Integer> list1 = new ArrayList<>();

	// 동기화하는 경우
	// Collections의 정적메서드 주에서 synchronized로 시작하는 메서드 사용
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) {
		// 익명클래스로 쓰레드 구현
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10000; i++) {
					list1.add(i); // 동기화 처리를 하지 않은 리스트 사용
					list2.add(i); // 동기화 처리를 한 리스트 사용
				}
			}
		};
		Thread[] ths = new Thread[] { new Thread(r), new Thread(r), new Thread(r), new Thread(r), new Thread(r) };

		long startTime = System.currentTimeMillis();
		for (Thread th : ths) {
			th.start();
		}
		for (Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("처리시간(㎳) :" + (endTime - startTime));

		System.out.println("list1의 갯수 : " + list1.size());
		System.out.println("list2의 갯수 : " + list2.size());
	}
}
