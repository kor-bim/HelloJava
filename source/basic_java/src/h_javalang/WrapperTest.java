package h_javalang;

public class WrapperTest {
	public static void main(String[] args) {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		System.out.println(i1);
		System.out.println(i2); // wrapper클래스는 toString이 전부 Override됨
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		
		Integer[] intArr = new Integer[3];
		intArr[0] = 5; //int 기본형으로 자동으로 변환 auto-boxing
		intArr[1] = 10;
		intArr[2] = 40;
		
		int b = intArr[0];// auto-unboxing Integer타입을 기본값으로 변환
	}
}
