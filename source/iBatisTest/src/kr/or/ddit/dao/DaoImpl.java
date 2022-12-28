package kr.or.ddit.dao;

import kr.or.ddit.member.vo.MemberVO;
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
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			Object obj = smc.insert("member.insertMember", mv);
			if (obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deletMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("member.deleteMember", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("member.updateMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberVO> displayMemberAll() {

		List<MemberVO> memList = new ArrayList<MemberVO>();
		try {
			memList = smc.queryForList("member.getMemberAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public boolean getMember(String memId) {
		boolean chk = false;
		try {
			MemberVO mv = (MemberVO) smc.queryForObject("member.getMember", memId);
			if (mv != null) {
				chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {

		List<MemberVO> memList = new ArrayList<>();
		try {
			memList = smc.queryForList("member.getSearchMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

}