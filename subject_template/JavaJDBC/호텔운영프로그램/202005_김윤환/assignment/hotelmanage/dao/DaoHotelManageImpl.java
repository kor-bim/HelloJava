package assignment.hotelmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import assignment.hotelmanage.vo.RoomVO;
import assignment.util.JDBCUtilHotelManage;

public class DaoHotelManageImpl implements IDaoHotelManage {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * 자원 반납(종료)용 메서드
	 */
	public void disconnect() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException e) {
			
		}
	}
	
	
	
	
	

	@Override
	public boolean getRoom(int roomNum) {
		boolean chk = false;
		
		try {
			conn = JDBCUtilHotelManage.getConnection();
			String sql = "select count(*) as cnt from hotel_mng where room_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			rs = pstmt.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			if( cnt > 0) {
				chk = true;
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return chk;
	}

	@Override
	public int checkIn(RoomVO rv) {
		int cnt = 0;
		try {
			conn = JDBCUtilHotelManage.getConnection();
			String sql = "insert into hotel_mng "
					   + "values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rv.getRoom_num());
			pstmt.setString(2, rv.getGuest_name());
			cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	@Override
	public int checkOut(int roomNum) {
		int cnt = 0;
		try {
			conn = JDBCUtilHotelManage.getConnection();
			String sql = "delete from hotel_mng where room_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return cnt;
	}

	@Override
	public List<RoomVO> getroomStatus() {
		List<RoomVO> roomList = new ArrayList<>();
		
		try {
			conn = JDBCUtilHotelManage.getConnection();
			String sql = "select * from hotel_mng";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				RoomVO room = new RoomVO(rs.getInt("room_num"), rs.getString("guest_name"));
				roomList.add(room);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return roomList;
	}

}
