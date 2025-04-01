package com.kiosk.admin.service;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.admin.model.dao.CouponDAO;
import com.kiosk.admin.model.dao.CouponDAOImpl;
import com.kiosk.admin.model.dao.MenuDAO;
import com.kiosk.admin.model.dao.MenuDAOImpl;
import com.kiosk.admin.model.dto.Coupon;
import com.kiosk.admin.model.dto.Menu;
import com.kiosk.exception.NotFoundException;
import com.kiosk.view.ConsoleColor;

public class AdminCouponService implements ConsoleColor{
	CouponDAO couponDao = new CouponDAOImpl();
	
    /**
     * 전체 쿠폰 조회
     * */
	public List<Coupon> searchAll() throws NotFoundException , SQLException{
		List<Coupon> list=couponDao.searchAll();
		if(list.size()==0)
			throw new NotFoundException(tRED + "▶ 현재 쿠폰이 없습니다." + RESET);
		return list;
	}//searchAll
	
    /**
     * 회원별 쿠폰 조회
     * */
	public List<Coupon> searchByMember(String memberId) throws NotFoundException , SQLException{
		List<Coupon> list=couponDao.searchByMember(memberId);
		if(list.size()==0)
			throw new NotFoundException(tRED + "▶ 현재 쿠폰이 없거나 존재하지 않는 회원입니다." + RESET);
		return list;
	}//searchByMember
	
	/**
	 * 쿠폰 등록
	 */
	public int insertCoupon(Coupon coupon) throws SQLException{
		int result =  couponDao.insert(coupon);
		if(result == 0) {
			throw new SQLException(tRED + "▶ 쿠폰 등록이 실패하였습니다." + RESET);
		} else {
			return 1;
		}//end else
	}//insertCoupon
	
	/**
	 * 쿠폰 사용여부 확인
	 */
	public int searchByCouponNo(int couponNo) throws SQLException{
		int result =  couponDao.searchByCouponNo(couponNo);
		if(result == -1) {
			throw new SQLException(tRED + "▶ 쿠폰 사용정보를 가져오는데 실패하였습니다." + RESET);
		}
		return result;
	}//updateCoupon
	
	/**
	 * 쿠폰 사용여부 갱신
	 */
	public int updateCoupon(int couponNo) throws SQLException{
		int currentStatus =  couponDao.searchByCouponNo(couponNo);
		int newStatus = (currentStatus == 0) ? 1 : 0; //상태 반전
		
		int result = couponDao.updateUsage(couponNo, newStatus);
		
		if(result == 0) {
			throw new SQLException(tRED + "▶ 쿠폰 사용여부 갱신이 실패하였습니다." + RESET);
		} else {
			return result;
		}//end else
	}//updateCoupon
	
	/**
	 * 쿠폰 삭제
	 */
	public int deleteCoupon(int couponNo) throws SQLException{
		int result =  couponDao.delete(couponNo);
		if(result == 0) {
			throw new SQLException(tRED + "▶ 존재하지 않는 쿠폰입니다." + RESET);
		} else {
			return 1;
		}//end else
	}//deleteMenu
	
}//class
