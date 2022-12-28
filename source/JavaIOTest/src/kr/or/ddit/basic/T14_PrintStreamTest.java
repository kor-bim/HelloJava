package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 프린터 기능 제공 보조 스트림 예제
 */
public class T14_PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");

		// PrintStream은 모든 자료형을 출력할 수 있는 기능을 제공하는 OutputStream의 서브클래스이다. printStream은
		// IOException을 발생시키지 않는다. println and print 등 메서드 호출시마다 autoflush 기능 제공됨.

		PrintStream out = new PrintStream(fos);
		// PrintStream out = new PrintStream(System.out);
		out.print("안녕하세요. PrintStream 입니다 \n");
		out.println("안녕하세요. PrintStream 입니다.2");
		out.println("안녕하세요. PrintStream 입니다.3");
		out.println(out); // 객체 출력
		out.println(3.14);

		/**
		 * PrintStream은 데이터를 문자로 출력하는 기능을 수행함.(System.out)<br>
		 * 향상된 기능의 PrintWriter가 추가되었지만 계속 사용됨.<br>
		 * <br>
		 * PrintWriter가 PrintStream보다 다양한 언어의 문자를 처리하는데 적합하다.<br>
		 * 둘 다 기본적으로 autoflush 기능이 꺼져있음.
		 */
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fos2, "UTF-8"));
		writer.print("안녕하세요. PrintWriter 입니다.\r\n");
		writer.println("안녕하세요. PrintWriter 입니다.2");
		writer.println("안녕하세요. PrintWriter 입니다.3");

		writer.close();
	}
}
