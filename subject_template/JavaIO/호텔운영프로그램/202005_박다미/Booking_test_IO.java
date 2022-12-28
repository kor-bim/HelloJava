package T_test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.plaf.synth.SynthSpinnerUI;


/**
 * 객체 입출력 보조 스트림 예제
 */

public class Booking_test_IO {

	private Scanner sc = new Scanner(System.in);
	static Map<String, Room2> roomList = new HashMap<>();
	
	
	
	public void BookingMain() {
			load();	// 프로그램 시작했을때 menu()메서드를 실행전에 이전의 정보들을 불러와서 Map에 저장
			menu();	// 프로그램 메뉴메서드 실행
	}
	
	/**
	 * 호텔프로그램 메뉴
	 */
	private void menu() {
	while (true) {
			
			int input = 0;
			System.out.println("***************************");
			System.out.println("\t[호텔OPEN]");
			System.out.println("****************************");
			System.out.println("어떤 업무를 보시겠습니까?");
			System.out.println("======================================");
			System.out.println("1. 체크인  2. 체크아웃  3. 객실상태  4. 업무종료");
			System.out.println("======================================");
			try { // 입력하는값이 숫자인지 아닌지 판단함
				System.out.print("번호를 선택하시오 : ");

				input = sc.nextInt();
			} catch (InputMismatchException e) {
				// e.printStackTrace();
				System.out.println("숫자만 입력해주세요!");
				sc = new Scanner(System.in);
			}

			switch (input) {
			case 1:
				checkIn(); // 체크인
				break;
			case 2:
				 checkOut(); // 체크아웃
				break;
			case 3:
				 bookingState(); // 객실상태
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				 close(); // 업무종료 - 파일로 저장
				return;
			default:
				break;
			}
		}
		
	}

	/**
	 * 저장된 이전의 파일을 불러오는 메서드
	 */
	private void load() {
		
		// 저장한 객체를 읽어와 출력하기

				// 입력용 스트림 객체 생성
				ObjectInputStream ois;
				
				try {
					ois = new ObjectInputStream(	
							new BufferedInputStream(	// 버퍼를 제공해주는 보조 스트림
									new FileInputStream("d:/D_Other/room.txt")));	// 파일 정보를 File객체를 이용하여 지정하기
					Object obj = null;	// Object 객체 생성
					while ((obj = ois.readObject()) != null) {
					roomList = (Map<String, Room2>) obj;
					}
					ois.close();	// 객체 반납
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();

					// 더이상 읽어올 객체가 없으면 예외 발생함.
					System.out.println("출력 작업 끝");
				}

		
	}
	
	
	/**
	 * 업무종료하는 메서드, 파일로 저장
	 */
	private void close() {
		
		try {
			// 객체를 파일에 저장하는 스트림 객체를 생성하고, buffer와 object의 보조스트림 생성
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/room.txt")));
			
			// 쓰기 작업
			oos.writeObject(roomList); // 호텔정보를 파일에 저장

			System.out.println("쓰기 작업 완료");
			
			oos.close();	// 객체 반납
			
		}
		catch (IOException e) {
			e.printStackTrace();
			
		}
		
	} 


	/**
	 * 체크아웃하는 메서드
	 */
	private void checkOut() {
		System.out.println();
		System.out.println("체크아웃할 방번호를 입력해주세요");
		String roomNum = sc.next();
		Room2 r = roomList.get(roomNum);
		
		if(r == null) {	
			System.out.println("[체크아웃할 방이 없습니다.]");
		}else{
			roomList.remove(roomNum);		
			System.out.println("체크아웃 되었습니다.");
		}
	}


	/**
	 * 객실상태를 조회하는 메서드
	 */
	private void bookingState() {
		Set<String> bookSet = roomList.keySet();
		if(roomList.size() ==0) {
			System.out.println("[조회할 수 있는 방이 없습니다.]");
		}else {
			Iterator<String> it = bookSet.iterator();
			int cnt=0;
			while(it.hasNext()) {	// 이동할 항목이 있을때까지 while문을 돈다.
				cnt++;
				String roomNum=it.next();		// 순차적으로 증가해서 이동
				Room2 r = roomList.get(roomNum);
				System.out.println("방번호 : "+r.getRoomNum());
				System.out.println("이름 : " +r.getName());
				System.out.println("--------------------------");
			}
		}
			
	}
	
	
/**
 * 방번호, 이름 입력해서 체크인하는 메서드
 * 이미 등록된 방번호는 체크인이 불가능함.
 */

	private void checkIn() {

		System.out.println();
		System.out.println(" 어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 : ");
		String roomNum = sc.next();
		String name;
		if (roomList.get(roomNum) == null) { // 이미 체크인된 방인지 검사
			System.out.print("체크인할 이름을 입력하시오 : ");
			name = sc.next();
		} else {
			System.out.println("[이미 체크인된 방입니다.]");
			return;
		}
		roomList.put(roomNum,new Room2(roomNum, name));
		System.out.println();
		System.out.println(name+ "님 체크인 완료!");
		
		
}

	public static void main(String[] args) {
		Booking_test_IO bt = new Booking_test_IO();
		
		
		
		bt.BookingMain();
		
	}
}



	/**
	 * 회원정보 VO
	 */
	class Room2 implements Serializable {
		// 자바는 Serializaber인터페이스를 구현한 클래스만 직렬화 할 수 있도록 제한하고 있음.
		// 구현안하면 직렬화 작업시 java.io.NotSerializableException예외 발생!

		// transient => 직렬화가 되지 않을 멤버변수에 지정한다.
		// (* static 필드도 직렬화가 되지 않는다.)
		// 직렬화가 되지 않는 멤버변수는 기본값으로 저장된다.
		// (참조형 변수 : null, 숫자형 변수 :0 )

		private String roomNum; // 방번호
		private String name; // 투숙객 이름

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

		public Room2(String roomNum, String name) {
			super();
			this.roomNum = roomNum;
			this.name = name;
		}

	}

	

	
	
	
	
	
	
	
	
	
	
	
	