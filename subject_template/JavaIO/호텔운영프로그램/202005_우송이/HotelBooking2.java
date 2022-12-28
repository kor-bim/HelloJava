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
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 호텔 운영을 관리하는 프로그램 작성(Map이용)
 * 
 * @author 우송이
 * @since 2020-08-12
 */

public class HotelBooking2 {

	private Map<String, Hotel> reservation = new HashMap<>();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HotelBooking2 hb = new HotelBooking2();
		hb.hotelstart();

	}

	/**
	 * 객체를 스트림 형식으로 파일에 저장하기 위한 메서드
	 */
	public void save() {
		// 객체를 파일에 저장하기
		try {
			// 출력용 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.bin")));

			oos.writeObject(reservation);
			System.out.println("쓰기작업완료...");

			oos.close(); //작업 완료 후 ObjectOutputStream 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 스트림형식으로 저장한 객체를 읽어오기 위한 메서드
	 */
	public void load() {

		// 저장한 객체를 읽어오기
		try {
			// 입력용 스트림 객체 생성
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.bin")));
			Object obj = null;
			try {
				while ((obj = ois.readObject()) != null) {

					// 읽어온 데이터를 원래의 객체형으로 변환후 사용한다.
					Map<String, Hotel> h = (Map<String, Hotel>) obj;
					reservation = h;
				}

				System.out.println("출력작업끝...");
				ois.close(); //작업완료 후 ObjectInputStream 닫기

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			//더이상 읽어올 객체가 없으면 예외가 발생한다.
		}
	}

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void menu() {
		System.out.println();
		System.out.println("==============HOTEL==============");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("=================================");
		System.out.print("메뉴를 선택해 주세요 =>");
	}

	/**
	 * 프로그램 시작을 위한 메서드
	 */
	public void hotelstart() {

		load();
		System.out.println("**************HOTEL**************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("*********************************");

		int input = 0;

		while (true) {
			menu();
			input = sc.nextInt();
			switch (input) {
			case 1:
				checkIn(); // 체크인
				break;
			case 2:
				checkOut(); // 체크아웃
				break;
			case 3:
				checkRoom(); // 객실상태
				break;
			case 4:
				save();
				System.out.println("업무를 종료합니다. 이용해주셔서 감사합니다.");
				return;
			default:
				System.out.println("다시입력해주세요.");
			}
		}

	}

	/**
	 * 객실상태를 조회하기 위한 메서드
	 */
	private void checkRoom() {

		// 자료읽기 => keySet()메서드를 이용하여 key값들을 읽어와 자료를 출력한다.
		// reservation Map의 key값들만 읽어와 Set형으로 반환한다.
		Set<String> roomSet = reservation.keySet();

		System.out.println("----------------------------------");
		System.out.println("현재 객실 체크인 상태입니다.");
		System.out.println("----------------------------------");
		System.out.println("방번호\t투숙객");
		System.out.println("----------------------------------");

		if (roomSet.size() == 0) {
			System.out.println("현재 예약된 객실이 없습니다.");
		} else {
			Iterator<String> it = roomSet.iterator();
			while (it.hasNext()) {
				String bangNum = it.next(); // key값 가져오기
				Hotel ht = reservation.get(bangNum);
				System.out.println(ht.getBangNum() + "\t" + ht.getName());
				System.out.println("----------------------------------");

			}
		}
	}

	/**
	 * 체크아웃을 위한 메서드
	 */
	private void checkOut() {

		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방 번호 입력 => ");
		String bangNum = sc.next();

		// remove(key) => 삭제 성공하면 삭제된 value값을 반환하고, 실패하면 null을 반환한다.
		if (reservation.remove(bangNum) == null) {
			System.out.println("현재 사용중인 객실이 아닙니다.");
		} else {
			System.out.println(bangNum + "번 객실이 체크아웃 되었습니다.");
		}

	}

	/**
	 * 체크인을 위한 메서드
	 */
	private void checkIn() {

		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String bangNum = sc.next();

		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = sc.next();

		if (reservation.get(bangNum) != null) {
			System.out.println(bangNum + "번 객실에는 이미 사람이 있습니다.");
			checkIn();
		} else {

			// Map에 체크인 정보 자료 추가 =>키 값은 방번호
			reservation.put(bangNum, new Hotel(bangNum, name));

			System.out.println(bangNum + "번 객실에 체크인 되었습니다.");
		}
	}
}


/**
 * 호텔 VO
 * @author PC-24
 *
 */
class Hotel implements Serializable { // 직렬화 하기 위해 Serializable 인터페이스 구현

	private String bangNum; // 방번호
	private String name; // 고객명

	public String getBangNum() {
		return bangNum;
	}

	public void setBangNum(String bangNum) {
		this.bangNum = bangNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hotel(String bangNum, String name) {
		super();
		this.bangNum = bangNum;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [bangNum=" + bangNum + ", name=" + name + "]";
	}

}
