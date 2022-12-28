package assignment.hotelmanage.dao;

import java.util.List;

import assignment.hotelmanage.vo.RoomVO;

/**
 * db의 작업을 담당하는 dao
 * @author link_
 *
 */
public interface IDaoHotelManage {

	/**
	 * 호텔의 객실 번호를 입력받아 이미 체크인 된 객실인지 확인하는 메서드
	 * @param roomNum 체크인하려는 객실의 번호
	 * @return 객실 체크인 여부 true : 이미 체크인 된 객실, false : 체크인 안 된 객실. 
	 */
	boolean getRoom(int roomNum);

	/**
	 * 호텔의 객실 정보를 입력받아 db에 저장하는 메서드
	 * @param rv 호텔의 객실 정보를 담고 있는 RoomVO 객체
	 * @return 작업 성공한 레코드 수
	 */
	int checkIn(RoomVO rv);

	/**
	 * 호텔의 객실 번호를 입력받아 해당 객실을 db에서 삭제하는 메서드
	 * @param roomNum 체크아웃하려는 호텔의 객실 번호 
	 * @return 작업 성공한 레코드 수
	 */
	int checkOut(int roomNum);

	/**
	 * 호텔의 모든 객실의 체크인 정보를 db에서 가져오는 메서드
	 * 리스트에 담아 보내줌
	 * @return 체크인 중인 모든 객실의 리스트
	 */
	List<RoomVO> getroomStatus();
	
}
