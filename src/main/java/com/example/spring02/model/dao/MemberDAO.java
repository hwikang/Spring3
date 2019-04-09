package com.example.spring02.model.dao;

import java.util.List;

import com.example.spring02.model.dto.MemberDTO;

public interface MemberDAO {
	public List<MemberDTO> memberList();
	public void insertMember(MemberDTO vo);
	public MemberDTO viewMember(String userid);
	public void deleteMember(String userid);
	public void updateMember(MemberDTO vo);
	public boolean checkPw(String userid, String password);
}