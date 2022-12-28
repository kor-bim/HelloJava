package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 성능향상을 위한 보조스트림 예제
 */
public class T11_BufferedIOTest {
	public static void main(String[] args) {
		// 입출력 성능 향상을 위해서 버퍼를 이용하는 보조 스트림
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("d:/D_Other/bufferTest.txt");

			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8192(8kb)로 설정됨.

			// 버퍼의 크기가 5인 스트림 객체 생성
			bos = new BufferedOutputStream(fos, 5);
			for (int i = '1'; i <= '9'; i++) { // 숫자 자체를 문자로 지정하기 위해 '사용함
				bos.write(i);
			}
			bos.flush(); // 작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력 (close시 자동으로 호출됨)
			bos.close();
			System.out.println("작업 끝 ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
