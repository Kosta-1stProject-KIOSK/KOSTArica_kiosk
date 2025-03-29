package com.kiosk.admin.dao;

import java.util.List;

import com.kiosk.admin.model.dto.CouponDTO;

public interface CouponDAO {

	/**
	 * 특정 회원이 가지고 있는 쿠폰 목록을 조회 
	 * @param memberId (회원의 PK)
	 * @return 해당 회원이 보유 중인 쿠폰 리스트(list)
	 */
	List<CouponDTO> searchByMember(String memberId);

	
	/**
	 * 쿠폰번호(PK)로 쿠폰 정보를 조회
	 * @param couponNo (쿠폰번호, PK)
	 * @return 쿠펀정보가 담긴 쿠폰객체 (CouponDTO)
	 */
	CouponDTO searchById(int couponNo);
	
	
	/**
	 * 쿠폰 등록
	 * @param coupon (CouponDTO coupon, 등록할 쿠폰 정보)
	 */
    void insert(CouponDTO coupon);
    
    
    /**
     * 쿠폰 사용여부 상태 갱신
     * @param couponNo
     * @param isUsed (true: 사용됨, false: 사용가능)
     */
    void updateUsage(int couponNo, boolean isUsed);
    
    
    /**
     * 쿠폰 삭제
     * @param couponNo (삭제할 쿠폰 번호)
     */
    void delete(int couponNo);
	
    
}
