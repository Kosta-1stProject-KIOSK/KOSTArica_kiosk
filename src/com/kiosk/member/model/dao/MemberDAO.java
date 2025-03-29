package com.kiosk.member.model.dao;

import java.util.List;

import com.kiosk.member.model.dto.MemberDTO;

public interface MemberDAO {

	
	/**
	 * 회원정보 검색
	 * @param memberId (회원 PK 전화번호)
	 * @return MemberDTO (회원 정보가 담긴 객체)
	 */
	MemberDTO searchById (String memberId);
	
	
	/**
     * 전체 회원 목록 조회
     * @return 회원 목록(list)
     */
    List<MemberDTO> searchAll();

    
    /**
     * 회원 등록
     * @param member (등록할 회원정보가 담긴 객체 MemberDTO member)
     */
    void insert(MemberDTO member);

    
    /**
     * 회원 정보 수정
     * @param member (수정할 회원 정보 MemberDTO member)
     */
    void update(MemberDTO member);

    
    /**
     * 회원 삭제
     * @param memberId (삭제할 회원의 번호)
     */
    void delete(String memberId);
	
	
	
}
