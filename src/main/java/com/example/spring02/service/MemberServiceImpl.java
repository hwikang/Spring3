package com.example.spring02.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.dao.MemberDAO;
import com.example.spring02.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	
	@Inject //spring container 에서 생성한 dao객체연결됨
	MemberDAO memberdao;
	// = MemberDAO memberdao = new MemberDAO()
	@Override
	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		return memberdao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberdao.insertMember(dto);

	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
