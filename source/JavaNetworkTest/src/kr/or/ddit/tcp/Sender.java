package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 소켓을 통해서 메시지를 보내는 역할을 담당한다.
 */
public class Sender extends Thread {
	private DataOutputStream dos;
	private String name;

	public Sender(Socket socket) {
		name = "[" + socket.getInetAddress() + " : " + socket.getLocalPort() + "]";

		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (dos != null) {
			try {
				dos.writeUTF(name + " >>> " + sc.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}