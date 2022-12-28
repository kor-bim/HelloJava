package project;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

public interface IDao {
	/**
	 * 로그인을 위한 매서드
	 * @param params mem_id 사람의 아이디, mem_pass 비밀번호
	 * @return id와 pw가 일치하는 한명의 아이디, 일치하는 사람이 없으면 null
	 * @author 윤한빈
	 * @since 2020.09.04
	 * @see 
	 */
	String logIn(Map<String, String> params);
	/**
	 * 회원가입을 위한 매서드
	 * @param params mem_id 사람의 아이디, mem_pass 비밀번호, mem_name 이름, mem_job 직업
	 * @return null
	 * @author 윤한빈
	 * @since 2020.09.04
	 * @see 
	 */
	String createMember(Map<String, String> params);
	/**
	 * 조회를 위한 매서드
	 * 
	 * @return list
	 * @author 윤한빈
	 * @since 2020.09.04
	 * @see 
	 */
	ArrayList<MemberVO> select();
	

}
