package ejo.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.LoginMapper;
import ejo.repository.vo.MemberVO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginMapper loginMapper;

	@Override
	public MemberVO selectOneLogin(MemberVO member) throws Exception {
		return loginMapper.selectOneLogin(member);
	}
}
