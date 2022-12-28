package homework;

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
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelIOTest {
	private Scanner sc;
	private Map<Integer,HotelIO> hotelBooking;
	
	
	public HotelIOTest() {
		sc = new Scanner(System.in);
		hotelBooking = new HashMap<>();
	}
	
	public static void main(String[] args) {
		HotelIOTest ht = new HotelIOTest();
		ht.start();
	}
	
	
	
	private void start() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		read();
		
		while (true) {
		try {
				System.out.println();
				System.out.println("어떤 업무를 하시겠습니까?");
				System.out.println("1.체크인  2.체크아웃  3.객실상태  4.업무종료");
				System.out.println("**************************");
				System.out.print("메뉴선택 => ");
				Scanner scan = new Scanner(System.in);
				int key = scan.nextInt();
				switch (key) {
				case 1:
					checkin();
					break;
				case 2:
					checkout();
					break;
				case 3:
					condition();
					break;
				case 4:
					write();
					System.out.println("**************************");
					System.out.println("호텔 문을 닫았습니다.");
					System.out.println("**************************");
					System.exit(0);
					return;
				default:
					System.out.println("다시 입력해주세요.");
					break;
				}
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요.");
			}
		}
		
	}
	
	private void checkin(){
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		try {
			int room = sc.nextInt();
			
			if(hotelBooking.get(room)!=null) {
				System.out.println(room + "방에는 이미 사람이 있습니다.");
				return;
			}
			
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력 => ");
			String name = sc.next();
			
			hotelBooking.put(room, new HotelIO(room,name));
			
			System.out.println("체크인 되었습니다");
			
		}catch(Exception e) {
			System.out.println("숫자만 입력해주세요.");
		}
	}
	
	private void checkout(){
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		try {
			int room = sc.nextInt();
			if(hotelBooking.remove(room) == null) {
				System.out.println(room + "방에는 체크인한 사람이 없습니다.");
			} else {
				System.out.println("체크아웃 되었습니다.");
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요.");
		}
	}
	
	private void condition(){
		
		Set<Integer> keySet = hotelBooking.keySet();
		
		if(keySet.size()==0) {
			System.out.println("체크인중인 방이 없습니다.");
		} else {
			Iterator<Integer> it = keySet.iterator();
			while(it.hasNext()) {
				Integer key = it.next();
				HotelIO h = hotelBooking.get(key);
				System.out.println("방번호 : " + h.getRoom() + ", 투숙객 : " + h.getName());
			}
		}
	}
	
	// 입력해둔 Map 형식의 자료를 txt파일에 등록한다.
	private void write() {
		
		//HotelTest.txt 파일에 투숙객의 정보를 저장 할 것이다.
		File f1 = new File("d:/D_other/HotelTest.txt");
		
		//만약 파일이 존재하지 않는다면 파일을 일단 생성한 후 실행한다.
		if(!(f1.exists())) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("d:/D_Other/HotelTest.txt")));
			//oos에 hotelBooking 정보들을 저장한다
			oos.writeObject(hotelBooking);
			// 자원반납
			oos.close();

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	private void read() {
		
		//Object랑 Buffered는 보조스트림임
		//FileInput이 찐
		//이걸 효율성 있게 도와주기 위해서 사용하는 것이다
		//BufferedInput -> 모아뒀다가 한번에 보내기 위함 (속도향상)
		//ObjectInput -> 객체 역직렬화에 사용
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("d:/D_Other/HotelTest.txt")));
			Object obj = null;

			try {
				
				//근데 hotelBooking은 Map 형식이기때문에
				//형변환을 해준다 (down-casting)
				while ((obj = ois.readObject()) != null) {
					
					hotelBooking = (Map<Integer, HotelIO>) obj;
				}
				//자원반납
				ois.close();
			} catch (ClassNotFoundException e) {
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}
}


class HotelIO implements Serializable{
	private int room;
	private String name;
	public HotelIO(int room, String name) {
		super();
		this.room = room;
		this.name = name;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hotel [room=" + room + ", name=" + name + "]";
	}
}