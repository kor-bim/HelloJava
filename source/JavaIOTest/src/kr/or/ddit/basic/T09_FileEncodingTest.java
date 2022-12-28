package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReader 객체는 파일의 인코딩 방식을 지정할 수 있다.<br>
 * 형식) new InputStreamReader(바이트 기반 스트림 객체, 인코딩방식)<br>
 * <br>
 * <인코딩 방식><br>
 * 한글 인코딩 방식은 크게 UTF-8과 EUC-KR, 방식 두가지로 나뉜다.<br>
 * 원래 한글 윈도우는 CP949방식을 사용했는데, 윈도우를 개발한 마이크로소프트에서 EUC-KR 방식에서 확장하였기 때문에 MS949라고도
 * 부른다.<br>
 * CP949는 EUC-KR의 확장이며, 하위 호환성이 있다.<br>
 * <br>
 * MS-949 => 윈도우의 기본 한글 인코딩방식(ANSI계열)<br>
 * UTF-8 => 유니코드 UTF-8 인코딩방식(영문자 및 숫자 : 1byte, 한글 : 3byte) => 가변적<br>
 * <br>
 * ANSI는 영어를 표기하기 위해 만든 코드 규격으로 차체에 한글이 없었다가 나중에 여기에 EUC-KR(유닉스 계열),
 * CP949(윈도우)라는 한글이 포함됨.<br>
 */
public class T09_FileEncodingTest {
	public static void main(String[] args) {
		// 파일 인코딩을 이용하여 읽어오기
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
			/**
			 * FileInputStream객체를 생성한 후 이 객체를 매개변수로 받는 InputStreamReader객체를 생성한다. <br>
			 * (바이트 입력 스트림에 연결되어 문자 입력 스트림인 Reader로 변환시키는 보조스트림)
			 */
			fis = new FileInputStream("d:/D_Other/test_utf8.txt");
			//fis = new FileInputStream("d:/D_Other/test_ansi.txt");
			// isr = new InputStreamReader(fis);
			// isr = new InputStreamReader(fis,"euc-kr");
			isr = new InputStreamReader(fis, "utf-8");
			int c;
			while ((c = isr.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println();
			System.out.println("출력 끝...");
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
