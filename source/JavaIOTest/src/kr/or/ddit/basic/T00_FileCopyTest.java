package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class T00_FileCopyTest {
	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {

			fis = new FileInputStream("d:/D_Other/Tulips.jpg"); // 읽을파일
			fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg"); // 복사할파일

			int c;

			// buffer 이용
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos, 5);
			while ((c = bis.read()) != -1) {
				bos.write(c);
			}
			System.out.println("작업완료");
			bis.close();
			bos.close();

			// ===================================================
			// buffer 비이용
			while ((c = fis.read()) != -1) {
				fos.write(c);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {

		}
	}
}
