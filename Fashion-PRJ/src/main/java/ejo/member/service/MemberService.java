package ejo.member.service;

import ejo.repository.vo.MemberVO;

public interface MemberService{
	public void insertMember(MemberVO member) throws Exception;
	public int selectMember(String id) throws Exception;
}
