package kr.or.ddit.dao;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoImpl implements IDao {

	Date date = new Date();

	private static IDao dao;

	private DaoImpl() {

	}

	public static IDao getInstance() {
		if (dao == null) {
			dao = new DaoImpl();
		}
		return dao;
	}

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into mymember(mem_id, mem_name, mem_tel, mem_addr) " + " values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_addr());
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {

		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deletMember(String memId) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(memId + "회원의 삭제작업 실패!!");
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update mymember set mem_name= ?, mem_tel = ?,mem_addr = ?" + " where mem_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_name());
			pstmt.setString(2, mv.getMem_tel());
			pstmt.setString(3, mv.getMem_addr());
			pstmt.setString(4, mv.getMem_id());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {

		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<MemberVO> displayMemberAll() {

		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MemberVO mv = new MemberVO();
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_tel(rs.getString("mem_tel"));
				mv.setMem_addr(rs.getString("mem_addr"));

				memList.add(mv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return memList;
	}

	@Override
	public boolean getMember(String memId) {
		boolean chk = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT COUNT(*) AS CNT FROM MYMEMBER " + " WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("CNT");
			}

			if (count > 0) {
				chk = true;
			}
		} catch (SQLException e) {
			chk = false;
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return chk;

	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {

		List<MemberVO> memList = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM MYMEMBER WHERE 1=1 ";
			if (mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				sql += " and mem_id = ? ";
			}
			if (mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				sql += " and mem_name = ? ";
			}
			if (mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				sql += " and mem_tel = ? ";
			}
			if (mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				sql += " and mem_addr like '%' || ? || '%'  ";
			}

			pstmt = conn.prepareStatement(sql);
			int index = 1;
			if (mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				pstmt.setString(index++, mv.getMem_id());
			}
			if (mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				pstmt.setString(index++, mv.getMem_name());
			}
			if (mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				pstmt.setString(index++, mv.getMem_tel());
			}
			if (mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				pstmt.setString(index++, mv.getMem_addr());
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO mv2 = new MemberVO();
				mv2.setMem_id(rs.getString("mem_id"));
				mv2.setMem_name(rs.getString("mem_name"));
				mv2.setMem_tel(rs.getString("mem_tel"));
				mv2.setMem_addr(rs.getString("mem_addr"));

				memList.add(mv2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return memList;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();

			String sql = "insert into JDBC_BOARD(board_no, board_title, board_writer, board_content, board_date) "
					+ " values(board_seq.NEXTVAL,?, ?, ?, to_date(sysdate,'yyyy.mm.dd hh24:mi'))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_writer());
			pstmt.setString(3, bv.getBoard_content());
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {

		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();

			String sql = "UPDATE JDBC_BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? "
					+ " WHERE board_writer = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getBoard_title());
			pstmt.setString(2, bv.getBoard_content());
			pstmt.setString(3, bv.getBoard_writer());

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, pstmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public boolean getBoard_writer(String writer) {
		boolean chk = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = " SELECT COUNT(*) AS CNT FROM jdbc_board " + " WHERE board_writer = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);

			rs = pstmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("CNT");
			}

			if (count > 0) {
				chk = true;
			}
		} catch (SQLException e) {
			chk = false;
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return chk;
	}

	@Override
	public int deleteBoard(String writer) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = " delete from jdbc_board where board_writer = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);

			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(writer + "회원의 삭제작업 실패!!");
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();

		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM jdbc_board WHERE 1=1 ";
			if (bv.getBoard_title() != null && !bv.getBoard_title().equals("")) {
				sql += " and board_title = ? ";
			}
			if (bv.getBoard_writer() != null && !bv.getBoard_writer().equals("")) {
				sql += " and board_writer = ? ";
			}
			if (bv.getBoard_date() != null && !bv.getBoard_date().equals("")) {
				sql += " and board_date = ? ";
			}
			if (bv.getBoard_content() != null && !bv.getBoard_content().equals("")) {
				sql += " and board_content like '%' || ? || '%'  ";
			}

			pstmt = conn.prepareStatement(sql);
			int index = 1;
			if (bv.getBoard_title() != null && !bv.getBoard_title().equals("")) {
				pstmt.setString(index++, bv.getBoard_title());
			}
			if (bv.getBoard_writer() != null && !bv.getBoard_writer().equals("")) {
				pstmt.setString(index++, bv.getBoard_writer());
			}
			if (bv.getBoard_date() != null && !bv.getBoard_date().equals("")) {
				pstmt.setString(index++, bv.getBoard_date());
			}
			if (bv.getBoard_content() != null && !bv.getBoard_content().equals("")) {
				pstmt.setString(index++, bv.getBoard_content());
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO bv2 = new BoardVO();
				bv2.setBoard_title(rs.getString("board_title"));
				bv2.setBoard_writer(rs.getString("board_writer"));
				bv2.setBoard_date(rs.getString("board_date"));
				bv2.setBoard_content(rs.getString("board_content"));

				boardList.add(bv2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return boardList;
	}

	@Override
	public List<BoardVO> displayBoardAll() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil2.getConnection();
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				BoardVO bv = new BoardVO();
				bv.setBoard_no(rs.getInt("board_no"));
				bv.setBoard_title(rs.getString("board_title"));
				bv.setBoard_writer(rs.getString("board_writer"));
				bv.setBoard_date(rs.getString("board_date"));

				boardList.add(bv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return boardList;
	}

	@Override
	public List<BoardVO> selectBoard(int boardNo) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from jdbc_board where board_no = '" + boardNo + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				BoardVO bv = new BoardVO();
				bv.setBoard_no(rs.getInt("board_no"));
				bv.setBoard_title(rs.getString("board_title"));
				bv.setBoard_writer(rs.getString("board_writer"));
				bv.setBoard_content(rs.getString("board_content"));
				bv.setBoard_date(rs.getString("board_date"));
				boardList.add(bv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return boardList;
	}
}