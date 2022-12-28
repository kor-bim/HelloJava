package f_OOP2;

import java.util.Arrays;
import java.util.Scanner;

public class DeckTest {
	public static void main(String[] args) {	
		// 7.카드 한벌의 객체를 생성
		Deck d = new Deck();
		// 8.0번 index의 카드 한장을 뽑기
		System.out.println(d.pick(0).toString());
		// 9.임의의 index번째 카드 한 장을 뽑기
		System.out.println(d.pick().toString());
		// 10.카드를 자동섞기
		d.suffle();
		// 11.0번 index의 카드를 한 장을 뽑기
		System.out.println(d.pick(0).toString());
		// 12.카드 1000번 섞기
		d.suffle(1000);
		// 13.0번 index의 카드 한 장을 뽑기
		System.out.println(d.pick(0).toString());
	}
}

class Deck {
	// 1. 카드의 수량을 저장할수 있는 변수 CARD_NUM을 선언하고
	// Card클래스의 상수를 이동하여 초기화하여라
	static final int CARD_NUM = Card.NUM_MAX * Card.KIND_MAX;

	// 2. 카드 52장을 저장할수 있는 변수 c를 선언 및 생성하여라
	Card[] c = new Card[CARD_NUM];

	// 3. 기본생성자를 만들어라
	// c의 모든방들의 값을 1,1 ~ 4,13까지의 카드로 초기화하여라.

	Deck() {
		int count = 0;
		for (int i = 0; i < Card.KIND_MAX; i++) {
			for (int j = 0; j < Card.NUM_MAX; j++) {
				c[count++] = new Card(i + 1, j + 1);
			}
		}
	}

	// 4.사용자로부터 입력받은 index번째 카드 한장을 반환하는 매서드 pick
	Card pick(int index){
		return c[index];
	}

	//5. pick c의 방중에 임의의 index번째 카드 한장을 반환하는 메서드
	//단, 4번에서 만든 pick를 활용해주세요
	Card pick(){
		return pick((int)(Math.random()*CARD_NUM));
	}

	// 6.c의 카드를 섞는 메서드 shuffle을 작성하여라 - 자동섞기
	// 단 카드 섞는 연습문제 5-6 방법을 활용
	void suffle() {
		for (int i = 0; i < CARD_NUM; i++) {
			Card tmp;
			int r = (int) (Math.random() * CARD_NUM);
			tmp = c[i];
			c[i] = c[r];
			c[r] = tmp;
		}
	}

	// 7.사용자로부터 입력받은 횟수만큼 c의 카드를 섞는 메서드를 작성하여라
	// 단 임의의 방 두개를 뽑아 두개의 index번째 요소의 위치를 바꾼다. 이를 사용자로 부터 입력받은 횟수만큼 반복한다.
	void suffle(int a) {
		for (int i = 0; i < a; i++) {
			int r = (int) (Math.random() * CARD_NUM);
			int r2 = (int) (Math.random() * CARD_NUM);
			if (r != r2) {
				Card tmp;
				tmp = c[r];
				c[r] = c[r2];
				c[r2] = tmp;
			}
		}
	}
}

class Card {
	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	static final int SPADE = 1;
	static final int DIAMOND = 2;
	static final int HEART = 3;
	static final int CLOVER = 4;

	static int width = 100;
	static int height = 250;

	int kind;
	int number;

	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	Card() {
		this(SPADE, 1);

	}
	@Override
	public String toString() {
		String kind = "";
		String number = "";

		switch (this.kind) {
		case 1:
			kind = "♠";
			break;
		case 2:
			kind = "◆";
			break;
		case 3:
			kind = "♥";
			break;
		case 4:
			kind = "♣";
			break;
		default:
			kind = "♣";
			break;
		}
		switch (this.number) {
		case 1:
			number = "A";
			break;
		case 11:
			number = "J";
			break;
		case 12:
			number = "Q";
			break;
		case 13:
			number = "K";
			break;
		default:
			number += this.number;
			break;
		}

		return kind + "," + number;
	}
}
