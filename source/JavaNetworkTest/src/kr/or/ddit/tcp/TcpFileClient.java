package kr.or.ddit.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpFileClient {
	/**
	 * 클라이언트는 서버에 접속하여 서버가 보내주는 파일을 d:/C_Lib폴더에 저장한다.
	 */
	public void clientStart() {
		File file = new File("d:/C_Lib/Tulips.jpg"); // 저장할 파일 설정

		try (Socket socket = new Socket("localhost", 7777);
				InputStream is = socket.getInputStream();
				FileOutputStream fos = new FileOutputStream(file);) {

			System.out.println("파일 다운로드 시작...");

			byte[] tmp = new byte[1024];
			int length = 0;
			while ((length = is.read(tmp)) != -1) {
				fos.write(tmp, 0, length);
			}
			fos.flush();
			System.out.println("파일 다운로드 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}
}
