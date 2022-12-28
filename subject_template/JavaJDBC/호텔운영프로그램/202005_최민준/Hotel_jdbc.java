package hotelJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hotel_jdbc {
	private Scanner scan;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Hotel_jdbc() {
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Hotel_jdbc hotelJDBC = new Hotel_jdbc();
		hotelJDBC.start();
	}

	private void start() {
		display();
	}

	/**
	 * 자원반납
	 */
	private void disconnect() {
		if(rs != null) try {rs.close();}catch(SQLException e){}
		if(stmt != null)try {stmt.close();}catch(SQLException e) {}
		if(pstmt != null)try {pstmt.close();}catch(SQLException e) {}
		if(conn != null)try {conn.close();}catch(SQLException e) {}
	}
	
	private void display() {
		int input;
		System.out.println("*********************");
		System.out.println("호텔문을 열었습니다");
		System.out.println("*********************");
		do {
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("메뉴선택 >> ");
			input = scan.nextInt();
			switch(input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomState();
				break;
			case 4:
				System.out.println("호텔문닫음....");
				return;
			default:
				System.out.println("메뉴에 있는 항목만 입력해주세요");
				break;
			}
		}while(input != 4);
		
	}
	
	private void roomState() {
		System.out.println("*****현재 객실 정보*****");
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from HOTEL_MNG";
			stmt = conn.createStatement(); // db접속
			rs = stmt.executeQuery(sql); // 질의문 실행
			
			while(rs.next()) { // 해당 질의문 값이 있다면 출력
				System.out.println("방 번호 : "+rs.getInt(1)+" / 투숙객이름 : "+rs.getString(2));
			}
			System.out.println("*****출력완료*****");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { // 자원반납
			disconnect();
		}
		
	}

	private void checkOut() {
		int cnt; // delete 쿼리반환값을 저장해줄 변수
		System.out.println("체크아웃하실 방 번호를 입력해주세요");
		int room_num = scan.nextInt();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from HOTEL_MNG where room_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, room_num);
			cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("체크아웃을 성공했습니다");
			}else {
				System.out.println("체크아웃을 실패했습니다");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	private void checkIn() {
		int cnt=0;
		System.out.println("어느방에 체크인 하시겠습니까?");
		int room_num = scan.nextInt();
		System.out.println("체크인 하시는분 성함이 어떻게 되시는지?");
		String guest_name = scan.next();
		
		try {
			// DB연결 
			conn = JDBCUtil.getConnection();
			// sql문 작성
			String sql = "insert into HOTEL_MNG "
					+ " values(?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, room_num);
			pstmt.setString(2, guest_name);
			cnt = pstmt.executeUpdate(); // 질의문처리가 되면 된만큼 건수 반환 
			
			if(cnt>0) {
				System.out.println("체크인을 성공했습니다");
			}else {
				System.out.println("체크인을 실패했습니다");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
	}

	
}


