package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 받아 Controller에 전달하는 Service의 Interface
 * 
 * @author 윤한빈
 */
public interface IService {

	public int insertBoard(BoardVO bv);

	public int updateBoard(BoardVO bv);

	public boolean getBoard_writer(String writer);

	public int deletBoard(String writer);

	public List<BoardVO> getSearchBoard(BoardVO bv);

	public List<BoardVO> displayBoardAll();

	public List<BoardVO> selectBoard(int boardNo);
}
