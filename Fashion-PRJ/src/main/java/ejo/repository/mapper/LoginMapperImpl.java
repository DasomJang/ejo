package ejo.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.MemberVO;

@Repository
public class LoginMapperImpl implements LoginMapper{

	@Autowired
	private SqlSessionTemplate session;
	
	private static final String LOGIN_DAO_NAMESPACE = "ejo.repository.mapper.LoginMapper";

	@Override
	public MemberVO selectOneLogin(MemberVO member) throws Exception {
		return session.selectOne(LOGIN_DAO_NAMESPACE+".selectOneLogin", member);
	}

}
