package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class T07_Lotto {
	Scanner sc = new Scanner(System.in);
	int[] num = new int[6];

	void LottoMain() {
		while (true) {
			System.out.println("==========================");
			System.out.println("\tLotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			int select = 0;
			try {
				select = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요.");
				sc.nextLine();
				continue;
			}
			switch (select) {
			case 1:
				Lotto lo = buy();
				print(lo);
				break;
			case 2:
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	Lotto buy() {
		while (true) {

			System.out.println("1000원에 로또 하나입니다");
			System.out.print("금액입력 : ");
			int money = 0;
			int lottoPrice = 1000;
			try {
				money = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요.");
				sc.nextLine();
				continue;
			}
			System.out.println();
			Lotto lo = new Lotto(money, money / lottoPrice, money % lottoPrice);
			return lo;
		}
	}

	void print(Lotto lo) {
		Set<Integer> intRnd = new HashSet<>();
		int money = lo.getMoney();
		int cnt = lo.getCnt();
		int chan = lo.getChan();
		System.out.println("행운의 로또번호는 아래와 같습니다");

		for (int i = 1; i < cnt + 1; i++) {
			while (intRnd.size() < 6) {
				int num = (int) (Math.random() * 44 + 1);
				intRnd.add(num);
			}
			System.out.println("로또번호 : " + i + "" + intRnd);
			intRnd.clear();
		}
		System.out.println("받은 금액은" + money + "원이고 거스름돈은 " + chan + "원입니다.");

	}

	public static void main(String[] args) {
		T07_Lotto t = new T07_Lotto();
		t.LottoMain();
	}
}

class Lotto {
	private int money;
	private int cnt;
	private int chan;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Lotto(int money, int cnt, int chan) {
		super();
		this.money = money;
		this.cnt = cnt;
		this.chan = chan;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getChan() {
		return chan;
	}

	public void setChan(int chan) {
		this.chan = chan;
	}

}
