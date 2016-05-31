package ejo.repository.mapper;

import ejo.repository.vo.MemberVO;

public interface LoginMapper {
	public MemberVO selectOneLogin(MemberVO member) throws Exception;

}
