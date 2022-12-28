package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiChatClient {
	private Scanner scan = new Scanner(System.in);
	private String name; // 대화명

	/**
	 * 시작 메서드
	 */
	public void clientStart() {
		// 대화명 입력받기
		System.out.print("대화명 :");
		name = scan.next();

		try {
			Socket socket = new Socket("192.168.45.44", 7777);
			System.out.println("서버에 연결되었습니다");

			// 송신용 쓰레드 생성
			ClientSender sender = new ClientSender(socket, name);
			sender.start();

			// 수신용 쓰레드
			ClientReceiver receiver = new ClientReceiver(socket, name);
			receiver.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 메세지를 전송하는 내부클래스 Thread
	 */
	class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream dos;
		private String name;

		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;

			try {
				dos = new DataOutputStream(this.socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				// 시작하자마자 자신의 대화명을 서버로 전송
				if (dos != null) {
					dos.writeUTF(name);
				}
				while (dos != null) {
					// 키보드로 입력받은 메세지를 서버로 전송
					dos.writeUTF(scan.nextLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream dis;
		
		public ClientReceiver(Socket socket, String name) {
			this.socket = socket;

			try {
				dis = new DataInputStream(this.socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {

				while (dis != null) {
					// 키보드로 입력받은 메세지를 서버로 전송
					System.out.println(dis.readUTF());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MultiChatClient().clientStart();
	}
}