package h_javalang;

public class StringBufferTest {
	public static void main(String[] args) {
		/*
		String str = "a";
		str += "a";
		str += "a";
		str += "a";
		str += "a";
		str += "a";
		str += "a";
		
		String str = "a";
		str = new StringBuffer(str).append("a").toStirng();
		str = new StringBuffer(str).append("a").toStirng();
		*/
		
//		String str = "a";
//		long start = System.currentTimeMillis();
//		for (int i = 0; i < 300000; i++) {
//			str += "a";
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end-start);
		
//		StringBuffer sb =new StringBuffer("a");
//		long start = System.currentTimeMillis();
//		for (int i = 0; i < 300; i++) {
//			sb.append("a");
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end-start);
		
		StringBuilder sb =new StringBuilder("a");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 300000000; i++) {
			sb.append("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
}
