package y_project;

import java.util.Scanner;

public class View {

	public void startMethod() {
		System.out.println("어서오세요 영만마트에요");
		System.out.println("원하시는 메뉴를 선택해주세요");
		System.out.println("1. 물품추가");
		System.out.println("2. 로그인");
		System.out.println("3. 종료");

		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();

		switch (select) {
		case 1:
			addProdcut();
			break;
		case 2:
			// logIn();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("1,2,3에 골라주세요");
			break;
		}
	}

	private void addProdcut() {
		// 이름, 가격
		Scanner sc = new Scanner(System.in);

		System.out.println("물건의 이름을 입력해주세요");
		String name = sc.next();
		System.out.println("물건의 가격을 입력해주세요");
		int price = sc.nextInt();

		Service sv = new Service();
		boolean result = sv.addProduct(name,price);
		if(result){
			System.out.println("물품등록에 성공하셨습니다.");
		}
	}

}
