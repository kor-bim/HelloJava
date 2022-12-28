package kr.or.ddit.start;

import java.util.Scanner;

import kr.or.ddit.board.BoardMain;
import kr.or.ddit.member.MemberMain;

public class Start {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		MemberMain memObj = new MemberMain();
		BoardMain brdObj = new BoardMain();
		int choice;
		do {
			System.out.println();
			System.out.println("----------------------");
			System.out.println("  === 작 업 선 택 ===");
			System.out.println("  1. 회원 작업");
			System.out.println("  2. 게시물 작업");
			System.out.println("  3. 작업 끝.");
			System.out.println("----------------------");
			System.out.print("원하는 작업 선택 >> ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				memObj.start();
				break;
			case 2:
				brdObj.start();
				break;
			case 3:
				System.out.println("작업을 종료합니다");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
				break;
			}
		} while (choice != 3);

	}
}
