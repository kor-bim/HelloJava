package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelManageIO {
	Map<String, Room> hotelMap = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new HotelManageIO().start();
	}

	public void start() {
		System.out.println("\r\n" + "*******************************************\r\n"
				+ "    ヾ(≧▽≦*)o 🕍호텔 문을 열었습니다 🕍o(*￣▽￣*)ブ\r\n" + "\r\n"
				+ "*******************************************");
		load();
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
				save();
				System.out.println("    (∪.∪ )...zzz 종료합니다 (∪.∪ )...zzz");
				return;
			default:
				System.out.println("잘못입력했습니다. 다시 입력 해주세요");
			}// switch문
		} // while문
	}

	/**
	 * 데이터 불러오기
	 */
	@SuppressWarnings("unchecked")
	private void load() {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("d:/D_Other/hotelManage.bin")));
			Object obj = null;
			try {
				if ((obj = ois.readObject()) != null) {
					// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
					hotelMap = (Map<String, Room>) obj;
					System.out.println("\t           🖥데이터 로드완료..📡");
				}
				ois.close();
			} catch (ClassNotFoundException e) {

			}
		} catch (IOException e) {

		}
	}

	/**
	 * 데이터 저장
	 */
	private void save() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotelManage.bin")));
			oos.writeObject(hotelMap);
			System.out.println("*******************************************");
			System.out.println("\t+(☞ﾟヮﾟ)☞ 💾저장완료💾 ヾ(≧▽≦*)o");
			System.out.println("*******************************************");
			oos.close();
		} catch (Exception e) {
			System.out.println("┗( T﹏T )┛ 저장실패... (っ °Д °;)っ ");
		}
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
	 * 객실 전체 정보를 불러오는 메서드
	 */
	private void roomStatus() {
		Set<String> keySet = hotelMap.keySet();
		System.out.println("=================================================");
		System.out.println("번호\t이름\t방번호");
		System.out.println("=================================================");

		if (keySet.size() == 0) {
			System.out.println("등록된 방정보가 없습니다");
		} else {
			Iterator<String> it = keySet.iterator();
			int cnt = 0;
			while (it.hasNext()) {
				cnt++;
				String name = it.next();
				Room r = hotelMap.get(name);
				System.out.println(" " + cnt + "\t" + r.getName() + "\t" + r.getRoomNum());
			}
		}
		System.out.println("=================================================");
		System.out.println("출력완료!");
	}

	/**
	 * 체크인하는 메서드
	 */
	private void checkIn() {

		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 >>");
		String roomNum = sc.next();
		// 이미 등록된 사람인지 검사
		// get()메서드로 값을 가져올 때 가져올 자료가 없으면 null을 반환란다.
		if (hotelMap.get(roomNum) != null) {
			System.out.println(roomNum + "호에는 이미 사람이 있습니다.");
			return;
		}

		System.out.print("이름입력 >>");
		String name = sc.next();

		hotelMap.put(roomNum, new Room(roomNum, name));
	}

	/**
	 * 체크아웃하는 메서드 정보 삭제
	 */
	private void checkOut() {

		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 >> ");
		String roomNum = sc.next();

		// remove(key) => 삭제 성공하면 삭제된 value값을 반환하고, 실패하면 null 반환한다.
		if (hotelMap.remove(roomNum) == null) {
			System.out.println(roomNum + "호에는 체크인한 사람이 없습니다");
		} else {
			System.out.println(roomNum + "호 체크아웃 되었습니다");
		}
	}
}

/**
 * 호텔 정보를 저장히기 위한 VO 클래스
 * 
 * @author 윤한빈
 * @since 2020.09.16
 */
@SuppressWarnings("serial")
class Room implements Serializable {
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