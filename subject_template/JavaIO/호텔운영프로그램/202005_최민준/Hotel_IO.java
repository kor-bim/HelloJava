package exam;

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
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**

문제) 

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

 * @author PC-05
 *
 */
public class Hotel_IO {
	private Scanner scan;
	private Map<String, HotelRoom2> hotel;

	public Hotel_IO() {
		scan=new Scanner(System.in);
		hotel=new HashMap<>();
	}

	public static void main(String[] args) {
		Hotel_IO h=new Hotel_IO();
		h.start();
	}
	
	private void start() {
		System.out.println("┌─────────────────┐");
		System.out.println("│　호텔 문을 열었습니다.│");
		System.out.println("└─────────────────┘");
		
		while(true) {
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("┌─────────────────────────────────┐");
			System.out.println("│1.체크인  2.체크아웃 3.객실상태 4.업무종료 │");
			System.out.println("└─────────────────────────────────┘");
			System.out.println("메뉴선택 => ");
			int select=0;
			try {
				select=scan.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("💢숫자만 입력해주세요!");
				scan.nextLine();
				continue;
			}
			switch(select) {
			case 1: checkIn();
			break;
			case 2: checkOut();
			break;
			case 3: roomStatus();
			break;
			case 4:
				System.out.println("호텔문을 닫았습니다.");
				return;
			default:
				System.out.println("보기 항목에 있는것만 입력해주세요");
			}
		}
	}
	private void checkIn() {
		while(true) {
			ObjectInputStream ois;
			try {
				FileInputStream fis = new FileInputStream("d:/D_Other/hotel.bin"); // 읽어올 파일 지정 => 나중에 파일로 쓰여질 hotel.bin 
				ois = new ObjectInputStream(new BufferedInputStream(fis));
				Object obj = null; // 파일을 읽어 저장할 변수 obj 선언
				while((obj = ois.readObject()) != null) { // 다음 읽어올 값이 없을때까지 반복, 
					hotel = (Map<String, HotelRoom2>) obj;
				}
			} catch (ClassNotFoundException | IOException e1) {}

			System.out.println("어느방에 체크인 하시겠습니까?");
			System.out.println("방번호 입력 => 101 <-- 입력");
			String room=scan.next();
			if(hotel.get(room)!=null) {
				System.out.println(room+"방은 이미 체크인이 되어 있습니다."); break;
			}
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.println("이름 입력 => 홍길동 <-- 입력");
			String name=scan.next();
			hotel.put(room, new HotelRoom2(room, name));
			System.out.println("체크인 되었습니다.");
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.bin")));
				oos.writeObject(hotel);
				System.out.println("정보 저장 완료");
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
	}

	private void checkOut() {
		System.out.println("체크아웃 할 방번호를 선택해주세요");
		String room=scan.next();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.bin")));
			Object obj = null; // 파일을 읽어 저장할 변수 obj 선언
			while((obj = ois.readObject()) != null) { // 다음 읽어올 값이 없을때까지 반복, 
				hotel = (Map<String, HotelRoom2>) obj;
				if(hotel.remove(room)==null) {
					System.out.println(room+"방은 이미 체크아웃을 했거나 체크인 한 정보가 없습니다.");
				}else {
					System.out.println(room+"방이 체크아웃 되었습니다.");
				}
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.bin")));
				oos.writeObject(hotel);
				System.out.println("정보 저장 완료");

				oos.close();
			}
		} catch (ClassNotFoundException | IOException e1) {}

	}
	
	private void roomStatus() {
		System.out.println("방 번호를 입력해주세요.");
		String room=scan.next();
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.bin")));
			Object obj = null; // 파일을 읽어 저장할 변수 obj 선언
			while((obj = ois.readObject()) != null) { // 다음 읽어올 값이 없을때까지 반복, 
				hotel = (Map<String, HotelRoom2>) obj;
			}
		} catch (ClassNotFoundException | IOException e1) {} 
		
		if(hotel.get(room)==null) {
			System.out.println(room+"방에는 현재 투숙중인 고객이 없습니다.");
		}else {
			System.out.println("[방 번호 : "+hotel.get(room).getRoomNum()+"] [투숙객 : "+hotel.get(room).getName()+"]");
		}
	}
}

class HotelRoom2 implements Serializable{
	private String roomNum;
	private String name;
	public HotelRoom2(String roomNum, String name) {
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
