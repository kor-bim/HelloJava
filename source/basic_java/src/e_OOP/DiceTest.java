package e_OOP;

import java.util.Scanner;

public class DiceTest {

	public static void main(String[] args) {

		DoubleDice dd = new DoubleDice();
		int result = dd.throwDice(dd.f, dd.s);
		System.out.println("총 이동거리 : " + result);

	}
}

class DoubleDice {

	// 주사위 두개를 던진다
	// 던진 주사위 두개의 합을 반환한다.
	int f = 0;
	int s = 0;

	int throwDice(int firstDice, int secondDice) {

		int result = 0;
		firstDice = (int) (Math.random() * 6 + 1);//주사위 1~6
		secondDice = (int) (Math.random() * 6 + 1);//주사위 1~6
		System.out.println(firstDice + "," + secondDice); // 출력1

		if (firstDice == secondDice) {
			System.out.println(firstDice + "," + secondDice); //출력2
			result = firstDice + secondDice + throwDice(f, s); // 재귀호출
		}
		result += firstDice + secondDice; //총 이동거리
		return result;
	}
}