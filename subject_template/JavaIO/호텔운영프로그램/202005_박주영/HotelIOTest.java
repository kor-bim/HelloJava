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
/*
 문제)

호텔 운영을 관리하는 프로그램 작성.(Map이용)
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
 */

public class HotelIOTest{
	Scanner sc = new Scanner(System.in);
	private Map<String, Hotel> hotelMap;

	public HotelIOTest() {
		hotelMap = new HashMap<String, Hotel>();

	}

	/**
	 * 메뉴 선택 메서드
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
	 * 예약 뷰
	 */
	public void HotelStart() {
		HotelInput(); // 시작할때 마다 저장돼있는 호텔 정보를 가져온다.

		System.out.println("******************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("******************************");

		while(true) {
			int input = 0;
			HotelMenu();
			try {

				input = sc.nextInt();
			}catch(Exception e){
				System.out.println("숫자만 입력해주세요 ");
			}
			switch (input) {
			case 1:
				CheckIn();  // 체크인
				break;
			case 2:
				CheckOut(); // 체크아웃
				break;   
			case 3:
				Status();  // 객실상태
				break;
			case 4:
				close(); //호텔 문을 닫는다.
				return;

			default:
				System.out.println("잘못 입력했습니다 다시 입력해 주세요");
			}
		}
	}

	public void close() {
		HotelOutput();  // 종료할 때 호텔 정보를 저장한다.
		System.out.println();
		System.out.println("******************************");
		System.out.println("호텔 문을 닫았습니다.");
		System.out.println("******************************");
		
		
	}
	/**
	 * 체크인 하는 메서드
	 */
	public void CheckIn() {
		System.out.println( );
		System.out.println("체크인 하실 방번호를 입력해주세요");
		System.out.print("방번호 입력 => ");

		String room = sc.next();

		if(hotelMap.get(room) != null) {  //방이 비었는지 확인
			System.out.println(room + "번 방은 이미 등록된 방입니다.");
			return;   
		}

		System.out.println("누구를 체크인 하시겠습니까? ");
		System.out.print("이름 입력 => ");

		String name = sc.next();
		if(hotelMap.get(name) != null) {
			return;
		}
		System.out.println("체크인 되었습니다.");

		hotelMap.put(room, new Hotel(room, name));
		System.out.println(room + "번 방에 체크인 했습니다.");
	}

	/**
	 * 체크아웃 하는 메서드
	 */
	public void CheckOut() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String room = sc.next();

		if(hotelMap.remove(room) == null) {  //방의 정보를 지운다. 지울 정보가 없으면 빈방
			System.out.println(room + "방에는 체크인한 사람이 없습니다.");
		}else {
			System.out.println(room + "체크아웃 되었습니다.");
		}
	}

	/**
	 * 객실의 상태를 확인하는 메서드
	 */
	public void Status() {
		Set<String> keySet = hotelMap.keySet();

		if(keySet.size() == 0) {  //key값으로 이루어진 Set객체를 가져온다.
			System.out.println("체크인된 객실이 없습니다.");
		}else {
			Iterator<String> it = keySet.iterator();  //key값으로 이루어진 객체를 이용 데이터를 가져온다.
			while(it.hasNext()) {	
				String room = it.next();   
				Hotel hr = hotelMap.get(room);
				System.out.println("방번호 : " + hr.getName() + ", 투숙객 : " + hr.getRoom());
			}
		}
	}

	/**
	 * 출력을 위한 메인 메서드
	 */
	public static void main(String[] args) {
		HotelIOTest ht = new HotelIOTest();
		ht.HotelStart();
	}

	/**
	 * 호텔정보를 문서를 읽어오는 메서드
	 */
	public void HotelInput() {

		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("d:/D_Other/Hotelinfo.txt")));

			Object obj = null;

			while ((obj = ois.readObject()) != null) {
				// 읽어온 데이터를 원래 객체형으로 변환
				hotelMap = (Map<String, Hotel>)obj;  // 캐스팅
			}
			ois.close();
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("읽어오기 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 저장된 호텔정보를 파일에 저장하는 메서드
	 */
	public void HotelOutput() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream("d:/D_Other/Hotelinfo.txt")));

			// 입력받은 객체 쓰기
			oos.writeObject(hotelMap);  // 직렬화

			// 다 쓰고 닫기
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
/**
 * 방번호와 고객을 저장하는 클래스
 */

class Hotel implements Serializable{
	private String name;
	private String room;
	
	public Hotel(String name, String room) {
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
