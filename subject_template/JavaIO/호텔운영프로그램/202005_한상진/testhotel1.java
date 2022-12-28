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
import java.util.regex.Pattern;

/*
	문제)

호텔 운영을 관리하는 프로그램 작성.(DB 이용)
 - 키값은 방번호 
 
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


// 호텔운영 프로그램 테이블 생성 스크립트 
create table hotel_mng (
    room_num number not null,  -- 방번호
    guest_name varchar2(10) not null -- 투숙객 이름
);
 */
public class testhotel1 {
	static Scanner sc;
	static Map<String, Hotel> hotelMap = new HashMap<String, Hotel>();
	static Set<String> keySet = null;
	
	
	
	/**
	 * 정보를 불러오는 메서드
	 */
	public void read() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/Hotel_test4.txt")));
			hotelMap = (Map<String, Hotel>) ois.readObject();
			keySet = hotelMap.keySet();
		}catch(IOException e) {
			System.out.println("출력 작업 끝...");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 정보를 입력하는 메서드
	 */
	public void input() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/Hotel_test4.txt")));
			oos.writeObject(hotelMap);	
			System.out.println("쓰기 작업 완료...");
			oos.close();
		}catch(IOException e) {
			System.out.println("출력 작업 끝...");
		}catch(ClassCastException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 메뉴 view 메서드
	 */
	public void HotelMenu() {
		System.out.println();
		System.out.println();
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.print("1.체크인\t");
		System.out.print("2.체크아웃\t");
		System.out.print("3.객실상태\t");
		System.out.println("4.업무종료\t");
		System.out.println("*******************************************");
		System.out.print("메뉴선택 => ");		
	}
	
	
	/**
	 * 메뉴 선택 메서드
	 */
	public void HotelStart() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		
		while(true) {
			int num = 0;
			HotelMenu();
			
			try {
			sc = new Scanner(System.in);
			num = sc.nextInt();
			}catch(java.util.InputMismatchException mis){
				System.out.println("숫자만 입력해주세요");
			}
			
			switch (num) {
			case 1:
				//체크인
				CheckIn();
				break;
			case 2:
				//체크아웃
				CheckOut();
				break;	
			case 3:
				//객실상태
				Status();
				break;
			case 4:
				//업무종료
				System.out.println();
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;

			default:
				System.out.println("잘못 입력했습니다 다시 입력해 주세요");
			}
		}
	}
	
	
	/**
	 * 체크인 하는 메서드
	 */
	public void CheckIn() {
		System.out.println( );
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.println("1-3층 - 1~23호까지     ex) 109, 123 ");
		System.out.print("방번호 입력 => ");
		String room = sc.next();
		
		if(roomRegEx(room) == false) {
			return;
		}
		if(hotelMap.get(room) != null) {
			System.out.println(room + "번 방은 이미 등록된 방입니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		sc.nextLine();
		String name = sc.nextLine();
		if(nameRegEx(name) == false) {
			return;
		}
		System.out.println("체크인 되었습니다.");
		
		hotelMap.put(room, new Hotel(room, name));
		System.out.println(room + "번 방에 체크인 했습니다.");
		input();
		
	}
	 
	
	/**
	 * 체크아웃 하는 메서드
	 */
	public void CheckOut() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String room = sc.next();
		
		if(roomRegEx(room) == false) {
			return;
		}
		if(hotelMap.remove(room) == null) {
			System.out.println(room + "방에는 체크인한 사람이 없습니다.");
		}else {
			System.out.println(room + "체크아웃 되었습니다.");
		}
	}
	
	 
	/**
	 * 객실 상태를 확인하는 메서드
	 */
	public void Status() {
		
		read();
		if(hotelMap.keySet().size() == 0) {
			System.out.println("체크인된 객실이 없습니다.");
		}else {
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()) {
				String room = it.next();	// 키값 : 이름
				System.out.println("방번호 : " + hotelMap.get(room).getRoom() + ", 투숙객 : " + hotelMap.get(room).getName());
			}
		}
	}
	
	
	/**
	 * 메인 실행 
	 */
	public static void main(String[] args) {
		testhotel1 ht = new testhotel1();
		ht.HotelStart();
	}
	
	
	/**
	 * 방번호 정규식
	 */
	public boolean roomRegEx(String room) {
		String regEx = "[1-3]{1}(0[1-9]|1[0-3]|2[0-3])";
		boolean roomNum = false;
		
		if(Pattern.matches(regEx, room) == false) {
			roomNum = false;
			System.out.println("방 번호 형식이 틀렸습니다.  다시 입력해 주세요.  ex)101  1~3층, 1~23호 까지");
			// 0- 1-9
			// 1- 0-3
			// 2- 0-3
		}else {
			roomNum = true;
		}
		return roomNum;
	}
	 
	
	/**
	 * 이름 정규식
	 */
	public boolean nameRegEx(String name) {
		String regEx = "([가-힣]{2,5})";
		boolean CheckName = false;
		
		if(Pattern.matches(regEx, name) == false) {
			CheckName = false;
			System.out.println("이름 형식이 틀렸습니다.  다시 입력해 주세요.(2~5글자)  ex)한상진, 김나박이");
		}else {
			CheckName = true;
		}
		return CheckName;
	}
	
}
 

/**
 * @author Hotel VO
 * @param name	// 고객이름
 * @param room	// 방번호
 */
class Hotel implements Serializable {
	
	private String name;		// 고객이름
	private String room;		// 방번호
	
	
	public Hotel(String name, String room) {
		super();
		this.name = name;
		this.room = room;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", room=" + room + "]";
	}
}
