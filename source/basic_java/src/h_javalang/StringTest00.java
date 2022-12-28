package h_javalang;

public class StringTest00 {
	public static void main(String[] args) {

		StringTest.stringTest();
		StringTest.charAtTest();
		StringTest.compareToTest();
		StringTest.concat();
		StringTest.endswith();
		StringTest.indexOf();
		StringTest.length();
		StringTest.replace();
		StringTest.aplit();
		StringTest.substring();
		StringTest.toLowerCase();
		StringTest.toUpperCase();
		StringTest.trim();
		StringTest.valueOf();
	
		

	}
}

class StringTest {

	static void stringTest() {
		String s = new String("Hello");
		String s1 = new String("Hello");

		String s2 = "Hello";
		String s3 = "Hello";
	}
	static void charAtTest() {
		String s = "Hello";
		char c = s.charAt(1); //지정된 위치 문자를 알려준다
		System.out.println(c);
	}
	
	static void compareToTest(){
		int i = "aaa".compareTo("aaa"); //사전순서 비교
		int i2 = "aaa".compareTo("aab");
		System.out.println(i);
		System.out.println(i2);
		
	}
	
	static void concat(){
		String s = "Hello";
		String s2 = "Oracle"; // 덫붙힌다
		
		String s3 =s.concat(s2);
		System.out.println(s3);
	}
	
	static void contains(){
		String s = "JavaSoEz"; //포함되어있는지 검사
		boolean b = s.contains("e");
		System.out.println(b);
	}
	static void endswith(){
		String s = "JavaSoE"; //문자열검사
		boolean b = s.endsWith(s);
		System.out.println(b);
	}
	static void indexOf(){
		String s = "Hello"; //찾으면 위치번호 못찾으면 -1
		int b = s.indexOf('o');
		System.out.println(b);
	}
	static void length(){
		String s = "Hello";
		int b = s.length();
		System.out.println(b);
	}
	static void replace(){
		String s = "Hello Oracle";
		String b = s.replace("Oracle", "Java");
		System.out.println(b);
	}
	static void aplit(){
		String s = "dog-cat-snake";
		String[] sArr = s.split("-"); //구분자로 나눔
		for (int i = 0; i < sArr.length; i++) {
			System.out.print(sArr[i]+"\t");
		}
		
	}
	static void substring(){
		String s = "I Love You";
		String b = s.substring(2,6);
		System.out.println(b);
	}
	static void toLowerCase(){
		String s ="I Love You";
		String b = s.toLowerCase(); //소문자
		System.out.println(b);
	}
	static void toUpperCase(){
		String s ="I Love You"; //대
		String b = s.toUpperCase();
		System.out.println(b);
	}
	static void trim(){
		String s ="   I Love You   ";
		String b = s.trim();
		System.out.println(b);
	}
	static void valueOf(){
		int a = 10187;
		String b = String.valueOf(a);
		System.out.println(b);
	}

}
