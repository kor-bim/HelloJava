package kr.or.ddit.dao;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class DaoImpl implements IDao {
	private SqlMapClient smc;
	private static IDao dao;
	
	private DaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}

	public static IDao getInstance() {
		if (dao == null) {
			dao = new DaoImpl();
		}
		return dao;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("board.insertBoard", bv);
			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		try {
			cnt = smc.update("board.updateBoard", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public boolean getBoard_writer(String writer) {
		boolean chk = false;
		try {
			BoardVO bv = (BoardVO) smc.queryForObject("board.getBoard_writer", writer);
			if (bv != null) {
				chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public int deleteBoard(String writer) {
		int cnt = 0;
		try {
			cnt = smc.delete("board.deleteBoard", writer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();
		try {
			boardList = smc.queryForList("board.getSearchBoard", bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> displayBoardAll() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			boardList = smc.queryForList("board.getBoardAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardVO> selectBoard(int boardNo) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			boardList = smc.queryForList("board.selectBoard", boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
}