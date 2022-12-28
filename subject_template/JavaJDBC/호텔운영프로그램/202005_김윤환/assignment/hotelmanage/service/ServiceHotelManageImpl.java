package assignment.hotelmanage.service;

import java.util.List;

import assignment.hotelmanage.dao.DaoHotelManageImpl;
import assignment.hotelmanage.dao.IDaoHotelManage;
import assignment.hotelmanage.vo.RoomVO;

public class ServiceHotelManageImpl implements IServiceHotelManage {
	
	private IDaoHotelManage dao;
	
	public ServiceHotelManageImpl() {
		dao = new DaoHotelManageImpl();
	}
	
	
	

	@Override
	public boolean getRoom(int roomNum) {
		return dao.getRoom(roomNum);
	}

	@Override
	public int checkIn(RoomVO rv) {
		return dao.checkIn(rv);
	}

	@Override
	public int checkOut(int roomNum) {
		return dao.checkOut(roomNum);
	}

	@Override
	public List<RoomVO> getroomStatus() {
		return dao.getroomStatus();
	}

}
