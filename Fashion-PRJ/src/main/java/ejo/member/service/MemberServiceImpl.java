package ejo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejo.repository.mapper.MemberMapper;
import ejo.repository.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public void insertMember(MemberVO member) throws Exception{
		memberMapper.insertMember(member);
	}

	@Override
	public int selectMember(String id) throws Exception {		
		return memberMapper.selectMember(id);
	}	
}
