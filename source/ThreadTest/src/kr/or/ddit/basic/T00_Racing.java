package kr.or.ddit.basic;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T00_Racing {
	static int hRank;
	static List<Horse> list = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			list.add(new Horse(i + "번 말"));
		}
		for (Horse horse : list) {
			horse.start();
		}
		Print p = new Print(list);
		p.setDaemon(true);
		p.start();
		for (Horse dc : list) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Collections.sort(list);
		System.out.println("========================");
		System.out.println("\t경기 끝!");
		System.out.println("========================");
		System.out.println();
		System.out.println("경기 결과");
		for(Horse horse : list) {
			System.out.println(horse.getRank() + "등 : " + horse.gethName());
		}
	}
}

class Print extends Thread {
	private List<Horse> list = new ArrayList<>();

	public Print(List<Horse> list) {
		this.list = list;
	}

	@Override
	public void run() {
		while (true) {
			for (Horse horse : list) {
				System.out.println();
				for (int i = 0; i < 50; i++) {
					if (i == horse.getPosition()) {
						System.out.print("🐌");
					}else{
						System.out.print("=");
					}
				}
				System.out.println(horse.gethName());
			}
			System.out.println();
			try {
				Thread.sleep((int) (Math.random() * 100 + 50));
			} catch (InterruptedException e) {
				
			}		
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String hName;
	private int rank;
	private int position;

	public Horse(String name) {
		this.hName = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {
		rank = 1;

		for (int i = 0; i < 50; i++) {
			setPosition(i);
			try {
				Thread.sleep((int) (Math.random() * 100 + 50));
			} catch (InterruptedException e) {

			}
		}
		rank = T00_Racing.hRank + 1;
		T00_Racing.hRank++;
	}

	@Override
	public int compareTo(Horse horse) {
		Integer tmp = new Integer(getRank());
		return tmp.compareTo(horse.getRank());
	}
}
