package ejo.login.service;

import ejo.repository.vo.MemberVO;

public interface LoginService {
	public MemberVO selectOneLogin(MemberVO member) throws Exception;
}
