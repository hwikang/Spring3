package com.example.spring02.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.dto.MemberDTO;
//서버가 start 할때 자동으로 메모리에 이클래스를 올려줌
@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger =  LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Inject   //mybatis이 sqlsession 을가져옴,의존관계 , 스프링에서만들어놓은걸 쓰는거임 
	SqlSession sqlSession;
	//inject만해도 sqlsession은 null 이 아니다.
	//sql session은 root-context에 bean으로 있음
	@Override
	public List<MemberDTO> memberList() {
		logger.info("memberlist called...");
		//sql mapper에작성괸 sql 코드실행, (auto commit, close)
		//sqlSession.commit()
		//sqlSession.close();
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberDTO vo) {
		logger.info("insert member called.." );
		sqlSession.insert("member.insertMember" , vo);   //commit.clost auto
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
	public void updateMember(MemberDTO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
