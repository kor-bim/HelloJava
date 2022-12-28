package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class T04_ByteArrayIOTest {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		byte[] temp = new byte[4];

		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			// available() => 읽어 올 수 있는 byte수를 반환
			// while (bais.available() > 0) {
			int len;
			while ((len = bais.read(temp)) != -1) {
				// bais.read(temp); // temp배열 크기만큼 자료를 읽어와 temp배열에 저장한다.
				// baos.write(temp);// temp배열의 내용을 출력한다.

				// 실제 읽어온 byte수를 반환한다.
				len = bais.read(temp);

				// temp배열의 내용 중에서 0번째 부터 len개수만큼 출력
				baos.write(temp, 0, len);

				System.out.println("temp : " + Arrays.toString(temp));

			}
			outSrc = baos.toByteArray();

			System.out.println("inSrc => " + Arrays.toString(inSrc));
			System.out.println("outSrc => " + Arrays.toString(outSrc));

			// 스트림 객체 닫아주기
			bais.close();
			baos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
