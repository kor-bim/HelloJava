package practice;

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

public class HotelIOTest {
	FileInputStream fis;   // 파일을 읽어오기위한 스트림
	FileOutputStream fos;  // 파일을 저장하기위한 스트림   

	private Map<String, GuestRoom> roomMap; // 호텔예약 정보를 위한 Map선언
	
	public HotelIOTest() {
		Scanner sc = new Scanner(System.in);
		roomMap = new HashMap<String, GuestRoom>();
	}

	public static void main(String[] args) {
		HotelIOTest ht = new HotelIOTest();
		ht.Hotel();
	}
	
	/**
	 * 호텔 시작을 위한 메서드
	 */
	private void Hotel() {
		start();
		
		System.out.println("===================");
		System.out.println("!KH Hotel Open!");
		System.out.println("===================");
		System.out.println();
		System.out.println();
		while (true) {
			System.out.println("=====================================");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실현황 4.영업종료");
			System.out.println("=====================================");

			Scanner sc = new Scanner(System.in);
			try {
				int key = sc.nextInt();

				switch (key) {
				case 1:
					checkIn();
					break;
				case 2:
					checkOut();
					break;
				case 3:
					condition();
					break;
				case 4:
					end();
					System.out.println("영업을 종료하였습니다.");
					System.exit(0);
					return;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}

			} catch (Exception e) {
				System.out.println("숫자만 입력해주세요");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 객실현황을 조회하는 메서드
	 */
	private void condition() {
		
		Set<String> keySet = roomMap.keySet(); // String타입을 제너릭으로한 keyset을 선언한다 roomMap의 키값만 가져온다
	
		System.out.println("=======================");
		System.out.println(" \t객실 번호\t객실 사용자이름");
		System.out.println("=======================");
	
		if(keySet.size() == 0) {
			System.out.println("사용중인 객실이 없습니다.");
		} else {
			Iterator<String> it = keySet.iterator(); // keyset을 iterator로 변환하여 순서로 출력한다
			int cnt = 0;
			while(it.hasNext()) {
				cnt++;
				String number = it.next();         // iterator의  key값을 가져와서 number에 저장한다
				GuestRoom r = roomMap.get(number); // roomMap의 키값으로 number를 받아 r에 저장한다
				System.out.println(" " + cnt + "\t" + r.getNumber() + "\t" + r.getName());
			}
			System.out.println("=========================");
		}
	}

	/**
	 * 호텔 체크아웃을 위한 메서드
	 */
	private void checkOut() {
	
		System.out.println();
		System.out.println("체크아웃 하실 객실 번호를 입력해주세요.");
		System.out.println("객실 번호 : ");
		
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		
		if(roomMap.remove(number) == null){
			System.out.println(number + "번객실은 사용중인 객실이 아닙니다.");
		}else {
			System.out.println(number + "번객실을 체크아웃 했습니다.");
		}
	}

	/**
	 * 호텔에 체크인을 위한 메서드
	 */
	private void checkIn() {
		System.out.println();
		System.out.println("어느객실에 체크인 하시겠습니까?");
		System.out.println("객실 번호 : ");
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
			
		if(roomMap.get(number) != null) {
			System.out.println(number + "객실은 이미 예약된 객실입니다");
			return;
		}
		System.out.println("객실사용자 이름 : ");
		String name = sc.next();
		
		roomMap.put(number, new GuestRoom(number, name));
		System.out.println(number + "번객실 체크인 완료");
	}
	
	/**
	 * 프로그램 시작시 파일에 저장되어있는 정보를 로드한다
	 */
	private void start() {
		try {
			// 역직렬화 (byte단위 형태로 변환된 객체를 원래 형태로 변환)
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/Hotel.txt")));

			Object obj = null;

			try {
				while ((obj = ois.readObject()) != null) {
					// 읽어온 데이터를 원래의 객체형으로 변환 후 객체를 저장 사용한다
					// roomMap은 Map<String, GuestRoom>으로 선언
					roomMap = (Map<String, GuestRoom>) obj; 
				}
				ois.close(); // 자료를 반납한다
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("로드완료");
		}
	}
	
	/**
	 * 프로그램 종료시 입력한 자료들을 파일에 저장한다
	 */
	private void end() {
		try {
			// 직렬화 (정보를 byte단위 형태로 변환 시켜 객체를 저장한다)
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/Hotel.txt")));
			
			oos.writeObject(roomMap); // 객체에 있는 정보를 파일에 저장한다
			
			oos.close(); // 자료를 반납해준다
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} 

/**
 * 방의 정보를 저장할수 있는 VO클래스
 */
class GuestRoom implements Serializable {
	private String number;    // 방 번호
	private String name;      // 객실사용자 이름

	public GuestRoom(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GuestRoom [number=" + number + ", name=" + name + "]";
	}
}
