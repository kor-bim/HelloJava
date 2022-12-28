

package e_OOP;

public class CardTest {
	public static void main(String[] args) {
		//1. Card 클래스의 폭을 출력하라
		System.out.println(Card.width);
		//2. Card 클래스의 높이를 출력하라
		System.out.println(Card.heigh);
		//3. Card클fo스의 객체를 생성하라 cd1
		Card cd1 = new Card();
		//4. 변수 cd1의 이름을 "Daniel"로 변경하라
		cd1.name = "Daniel";
		//5. 변수 cd1의 직원 번호를 19961210으로 변경하라
		cd1.number = 19961210;
		//6. Card클래스의 객체를 생성하라 cd2
		Card cd2 = new Card();
		//7. 변수 cd2의 이름을 "nayeon"로 변경하라
		cd2.name = "nayeon";
		//8. 변수 cd2의 직원 번호를 19950922으로 변경하라
		cd2.number = 19950922;
		//9. cd1의 정보를 출력하라
		System.out.println("1번 카드의 이름은 "+cd1.name+", "+ "직원번호 "+cd1.number+", "+"폭은 "+Card.width+"높이는 "+Card.heigh+"이다");
		//10. Card클래스의 폭을 70으로 변경하라
		Card.width = 70;
		//11. Card클래스의 높이을 1000으로 변경하라
		Card.heigh = 100;
		//12. cd2의 정보를 출력하라
		System.out.println("1번 카드의 이름은 "+cd2.name+", "+ "직원번호 "+cd2.number+", "+"폭은 "+Card.width+"높이는 "+Card.heigh+"이다");
		
	}
}
class Card{
	String name;
	int number;
	static int width = 100;
	static int heigh = 250;
}
