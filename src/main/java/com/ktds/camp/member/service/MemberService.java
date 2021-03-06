package com.ktds.camp.member.service;

import com.ktds.camp.member.vo.MemberVO;

public interface MemberService {

	public boolean createNewMember(MemberVO memberVO);
	
	public int readCountMember(MemberVO memberVO);
	
	public MemberVO readOneMember(MemberVO memberVO);
	
	public MemberVO ReadtIdSearchMember(MemberVO memberVO);
}
