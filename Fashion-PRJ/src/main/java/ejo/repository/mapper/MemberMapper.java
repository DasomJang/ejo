package ejo.repository.mapper;

import ejo.repository.vo.MemberVO;

public interface MemberMapper {
	public void insertMember(MemberVO member) throws Exception;
	public int selectMember(String id) throws Exception;
}
