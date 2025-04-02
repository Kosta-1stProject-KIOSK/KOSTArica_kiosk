package com.kiosk.member.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.member.model.dto.Coupon;
import com.kiosk.member.model.dto.Menu;

public interface CouponDAO {
	
    /**
     * 전체 메뉴 목록 조회
     * @return 메뉴 리스트(List)
     * @throws SQLException 
     */
    List<Coupon> searchAll() throws SQLException;

	/**
	 * 특정 회원이 가지고 있는 쿠폰 목록을 조회 
	 * @param memberId (회원의 PK)
	 * @return 해당 회원이 보유 중인 쿠폰 리스트(list)
	 */
	List<Coupon> searchByMember(String memberId) throws SQLException;

	
	/**
	 * 쿠폰번호(PK)로 쿠폰 사용여부를 조회
	 * @param couponNo (쿠폰번호, PK)
	 * @return 쿠펀정보가 담긴 쿠폰객체 (CouponDTO)
	 */
	public int searchByCouponNo(int couponNo) throws SQLException;
	
	/**
	 * 쿠폰 등록
	 * @param coupon (CouponDTO coupon, 등록할 쿠폰 정보)
	 */
    int insert(Coupon coupon) throws SQLException;
    
    
    /**
     * 쿠폰 사용여부 상태 갱신
     * @param couponNo
     * @param isUsed (true: 사용됨, false: 사용가능)
     */
    int updateUsage(int couponNo, int isUsed) throws SQLException;
    
    
    /**
     * 쿠폰 삭제
     * @param couponNo (삭제할 쿠폰 번호)
     */
    int delete(int couponNo) throws SQLException;
	
    
}
