package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hotel_Test {
	static Map<Integer, String> check = new HashMap<>();
	static List<RoomStat> roomList = new ArrayList<>();
	public static void main(String[] args) {
//		File file = new File("d:/D_Other/room.bin");
		Scanner sc = new Scanner(System.in);
		newFile(); // 경로내의 d:/D_Other/room.bin 파일이 없을 경우 생성
		load(); // 프로그램 시작과 동시에 기존의 정보를 불러와서 Map에 저장
		while (true) {
			System.out.println("**************************");
			System.out.println("\t호텔 문을 열었습니다.");		
			System.out.println("**************************");
			
			System.out.println("*******************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************");
			
			int select;
			try {
				select = sc.nextInt();
				switch (select) {
				case 1:
					checkIn();
					break;
				case 2:
					checkOut();
					break;
				case 3:
					viewRoom();
					break;
				case 4:
					shutDown();
					break;
				default:
					System.out.println("올바르지 않은 입력입니다.");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("잘못된 접근입니다.");
			}
		}
	}
	
	/**
	 * 최초로 파일이 없을 경우 파일생성
	 */
	private static void newFile() {
		File hotel = new File("d:/D_Other/room.bin");
		if (hotel.exists()) { // 경로에 room.bin파일이 존재할 경우
			return;
		}else { // 경로에 room.bin파일이 존재하지않을 경우
			try {
				ObjectOutputStream room = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream("d:/D_Other/room.bin")));
				// 경로에 room.bin을 생성한다
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 종료하면서 호텔의 정보를 저장하는 메서드
	 */
	private static void shutDown() {
		try {
			// 사용자가 콘솔에 입력한 내용을 입력받는 보조스트림
			// 파일로 출력하는 문자기반 스트림 객체 생성, buffer와 object 보조스트림
			ObjectOutputStream room = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("d:/D_Other/room.bin")));

			room.writeObject(check); // 저장된 호텔정보를 파일에 저장한다.
			room.close(); // 반납
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("이용해주셔서 감사합니다.");
		System.exit(0);

	}

	/**
	 * 프로그램시작시 기존의 호텔정보를 담은 파일을 불러오는 메서드
	 */
	private static void load() {
		
		try {
			ObjectInputStream roomStat = 
					new ObjectInputStream( 
							new BufferedInputStream( // 보조스트림
									new FileInputStream("d:/D_Other/room.bin")));// 보조스트림
			Object obj = null; // 받아주는 Object
			
			try {
				while((obj=roomStat.readObject())!=null) {
					check = (Map<Integer, String>) obj; // 캐스팅 후 대입
				}
				roomStat.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 체크아웃하는 메서드
	 */
	private static void checkOut() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("체크아웃하실 방번호를 입력해주세요");
			System.out.print("방번호 : ");
			int roomNum = 0;
			try {
				roomNum = sc.nextInt();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("잘못된 입력입니다.");
				return;
			}
			System.out.println();

			if (!check.containsKey(roomNum)) { // Map에 해당 방번호가 포함되어있느지 확인
				System.out.println("체크인된 방번호가 없습니다.");
				System.out.println("다시 확인해주세요");
				return;
			}else {
				check.remove(roomNum); // 방번호로 map에서 방을 제거
				System.out.println("체크아웃이 완료되었습니다.");
				break;
			}
		}
	}


	/**
	 * 체크인상태를 확인하는 메서드
	 */
	private static void viewRoom() {
		Set<Integer> roomNum = check.keySet();
		Iterator<Integer> rooms = roomNum.iterator();
		
		System.out.println("=========객실내용========");

		if (!rooms.hasNext()) { // iteraotr의 다음 값이 없을때
			System.out.println("체크인 된 방이 없습니다.");
			return;
		}
			else {
			while (rooms.hasNext()) { // rooms의 다음값이 없을 때까지 반복
				int roomnum = rooms.next();
				String human = check.get(roomnum);

				System.out.println("방번호 : " + roomnum);
				System.out.println("투숙객 : " + human);
				System.out.println("------------------------------------------");
			}
		}
	}
	
	
	/**
	 * 체크인하는 메서드
	 */
	private static void checkIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 : ");
		int roomNum = 0;
		try {
			System.out.println();
			roomNum = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			e.printStackTrace();
			return;
		}
		if (check.containsKey(roomNum)) {
			System.out.println("이미 체크인 되어있는 방입니다.");
			System.out.println("다른 방을 골라주세요");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름  : ");
		String name = sc.next();
		check.put(roomNum, name); // Map에 방번호와 투숙객을  put한다.
		System.out.println("체크인이 완료되었습니다.");
	}
	
	/**
	 * 방번호와 이름이 담긴 객체
	 * 직렬화
	 * @author PC-08
	 *
	 */
	static class RoomStat implements Serializable{
		private String name;
		private int roomNum;
		
		public RoomStat(String name, int roomNum) {
			super();
			this.name = name;
			this.roomNum = roomNum;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getRoomNum() {
			return roomNum;
		}
		public void setRoomNum(int roomNum) {
			this.roomNum = roomNum;
		}
	}
}
