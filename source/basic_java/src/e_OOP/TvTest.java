package e_OOP;

public class TvTest {
	public static void main(String[] args) {
		System.out.println(Tv.color);
		Tv.color="black";
		System.out.println(Tv.color);
		Tv.changeColor();
		System.out.println(Tv.color);
		
		
		//인스턴스화=>인스턴스
		Tv t = new Tv();
		System.out.println(t.channel);
		t.channel = 10;
		System.out.println(t.channel);
		t.channelUp();
		System.out.println(t.channel);
		t.volume = 15;
		System.out.println(t.volume);
		t.volumeUp();
		System.out.println(t.volume);
	}
}

class Tv{
	//전역 변수(멤버 변수)
	//클래스 변수
	static String color;
	//인스턴스 변수
	int channel;
	int volume;
	
	//클래스 메소드
	static void changeColor(){
		color = "yellow";
	}
	
	//인스턴스 메소드
	void channelUp(){
		channel++;
	}
	
	void volumeUp(){
		volume++;
	}
	
	
}
