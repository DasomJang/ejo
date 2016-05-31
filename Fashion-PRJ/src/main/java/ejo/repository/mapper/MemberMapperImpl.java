package ejo.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ejo.repository.vo.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper{

	@Autowired
	private SqlSessionTemplate session;
	
	private static final String MEMBER_DAO_NAMESPACE = "ejo.repository.mapper.MemberMapper";

	@Override
	public void insertMember(MemberVO member) throws Exception{
		session.insert(MEMBER_DAO_NAMESPACE + ".insertMember", member);
	}

	@Override
	public int selectMember(String id) throws Exception {
		return session.selectOne(MEMBER_DAO_NAMESPACE + ".selectMember", id);
	}

	
}
