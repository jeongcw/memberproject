package com.hk.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.member.dao.MemberDao;
import com.hk.member.mapper.MemberMapper;
import com.hk.member.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	MemberDao memberDao;
	
//	public List<Member> memberList() {
//		return memberMapper.memberList();
		
		public List<Member> memberList() {
			return memberDao.memberList();
	}
		
		public int  memberRegister(Member member) {
			int retVal = memberMapper.memberRegister(member);
			System.out.println("retVal = "+ retVal);
			return retVal;
		}
		
		public Member memberGetOne(int mno) {
			return memberMapper.memberGetOne(mno);
		}
		
		public int memberUpdate(Member member) {
			int retVal = memberMapper.memberUpdate(member);
			return retVal;
		}

		public Member memberLogin(Member member) {
			// TODO Auto-generated method stub
			Member loginMember = null;
			loginMember = memberMapper.memberLogin(member);
			return loginMember;
		}

		public int memberDelete(int mno) {
			// TODO Auto-generated method stub
			return memberMapper.memberDelete(mno);
			
		}
}
