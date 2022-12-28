package kr.or.ddit.basic;

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
import java.util.Map;
import java.util.Scanner;

/*문제)

호텔 운영을 관리하는 프로그램 작성.(Map 이용)
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
 *******************************         

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

																																		);
 */

/**
 * 호텔 운영을 관리하는 프로그램 작성.(Map 이용)
 * - 키값은 방번호 
 * @author 최윤지
 *
 */

public class HW02_HotelManager implements Serializable {
	 Scanner sc = new Scanner(System.in);	//scanner를 전역변수로 사용하기위해 static 선언
	 Map<Integer, String> GuestMap = new HashMap<>();	//key와 value를 방번호와 투숙객이름으로 설정
	 static Integer roomNum;	//맵의 key로 사용될 변수 Integer roomNum
	 String guestName;	//맵의 value로 사용될 변수 String guestName

	 FileOutputStream fos = null;	//class전체에서 사용하기 위한 static 객체 파일출력스트림
	 FileInputStream fis = null;	//class전체에서 사용하기 위한 static 객체 파일입력스트림


	public static void main(String[] args) {
		//타 메소드들이 private이기 때문에 hotel 객체 선언
		HW02_HotelManager hotel = new HW02_HotelManager();

		System.out.println("**************************");
		System.out.println("      호텔 문을 열었습니다.      ");
		System.out.println("**************************");

		hotel.robby();	//호텔 로비 진입
	}

	private void robby() {
		while(true){
			System.out.println("");
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴선택 => ");

			int choice = sc.nextInt();	//실행할 업무(int)를 입력받아 변수 choice에 저장

			switch(choice){	//choice값과 일치하는 메소드 실행
			case 1:
				checkIn();		//해당 메소드 실행
				break;	//이후의 case가 실행되지 않기 위해 break 넣어줌
			case 2:
				checkOut();
				break;
			case 3:
				roomCondition();
				break;
			default :	//choice값과 1 2 3 중 일치하는 값이 없을 때 default(= 4.업무종료)실행
				System.out.println("");
				System.out.println("**************************");
				System.out.println("      호텔 문을 닫았습니다.      ");
				System.out.println("**************************");
				return;
			}
		}
	}

	/**
	 * 체크인 )
	 * 맵에 입력 -> 맵을 파일로 저장
	 */
	private void checkIn() {
		System.out.println("");
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print("방 번호 입력 => ");
		roomNum = sc.nextInt();	//사용자에게 입력받은 정수를 static변수 roomNum에 저장

		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		guestName = sc.next();	//사용자에게 입력받은 String을 static변수 guestName에 저장


		if(GuestMap.containsKey(roomNum)){	//GuestMap 맵 내에 사용자에게 입력받은 roomNum과 같은 값의 key가 있으면 
			System.out.println(roomNum+"호에는 이미 사람이 있습니다.");	//해당 출력문만 수행
		}else{
			GuestMap.put(roomNum, guestName);	//조건문이 F이면 동일 key가 없다는 뜻이므로 GuestMap객체에 데이터 입력
			try {
				//객체를 Stream을 통해 입출력하기 위해선 직렬화과정이 필요하기 때문에 해당 클래스에 인터페이스 Serializable를 구현한다.
					/* Serializable을 구현하지 않고 직렬화작업 시 java.io.NotSerializableException 예외 발생
					 * transient -> 직렬화가 되지 않을 멤버변수에 지정한다. / static 변수도 직렬화 ㄴㄴ
					 * 직렬화가 되지 않는 변수는 기본값으로 저장됨. ex)참조형 변수: null, 숫자형 변수: 0 
					 */
				
				//ObjectOutputStream => 객체를 직렬화하여 출력 가능하도록 만들어주는 출력용 Stream객체
				//BufferedOutputStream => 덩어리로 읽어와서 전송함으로써 속도를 높이기 위한 보조 Stream
				//FileOutputStream => 개발자가 원하는 형식(File)으로 데이터를 입력해줄 입력 Stream
				ObjectOutputStream oos = new ObjectOutputStream (new BufferedOutputStream(new FileOutputStream("Hotel.txt")));
				
				oos.writeObject(GuestMap);	////oos에 GuestMap의 데이터를 저장함.(직렬화)
				System.out.println("체크인 되었습니다."); //파일에 GuesMap데이터 저장 후 출력문 출력

				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 체크아웃 )
	 * -> 파일에 있는 데이터를 맵으로 읽어옴
	 * -> 맵에서 체카웃방 데이터 삭제
	 * -> 변경된 맵을 파일에 다시 저장
	 */
	private void checkOut() {
		System.out.println("");
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방 번호 입력 => ");
		roomNum = sc.nextInt();

		Object obj = null;
		try {
			//파일에 있는 데이터를 저장한 ois선언
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Hotel.txt")));

			//Guest맵에 ois에서 읽어온 데이터를 저장해준다. 이 때 Map형식으로 캐스팅해줌
			GuestMap = (Map<Integer, String>) ois.readObject();
		
			if(GuestMap.containsKey(roomNum)){	//GuestMap객체에 사용자에게 입력받은 roomNum과 같은 값의 key가 존재하면
				GuestMap.remove(roomNum);	//Guest맵 내의 해당하는 key와 value를 삭제해주고
				System.out.println("체크아웃 되었습니다.");	//출력문 수행

				//수정된 GuestMap의 데이터를 다시 파일에 저장해야하기 때문에 oos 생성
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Hotel.txt")));
				oos.writeObject(GuestMap);	//현재 GuestMap의 정보를 다시 파일에 저장해줌
				
				ois.close();
				oos.close();
			}else{	// GuestMap에 일치하는 key값이 없을시
				System.out.println(roomNum+"방에는 체크인한 사람이 없습니다.");	//출력문 선언
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 조회
	 * -> 파일에 있는데이터를 맵으로 읽어옴
	 * -> 맵을 조회해서 출력
	 */
	private void roomCondition() {

		Object obj = null;	//Object타입의 obj 객체 선언.
		//try 밖에서 하는 이유 ->try안에 들어가면 지역변수이기 떄문에
		try {
			//ObjectInputStream => 역직렬화를 통해서 객체를 만들어주는 Stream객체
			//BufferedOutputStream => 덩어리로 전송함으로써 속도를 높이기 위한 보조 Stream
			//FileOutputStream => 개발자가 원하는 형식(File)의 데이터를 출력해줄 출력용 Stream.
			//"Hotel.txt"란 파일의 데이터를 갖고온다.
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Hotel.txt")));

			//ois에 읽어올 데이터가 null이 아닐 떄 까지 obj에 해당 데이터 입력
			while((obj=ois.readObject()) != null){
				for(Integer keys : GuestMap.keySet()){	//GuestMap데이터에 있는 key들을 keys객체에 넣는다.
					String values = GuestMap.get(keys);	//해당 key와 매핑된 value값을 변수에 저장한다.
					System.out.println("방번호 : "+keys+" 투숙객 : "+values);	//출력문
				}
			}

			ois.close();

		} catch (ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}