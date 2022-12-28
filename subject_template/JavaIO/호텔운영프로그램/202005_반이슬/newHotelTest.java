package javaCollectionFramework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class newHotelTest {
	private Scanner scan;
	private HashMap<String, String> hotel;

	public newHotelTest() {
		scan = new Scanner(System.in);
		hotel = new HashMap<>();
	}

	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		System.out.println();
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 \t 2.체크아웃 \t 3.객실상태 \t 4.업무종료");
		System.out.print("메뉴선택 ==>");
	}

	// 프로그램을 시작하는 메서드
	public void hotelStart() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("========================호텔 문을 열었습니다.========================");

		while (true) {

			displayMenu(); // 메뉴보여주기

			int menuNum = scan.nextInt(); // 메뉴 번호 입력받기

			switch (menuNum) {
			case 1:
				chek_in(); // 체크인
				break;
			case 2:
				chek_out(); // 체크아웃
				break;
			case 3:
				guestAll(); // 객실상태(손님의 수, 방번호, 투숙객이름)
				break;
			case 4:
				System.out.println("호텔문을 닫았습니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch끝나는 부분
		} // while끝나는 부분
	}

	
	//객실상태확인하는 메서드
	private void guestAll() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("d:/D_Other/hotelObj.bin")));//입력용스트림 객체생성

		Object obj = null;
		try {
			while ((obj = ois.readObject()) != null) {
				hotel = (HashMap)obj;//읽어온값을 hotel에 대입(다운캐스팅)
				Iterator<String> mapIterator = hotel.keySet().iterator();
				while (mapIterator.hasNext()) {
					String key = mapIterator.next();
					String value = hotel.get(key);
					System.out.println("방번호 : " + key + "   " + "투숙객이름 : " + value);
				}

				System.out.println("===========================");
			}
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			
			
		}

	}
	
	//체크아웃하는 메서드
	private void chek_out() {
		System.out.println("체크아웃할 방번호를 입력하세요");
		String roomNo = scan.next();
		if(hotel.remove(roomNo) == null) {
			System.out.println(roomNo+"번방은 체크인된방이 아닙니다.");
			
		}else {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotelObj.bin")));//출력용 스트림객체생성
				
				// 체크아웃된 정보를 갖고있는 hotel을 다시 입력
				oos.writeObject(hotel);
				
				System.out.println(roomNo+"번방이 체크아웃 되었습니다.");
				oos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 체크인하는 메서드
	private void chek_in() {
		System.out.println("체크인할 방번호를 입력하세요");
		String roomNo = scan.next();
		Iterator<String> mapIterator = hotel.keySet().iterator();//중복체크를 위해 저장되어있는 hotel맵확인	
		while (mapIterator.hasNext()) {
			String key = mapIterator.next();
			if (key.equals(roomNo)) {
				System.out.println("이미 체크인된 방입니다.");
				return;
			}
		}
		System.out.println("체크인할 사람이름을 입력하세요");
		String gestname = scan.next();
		hotel.put(roomNo, gestname);//입력받은 값을 맵에저장

		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotelObj.bin")));//출력용 스트림객체생성

			// 입력받은값을 저장한 맵을 쓰기
			oos.writeObject(hotel);

			System.out.println("체크인 완료");
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		newHotelTest ho = new newHotelTest();
		ho.hotelStart();
	}
}

/**
 * 방정보를 저장할 수있는 VO클래스
 * 
 * @author PC-09
 */
class roomroom implements Serializable { //직렬화
	private String room; // 방번호
	private String guest; // 투숙객

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public roomroom(String room, String guest) {
		super();
		this.room = room;
		this.guest = guest;
	}

	@Override
	public String toString() {
		return "room [room=" + room + ", guest=" + guest + "]";
	}

}