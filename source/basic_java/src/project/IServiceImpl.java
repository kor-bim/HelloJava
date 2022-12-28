package project;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

public class IServiceImpl implements IService {

	private IDao dao = new IDaoImpl();

	@Override
	public String logIn(Map<String, String> params) {
		String mem_id = dao.logIn(params);
		return mem_id;
	}

	@Override
	public String createMember(Map<String, String> params) {
		String mem_id = dao.createMember(params);
		return mem_id;

	}

	@Override
	public ArrayList<MemberVO> select() {
		ArrayList<MemberVO> list = dao.select();
		return list;
	}




}
