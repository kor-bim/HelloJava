package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 파일에 출력하기
 */
public class T06_FileStreamTest {
	public static void main(String[] args) {
		// 파일에 출력하기
		FileOutputStream fos = null;

		try {
			// 출력용 OutputStram 객체 생성
			fos = new FileOutputStream("d:/D_Other/out.txt");
			for (char ch = 'a'; ch <= 'z'; ch++) {
				fos.write(ch);
			}
			System.out.println("파일에 쓰기 작업 완료..");
			// 쓰기 작업 완류 후 스트림 닫기
			fos.close();

			// ===========================================
			// 저장된 파일의 내용을 읽어와 화면에 출력하기
			FileInputStream fis = new FileInputStream("d:/D_Other/out.txt");
			int c;
			while ((c = fis.read()) != -1) {
				System.out.print((char) c);
			}
			System.out.println();
			System.out.println("출력 끝...");
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");
		} catch (IOException e) {
			System.out.println("알 수 없는 입출력 오류입니다.");
		}
	}
}
