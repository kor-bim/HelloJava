package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class HotelManage {
	private Scanner sc = new Scanner(System.in);
	private Map<String, Room> hotelMap = new HashMap<String, Room>();
	Properties prop = new Properties();

	/**
	 * 실행을위한 메서드
	 * 
	 */
	public static void main(String[] args) {
		new HotelManage().start();
	}

	public void start() {
		System.out.println("**************************\r\n" + "호텔 문을 열었습니다.\r\n" + "**************************");
		while (true) {
			display();
			String select = sc.next();
			switch (select) {
			case "1":
				checkIn();
				break;
			case "2":
				checkOut();
				break;
			case "3":
				roomStatus();
				break;
			case "4":
				// 종료
				System.out.println("종료합니다");
				return;
			default:
				System.out.println("잘못입력했습니다. 다시 입력 해주세요");
			}// switch문
		} // while문
	}

	/**
	 * 객실 전체 정보를 불러오는 메서드
	 */
	private void roomStatus() {
		readProp();
		System.out.println("=================================================");
		for (Object key : prop.keySet()) {
			System.out.println(key + "호 : " + prop.getProperty((String) key));
		}
		System.out.println("=================================================");
		System.out.println("출력완료!");
	}

	/**
	 * 체크아웃하는 메서드 정보 삭제
	 */
	private void checkOut() {
		readProp();
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 >> ");
		String roomNum = sc.next();
		prop.remove(roomNum);
		storeProp();
		// remove(key) => 삭제 성공하면 삭제된 value값을 반환하고, 실패하면 null 반환한다.
		if (hotelMap.remove(roomNum) == null) {
			System.out.println(roomNum + "호에는 체크인한 사람이 없습니다");
		} else {
			System.out.println(roomNum + "호 체크아웃 되었습니다");
		}
	}

	/**
	 * 체크인하는 메서드
	 * 
	 */
	private void checkIn() {
		readProp();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 >>");
		String roomNum = sc.next();
		// 이미 등록된 사람인지 검사
		// get()메서드로 값을 가져올 때 가져올 자료가 없으면 null을 반환란다.
		if (prop.getProperty(roomNum) != null) {
			System.out.println(roomNum + "호에는 이미 사람이 있습니다.");
			return;
		}

		System.out.print("이름입력 >>");
		String name = sc.next();

		hotelMap.put(roomNum, new Room(roomNum, name));
		Room r = hotelMap.get(roomNum);
		prop.setProperty(roomNum, r.getName());
		storeProp();
	}

	/**
	 * 메뉴화면
	 */
	public void display() {
		System.out.println("*******************************************\r\n" + "어떤 업무를 하시겠습니까?\r\n"
				+ "1.체크인  2.체크아웃 3.객실상태 4.업무종료\r\n" + "*******************************************");
		System.out.print("메뉴선택 =>");
	}

	/**
	 * properties 읽어오는 메서드
	 */
	private void readProp() {
		try {
			FileReader resources = new FileReader("src/kr/or/ddit/basic/hotelStatus.properties");
			prop.load(resources);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {

		}
	}

	/**
	 * properties 저장하는 메서드
	 */
	private void storeProp() {
		try {
			prop.store(new FileOutputStream("src/kr/or/ddit/basic/hotelStatus.properties"), "호텔 객실상태");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {

		}
	}
}

/**
 * 호텔 정보를 저장히기 위한 VO 클래스
 * 
 * @author 윤한빈
 * @since 2020.09.16
 */
class Room {
	private String name;
	private String roomNum;

	public Room(String roomNum, String name) {
		super();
		this.roomNum = roomNum;
		this.name = name;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}