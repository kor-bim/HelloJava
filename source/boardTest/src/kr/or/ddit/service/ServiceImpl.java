package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.dao.DaoImpl;


public class ServiceImpl implements IService {
	private IDao dao;

	private static IService service;

	public static IService getInstance() {
		if (service == null) {
			service = new ServiceImpl();
		}
		return service;
	}

	private ServiceImpl() {
		dao = DaoImpl.getInstance();
	}

	@Override
	public int insertBoard(BoardVO bv) {
		return dao.insertBoard(bv);
	}

	@Override
	public int updateBoard(BoardVO bv) {
		return dao.updateBoard(bv);
	}

	@Override
	public boolean getBoard_writer(String writer) {
		return dao.getBoard_writer(writer);
	}

	@Override
	public int deletBoard(String writer) {
		return dao.deleteBoard(writer);
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		return dao.getSearchBoard(bv);
	}

	@Override
	public List<BoardVO> displayBoardAll() {
		return dao.displayBoardAll();
	}

	@Override
	public List<BoardVO> selectBoard(int boardNo) {
		return dao.selectBoard(boardNo);
	}

}
