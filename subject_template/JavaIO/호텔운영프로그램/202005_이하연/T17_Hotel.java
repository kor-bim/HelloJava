package kr.or.ddit.basic;

/*
  	호텔 운영을 관리하는 프로그램 작성.(Map이용)
 	- 키값은 방번호 
	(단, 종료시 파일로 저장하고 프로그램 실행시 파일로부터 데이터를 불러올 수 있도록 처리한다.)
	실행 예시)

**************************
호텔 문을 열었습니다.
**************************

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 101 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 홍길동 <-- 입력
체크인 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 성춘향 <-- 입력
체크인 되었습니다

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향
방번호 : 101, 투숙객 : 홍길동

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
체크아웃 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 허준 <-- 입력
102방에는 이미 사람이 있습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
101방에는 체크인한 사람이 없습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 4 <-- 입력

**************************
호텔 문을 닫았습니다.
**************************
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class T17_Hotel {

	static Scanner sc = new Scanner(System.in);
	static Map<Integer, String> hotel = new HashMap<>();

	public static void main(String[] args) {
		
		try {
			// 저장한 객체를 읽어와 출력하기
			// 입력용 스트림 객체 생성
			
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.txt")));
			Object obj = null;
			
			try {
				while ((obj = ois.readObject()) != null) {
					// 읽어온 데이터를 원래의 객체형으로 변환 후 사용한다.
					hotel = (Map<Integer, String>) obj; 
				}
				// 인풋 스트림객체 닫기
				ois.close();
			} catch (ClassNotFoundException e) {
			} catch (IOException e) {
			}
			// 호텔프로그램 객체 생성 및 시작메서드 호출
			T17_Hotel ht = new T17_Hotel();
			ht.hotelStart();
			
			// 객체를 파일에 저장하기
			// 출력용 OutputStream 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.txt")));
			
			// 쓰기 작업
			oos.writeObject(hotel); // 직렬화
			
			System.out.println("쓰기 작업 완료...");
			
			// 아웃풋 스트림객체 닫기
			oos.close();
			
		} catch (IOException e) {
			
			// 더이상 읽어올 객체가 없으면 예외 발생함.
			System.out.println("출력 작업 끝...");
		}
	}

	/**
	 * 시작 메서드
	 */
	public static void hotelStart() {
		System.out.println("=============================");
		System.out.println("\t호텔문을 열었습니다.");
		System.out.println("=============================");

		while (true) {
			System.out.println("=====================================");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("=====================================");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				checkRoom();
				break;
			case 4:
				System.out.println();
				System.out.println("=============================");
				System.out.println("\t호텔문을 닫았습니다.");
				System.out.println("=============================");
				return;
			default :
				break;
			}
		}
	}

	/**
	 * 체크인 메서드
	 */
	private static void checkIn() {
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int roomNumber = sc.nextInt();

		if (hotel.get(roomNumber) != null) {
			System.out.println(roomNumber + " 방에는 이미 사람이 있습니다.");
			return;
		}

		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 => ");
		String name = sc.next();

		hotel.put(roomNumber, name); // 자료 추가 => put(key값, value값)
		System.out.println(name + "님 체크인 되었습니다.");
	}

	/**
	 * 체크아웃 메서드
	 */
	private static void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int roomNumber = sc.nextInt();

		if (hotel.remove(roomNumber) == null) { // 자료 삭제 => remove(삭제할 key값)
			System.out.println(roomNumber + " 방에는 체크인한 사람이 없습니다.");
		} else {
			System.out.println("체크아웃 되었습니다.");
		}
	}

	/**
	 * 객실상태 메서드
	 */
	private static void checkRoom() { // Set형의 데이터를 '향상된 for문' 으로 처리하면 Iterator를 사용하지 않아도 된다.
		Set<Integer> keySet = hotel.keySet();
		
		System.out.println("================================");
		System.out.println("방번호\t투숙객");
		System.out.println("================================");
		
		for (Integer key : keySet) {
			System.out.println("방 번호 : " + key + ", 투숙객 : " + hotel.get(key));
		}
		
		System.out.println("================================");
		System.out.println("모든 방을 출력했습니다.");
	}
}

/**
 * 방  VO
 * 파일로 읽고 쓰기 위해서 Serializable 인터페이스 구현
 */
class Room implements Serializable{
// 자바는 Serializable인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있음.
// 구현 안하면 직렬화 작업시 java.io.NotSerializableException예외 발생!

	private int roomNumber;
	private String name;

	public Room(int roomNumber, String name) {
		super();
		this.roomNumber = roomNumber;
		this.name = name;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
