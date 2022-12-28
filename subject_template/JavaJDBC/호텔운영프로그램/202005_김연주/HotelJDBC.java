package Homework;
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil2;

public class HotelJDBC {

	
	// DB 연결
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan;
	private Map<String, Room> hotelManagement;
	
	
	public HotelJDBC() {
		scan = new Scanner(System.in);
		hotelManagement = new HashMap<>();
	}
	
	
	// 메인메서드
	public static void main(String[] args) {
		HotelJDBC pb = new HotelJDBC();
		pb.hotelManagementStart();
	}
	
	
	
	
	// 메뉴 출력하는 메서드
	private void displayMenu() {
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.print("1.체크인  ");
		System.out.print("2.체크아웃  ");
		System.out.print("3.객실상태  ");
		System.out.println("4.업무종료");
		System.out.print("메뉴선택>> ");
	}
	
	
	
	// 프로그램을 시작하는 메서드
		public void hotelManagementStart(){
			System.out.println("****************************");
			System.out.println("호텔 문을 열었습니다");
			System.out.println("****************************");
			
			while(true){
				
				displayMenu();  // 메뉴 출력
				
				int menuSelect = scan.nextInt();   // 메뉴 번호 입력
				
				switch(menuSelect){
					case 1 :
						checkIn();		// 체크인
						break;
					case 2 :
						checkOut();		// 체크아웃
						break;
					case 3 :
						roomCheck();	// 객실상태 확인
						break;
					case 4 :			// 업무 종료
						System.out.println("프로그램을 종료합니다...");
						
						System.out.println("****************************");
						System.out.println("호텔 문을 닫았습니다");
						System.out.println("****************************");
						return;
					default :
						System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				} // switch문
			} // while문
		} // 메서드



		


	/** 등록
	 * 새로운 투숙객을 체크인 등록하는 메서드
	 */
	private void checkIn() {
		System.out.println();
		System.out.println("어느 방에 체크인 하시겠습니까?");
		System.out.print("방 번호 >> ");	
		String roomNum = scan.next();
		
		// 이미 체크인 완료된 방인지 체크
		if(hotelManagement.get(roomNum)!=null) {
			System.out.println("이미 체크인 완료된 방입니다.");
			return;
		}
		System.out.println("이름 >> ");
		String name = scan.next();
		
		try {
			conn = JDBCUtil2.getConnection();
			String sql = "insert into myhotel (room_num, user_name) "
						+" values (?,?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roomNum);
			pstmt.setString(2, name);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(roomNum+"체크인 성공");
			}else {
				System.out.println(roomNum+"체크인 실패");
			}
		}catch (SQLException e) {
			System.out.println("체크인 실패");
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
	
	
	
	
	/** 삭제
	 * 체크인 완료된 룸을 체크아웃하는 메서드
	 */
	private void checkOut() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방 번호 입력 >> ");
		String roomNum = scan.next();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from myhotel where room_num = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, roomNum);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println(roomNum+"체크아웃 성공");
			}else {
				System.out.println(roomNum+"체크아웃 실패");
			}
		}catch (SQLException e) {
			System.out.println("체크아웃 실패");
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		
	}
	
	
	
	
	
	
	
	/** 전체 객실 조회
	 * 전체 객실 상태 확인을 위한 메서드
	 */
	private void roomCheck() {
		System.out.println();
		System.out.println("=======================================");
		System.out.println(" \t 객실번호 \t 투숙객 \t ");
		System.out.println("=======================================");
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from myhotel";
		
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String roomNum = rs.getString("room_num");
				String name = rs.getString("user_name");
				
				System.out.println(roomNum+"\t"+name+"\t");
			}
			System.out.println("=======================================");
			System.out.println("출력 완료");
		
		}catch (SQLException e) {
			System.out.println("자료 조회 실패");
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
	
	
	

	
	
	
	/**
	 * 자원 반납용 메서드
	 */
	private void disconnect() {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
		if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null) try {conn.close();}catch(SQLException e) {}		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

/**
 * 호텔 룸 정보를 저장할 수 있는 VO클래스
 * @author ju901
 *
 */
class Room {
	private String roomNum; // 방번호
	private String name; // 투숙객
	
	
	
	public Room(String roomNum, String name) {
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

	@Override
	public String toString() {
		return "room [roomNum=" + roomNum + ", name=" + name + "]";
	}
	

	
	
	
}
