package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
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
import java.util.regex.Pattern;

/**
 * 호텔 운영을 관리하는 프로그램 작성.(Map이용)
 * 키값은 방번호 
 * (단, 종료시 파일로 저장하고 프로그램 실행시 파일로부터 데이터를 불러올 수 있도록 처리한다.)
 * @author 김미연
 * @since 2020.07.29
 */
public class HotelManagement {
	private Scanner sc = new Scanner(System.in); // 사용자로 부터 콘솔 입력 받기 위한 스캐너
	private RegEx rx = new RegEx(); // 정규화를 체크
	private File file = new File("d:/D_Other/HotelRoom.bin"); // 파일을 다루기 위한 객체 생성
	
	// 체크인한 고객들의 정보를 담는다.
	// 방번호로 키값을 갖고, HotelRoom타입의 value값을 갖는다.
	private Map<String, HotelRoomVO> hmap = new HashMap<String, HotelRoomVO>(); 
	
	public static void main(String[] args) {
		new HotelManagement().startMenu(); // 시작메뉴 실행
	}
	
	/**
	 * 시작메뉴를 보여주기 위한 메서드
	 */
	private void startMenu() {
		int input = 0; // 사용자의 메뉴 입력 값 저장
		
		// 시작할때 파일을 읽어서 map에 저장
		fileRead();
		
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		
		while(true) { // '업무종료' 선택전까지 무한반복
			System.out.println();
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴 선택 => ");
			try {
				input = sc.nextInt();
			}catch(InputMismatchException e) { // int값이 아닌 다른 자료형을 입력했을 때
				System.out.println("잘못입력 하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화, 무한루프 발생 방지
				continue; // 예외발생시 다시 입력 받는다.
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			
			switch(input) { // 입력값에 따라서 해당 메서드 호출
			case 1 : // 체크인을 선택했을 때
				checkIn(); // 체크인 메서드 호출
				break;
			case 2 : // 체크아웃을 선택했을 때
				checkOut(); // 체크아웃 메서드 호출
				break;
			case 3 : // 객실상태를 선택했을 때
				roomCondition(); // 객실상태 메서드 호출
				break;
			case 4 : // 업무종료를 선택했을 때
				end(); // 업무종료 메서드 호출
				break;
			default : // 위의 메뉴 입력 값외의 값을 입력했을 때
				System.out.println("잘못입력 하였습니다. 다시 입력해주세요.");
				break;
			}
		}
	}

	/**
	 * 객실에 체크인 하기 위한 메서드
	 */
	private void checkIn() {
		String roomNum = null; // 체크인할 객실 방번호
		String guests = null; // 체크인할 고객명
		
		while(true) {
			try {
				System.out.println("어느 방에 체크인 하시겠습니까? 형식 : 첫자리(1~9사이 숫자), 두번째자리(0~9), 세번째자리(0~9)");
				System.out.print("방번호 입력 => ");
				roomNum = sc.next();
				
				// 방번호 정규화 체크
				if(!rx.roomNumCheck(roomNum)) {
					System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue; // 잘못입력시 다시 입력받는다.
				}
				
				// 이미 체크인 된 방인지 확인
				if(hmap.get(roomNum) != null) { // 해당 방번호가 이미 체크인 되어 있다.
					System.out.println(roomNum + "이미 체크인된 방입니다.");
					System.out.println("다른 방을 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue;
				}
				
			}catch (NullPointerException e) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화, 무한루프 발생 방지
				continue; // 예외발생시 다시 입력 받는다.
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			break;
		}
		
		while(true) {
			try {
				System.out.println("누구를 체크인 하시겠습니까? 형식 : 한글이름 2자리 이상");
				System.out.print("이름 입력 => ");
				guests = sc.next();
				// 이름의 정규화 체크
				if(!rx.guestsCheck(guests)) {
					System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue; // 잘못입력시 다시 입력받는다.
				}
			}catch (NullPointerException e) { 
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화, 무한루프 발생 방지
				continue; // 예외발생시 다시 입력 받는다.
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			break;
		}
		
		// 키값 : 방번호, value : HotelRoom객체 
		hmap.put(roomNum, new HotelRoomVO(roomNum, guests)); 
		System.out.println("체크인 되었습니다.");
	}

	/**
	 * 객실에 체크아웃 하기 위한 메서드
	 */
	private void checkOut() {
		String roomNum = null; // 체크아웃할 객실 방번호
		
		// 체크인한 방이 있는지 체크
		// 체크인 된 방이 없다면 return
		if(hmap.isEmpty()) {
			System.out.println("체크인된 방이 없습니다.");
			return;
		}
		
		while(true) {
			try {
				System.out.println("어느 방을 체크아웃 하시겠습니까? 형식 : 첫자리(1~9사이 숫자), 두번째자리(0~9), 세번째자리(0~9)");
				System.out.print("방번호 입력 => ");
				roomNum = sc.next();
				
				// 방번호 정규화 체크
				if(!rx.roomNumCheck(roomNum)) {
					System.out.println("형식에 맞지 않습니다. 다시 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue; // 잘못입력시 다시 입력받는다.
				}
				
				// 해당방이 체크인된 방인지 확인
				if(hmap.get(roomNum) == null) { // 해당 방번호는 체크인 된 방이 아니다.
					System.out.println(roomNum + "체크인 된 방이 아닙니다.");
					System.out.println("다른 방을 입력해주세요.");
					sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
					continue;
				}
				
			}catch(NullPointerException e){
				System.out.println("잘못입력하였습니다. 다시 입력해주세요.");
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
				continue;
			}finally {
				sc = new Scanner(System.in); // 이전에 가지고 있던 Scanner값을 초기화
			}
			break;
		}
		hmap.remove(roomNum);
		System.out.println(roomNum + "방이 체크아웃 되었습니다.");
	}

	/**
	 * 객실상태를 보여주기 위한 메서드
	 */
	private void roomCondition() {
		
		// map에 담긴 값이 없다면 return
		if(hmap.isEmpty()) {
			System.out.println("체크인된 방이 없습니다.");
			return;
		}
		
		// map에 담긴 값을 가져와서 출력한다.
		for(HotelRoomVO hrv : hmap.values()) {
			System.out.println("방번호 : " + hrv.getRoomNum() 
			                           + ", 투숙객 : " + hrv.getGuests());
		}
	}

	/**
	 * 호텔관리 운영 프로그램을 종료하기 위한 메서드
	 */
	private void end() {
		// 시스템 종료전 파일에 저장
		fileWrite();
		
		System.out.println();
		System.out.println("**************************");
		System.out.println("호텔 문을 닫았습니다.");
		System.out.println("**************************");
		System.exit(0); // 시스템 종료
	}
	
	/**
	 * 파일을 읽어 map에 저장하기 위한 메서드
	 */
	private void fileRead() {
		// 해당 파일이 존재하는지 확인한다. 파일이 없다면 새로 파일을 생성한다.
		if(!file.exists()) {
			try {
				if(file.createNewFile()) {
					System.out.println("파일을 새로 만들었습니다.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 해당 파일이 있을 경우 실행
		try {
			// 입력용 스트림 객체 생성 : 속도향상을 위한 
			// 보조스트림(ObjectInputStream,BufferedInputStream) 사용
			ObjectInputStream ois = new ObjectInputStream(
					                       new BufferedInputStream(
							                       new FileInputStream(file)));
			
			Object obj = null; // 파일에서 읽은 데이터를 저장
			
			// 파일에서 오브젝트형으로 읽는다.
			try {
				// 파일에서 읽을 데이터가 없을 때까지 반복
				while((obj = ois.readObject()) != null) {
					// 읽은 데이터가 Object타입이기 때문에 원래의 데이터 타입으로 캐스팅, 역직렬화
					HotelRoomVO hr = (HotelRoomVO)obj;
					
					// 읽은 데이터를 map에 저장
					hmap.put(hr.getRoomNum(), hr);
				}
			} catch (ClassNotFoundException e) {
				System.out.println("해당 클래스가 존재하지 않습니다.");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("업무준비가 완료되었습니다.");
		}
	}
	
	/**
	 * map에 저장된 데이터를 파일에 저장하기 위한 메서드
	 */
	private void fileWrite() {
		System.out.println("업무를 저장중입니다....");
		
		// map에 담긴 값이 없다면 return
		if(hmap.isEmpty()) {
			System.out.println("업무를 저장하였습니다.");
			return;
		}
		
		// map에 담긴 값이 있다면 실행
		
		// 출력용 스트림 객체 생성
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					                      new BufferedOutputStream(
					                    		  new FileOutputStream(file)));
			
			// map에 담긴 객체를 파일에 저장
			for(HotelRoomVO hr : hmap.values()) {
				oos.writeObject(hr); // 직렬화 하여 파일에 저장
			}
			System.out.println("업무를 저장하였습니다.");
			
			oos.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

/**
 * 호텔방 VO
 * 파일로 읽고 쓰기 위해서 Serializable 인터페이스 구현
 */
class HotelRoomVO implements Serializable{
	private String roomNum; // 방번호
	private String guests; // 투숙객
	
	public HotelRoomVO(String roomNum, String guests) {
		this.roomNum = roomNum;
		this.guests = guests;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getGuests() {
		return guests;
	}

	public void setGuests(String guests) {
		this.guests = guests;
	}
}

/**
 * 방번호와 투숙객의 정규화를 위한 클래스
 */
class RegEx{
	
	/**
	 * 방번호 정규화를 체크하는 메서드
	 * @param roomNum
	 * @return 정규화에 부합여부
	 */
	public boolean roomNumCheck(String roomNum) {
		// 앞자리 숫자는 0이 아닌 숫자이고 다음 두자리는 0~9사이인 3자리 숫자
		String roomNumregEx = "[1-9]{1}\\d{2}";
		return Pattern.matches(roomNumregEx, roomNum);
	}
	
	/**
	 * 투숙객명 정규화를 체크하는 메서드
	 * @param roomNum
	 * @return 정규화에 부합여부
	 */
	public boolean guestsCheck(String guests) {
		// 한글만 입력가능하고 최소 2자리 이상
		String guestsregEx = "[가-힗]{2,}";
		return Pattern.matches(guestsregEx, guests);
	}
}
