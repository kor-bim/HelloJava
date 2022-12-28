package assignment.hotelmanage.vo;

/**
 * 호텔 객실의 정보를 담는 VO
 * 필드 정보
 * room_num : 객실 번호
 * guest_name : 투숙객
 * @author PC-25
 *
 */
public class RoomVO {
	private int room_num;
	private String guest_name;

	public RoomVO(int room_num, String guest_name) {
		this.room_num = room_num;
		this.guest_name = guest_name;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	@Override
	public String toString() {
		return "RoomVO [room_num=" + room_num + ", guest_name=" + guest_name + "]";
	}


}
