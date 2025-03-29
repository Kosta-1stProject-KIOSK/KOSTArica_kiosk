package com.kiosk.member.dao;

import java.util.List;

import com.kiosk.member.model.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO {

	/**
	 * 회원정보 검색
	 * @param memberId (회원 PK 전화번호)
	 * @return MemberDTO (회원 정보가 담긴 객체)
	 */
	@Override
	public MemberDTO searchById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 전체 회원 목록 조회
     * @return 회원 목록(list)
     */
	@Override
	public List<MemberDTO> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 회원 등록
     * @param member (등록할 회원정보가 담긴 객체 MemberDTO member)
     */
	@Override
	public void insert(MemberDTO member) {
		// TODO Auto-generated method stub
		
	}

	
	
	 /**
     * 회원 정보 수정
     * @param member (수정할 회원 정보 MemberDTO member)
     */
	@Override
	public void update(MemberDTO member) {
		// TODO Auto-generated method stub
		
	}

	
	
	/**
     * 회원 삭제
     * @param memberId (삭제할 회원의 번호)
     */
	@Override
	public void delete(String memberId) {
		// TODO Auto-generated method stub
		
	}

}
