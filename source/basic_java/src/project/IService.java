package project;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

public interface IService {
	/**
	 * 로그인을 위한 매서드
	 * @param params mem_id 사람의 아이디, mem_pass 비밀번호
	 * @return id와 pw가 일치하는 한명의 아이디, 일치하는 사람이 없으면 null
	 * @author 윤한빈
	 * @since 2020.09.04
	 * @see 
	 */
	String logIn(Map<String, String> params);

	String createMember(Map<String, String> params);
	ArrayList<MemberVO> select();

	
	

}
