package kr.or.ddit.dao;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil;

import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

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

	public SqlMapClient ibts() {
		SqlMapClient smc = null;
		try {
			Charset charset = Charset.forName("UTF-8"); // 설정파일의 인코딩 설정
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smc;
	}

	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = JDBCUtil.getConnection();
			SqlMapClient smc = ibts();
			Object obj = smc.insert("memberTest.insertMember", mv);
			if (obj == null) {
				cnt = 1;
			}
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
			SqlMapClient smc = ibts();
			cnt = smc.delete("memberTest.deleteMember", memId);
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
			SqlMapClient smc = ibts();
			cnt = smc.update("memberTest.updateMember", mv);
		} catch (SQLException e) {

		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return cnt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberVO> displayMemberAll() {

		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			conn = JDBCUtil.getConnection();
			SqlMapClient smc = ibts();
			memList = smc.queryForList("memberTest.getMemberAll");
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
			SqlMapClient smc = ibts();
			Object obj = smc.queryForObject("memberTest.getMember", memId);
			if (obj != null) {
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
			SqlMapClient smc = ibts();
			Object obj = smc.insert("boardTest.insertBoard", bv);
			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			SqlMapClient smc = ibts();
			cnt = smc.update("boardTest.updateBoard", bv);
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
			SqlMapClient smc = ibts();
			Object obj = smc.queryForObject("boardTest.getBoard_writer", writer);
			if (obj != null) {
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
			SqlMapClient smc = ibts();
			cnt = smc.delete("boardTest.deleteBoard", writer);
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
				sql += " and to_char(board_date, 'yyyy-mm-dd') = to_date(?, 'YYYY-MM-DD') ";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> displayBoardAll() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			SqlMapClient smc = ibts();
			boardList = smc.queryForList("boardTest.getBoardAll");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return boardList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> selectBoard(int boardNo) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			SqlMapClient smc = ibts();
			boardList = smc.queryForList("boardTest.selectBoard", boardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return boardList;
	}
}