package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 받아 Service에 전달하는 Dao의 Interface
 * 
 * @author 윤한빈
 */
public interface IDao {
	/**
	 * MemberVO에 담긴 자료를 DB에 insert하는 메서드
	 * 
	 * @param mv
	 *            DB에 insert할 자료가 저장된 MemberVO객체
	 * @return DB 작업성공 : 1, 작업실패 : 0
	 */
	public int insertMember(MemberVO mv);

	/**
	 * 회원Id를 매개변수로 받아서 그 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId
	 * @return DB 작업성공 : 1, 작업실패 : 0
	 */
	public int deletMember(String memId);

	/**
	 * 하나의 MemberVO자료를 이용하여 DB를 update하는 메서드
	 * 
	 * @param mv
	 *            update할 회원정보가 들어있는 MemberVO객체
	 * @return DB 작업성공 : 1, 작업실패 : 0
	 */
	public int updateMember(MemberVO mv);

	/**
	 * DB의 myMember 테이블의 전체 레코드를 가져와서 List에 담아 반환
	 * 
	 * @return MemberVO객체를 담고 있는 List객체
	 */
	public List<MemberVO> displayMemberAll();

	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아냄
	 * 
	 * @param memId
	 * @return 해당 회원이 존재하면 true, 없으면 false 반환
	 * 
	 */
	public boolean getMember(String memId);
	
	/**
	 * MemberVO에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * @param mv 검색할 자료가 담긴 MemberVO 객체
	 * @return 검색된 결과를 담은 List객체
	 */
	public List<MemberVO> getSearchMember(MemberVO mv);

	public int insertBoard(BoardVO bv);

	public int updateBoard(BoardVO bv);

	public boolean getBoard_writer(String writer);

	public int deleteBoard(String writer);

	public List<BoardVO> getSearchBoard(BoardVO bv);

	public List<BoardVO> displayBoardAll();

	public List<BoardVO> selectBoard(int boardNo);
}
