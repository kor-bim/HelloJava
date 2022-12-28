package dongju;

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


public class HotelTestIO {
	private Scanner scan;
	private Map<Integer, HotelRoom> HotelRoomMap; //키값은 방번호

	public HotelTestIO() {
		scan = new Scanner(System.in);
		HotelRoomMap = new HashMap<Integer, HotelRoom>();
	}

	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		System.out.println("********************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("********************");
		System.out.println();
	}

	// 프로그램을 시작하는 메서드
	public void HotelRoomStart() {
		hotelread();	//기존정보 불러오기
		displayMenu(); // 메뉴 출력

		while (true) {
			System.out.println("**********************************");
			System.out.println(" 1.체크인 2.체크아웃 3.객실상태  4.업무종료");
			System.out.println("**********************************");
			System.out.print(" 매뉴 선택 => ");

			int menuNum = scan.nextInt(); // 메뉴 번호 입력

			switch (menuNum) {
			case 1:
				checkin();	//체크인
				break;
			case 2:
				checkout(); //체크아웃
				break;
			case 3:
				room();	//객실상태조회
				break;
			case 4:
				Hotelsave();//호텔저장하기
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			} // switch문
		} // while문
	}

	/**
	 * 호텔기존의 정보를 불러오기위한 메서드
	 */
	private void hotelread() {
		try {
			
			//입력용 스트림 객체 생성
			//역직렬화(스트림으로부터 데이터를 읽어서 객체를 만드는 것)
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/D_Other/hotel.txt")));

			Object obj = null;

			try {
				while ((obj = ois.readObject()) != null) {

					Map<Integer, HotelRoom> hotel = (Map<Integer, HotelRoom>) obj;

					HotelRoomMap = hotel;
				}
				ois.close();

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			//e.printStackTrace();
			//더이상 읽어올 객체가 없으면 예외 발생함.
		}

	}

	/**
	 * 종료한 호텔의 이용기록을 파일에 저장하는 메서드
	 */
	private void Hotelsave() {
		try {
			
			//출력용 스트림 객체 생성
			//직렬화(객체에 저장된 데이터를 스트림에 쓰기위해 연속적인 데이터로 변환하는 것)
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/D_Other/hotel.txt")));
		
			oos.writeObject(HotelRoomMap);
			 
			oos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 체크아웃하는 메서드
	 */
	private void checkout() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 =>");
		int num = scan.nextInt();

		// remove(key) => 삭제성공하면 삭제된 value값을 반환하고, 실패하면 null을 반환한다.
		if (HotelRoomMap.remove(num) == null) {
			System.out.println(num + "방에는 체크인한 사람이 없습니다.");
		} else {
			System.out.println("체크아웃 되었습니다.");
		}

	}

	/**
	 * 객실조회하는 메서드
	 */
	private void room() {
		Set<Integer> keySet = HotelRoomMap.keySet(); //키값만 가져온다.

		if (keySet.size() == 0) {
			System.out.println("정보가 없습니다.");
		} else {
			Iterator<Integer> it = keySet.iterator();	//배열로 변환해서 순차적으로 출력하기위해
			System.out.println("===========================");
			System.out.println("\t방번호\t투숙객" );
			int count = 0;
			while (it.hasNext()) { //다음것이 있는지 확인
				count++;
				int num = it.next(); // 키값을 가져온다
				HotelRoom p = HotelRoomMap.get(num);
				System.out.println(count + "\t" + p.getNum() + "\t" + p.getName());
			}
			System.out.println("===========================");
		}

	}

	/**
	 * 체크인하기위한 메서드
	 */
	private void checkin() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.println("방번호 입력 =>");
		int num = scan.nextInt();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 =>");
		String name = scan.next();

		if (HotelRoomMap.get(num) != null) {
			System.out.println(num + "방에는 이미 사람이 있습니다.");
			return; // 메서드 종료
		}

		HotelRoomMap.put(num, new HotelRoom(num, name));
		System.out.println("체크인 되었습니다.");

	}

	/**
	 * 메인메서드
	 */
	public static void main(String[] args) {
		HotelTestIO ht = new HotelTestIO();
		ht.HotelRoomStart();
	}
}

/**
 * 호텔정보를 담기위한 클래스
 * @author PC-22
 *
 */
class HotelRoom implements Serializable{	//implements Serializable 안하면 오류(java.io.NotSerializableException)
											//모든 클래스의 최상위 클래스인 Object클래스는 Serializable을 구현하고 있지 않기 때문에 직렬화 할수 없어서 구현해야 직렬화할수있음
											//직렬화 사용 이유 : 객체를 파일에 저장하거나 파일에서 꺼내오기 위해서
	private int num; // 방번호,키값
	private String name; // 이름

	public HotelRoom(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HotelRoom [num=" + num + ", name=" + name + "]";
	}

}