package com.kiosk.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kiosk.admin.model.dto.Coupon;
import com.kiosk.util.DBManager;

public class CouponDAOImpl implements CouponDAO{
	
    /**
     * 전체 쿠폰 목록 조회
     * @return 쿠폰 리스트(List)
     * @throws SQLException 
     */
    public List<Coupon> searchAll() throws SQLException {
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from coupon"; 
				
		List<Coupon> list = new ArrayList<Coupon>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Coupon coupon = new Coupon(
					rs.getInt(1),
					rs.getString(2),
					rs.getInt(3),
					rs.getString(4),
					rs.getString(5),
					rs.getInt(6),
					rs.getString(7)
				);
				
				list.add(coupon);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
    };
	
	/**
	 * 특정 회원이 가지고 있는 쿠폰 목록을 조회 
	 * @param memberId (회원의 PK)
	 * @return 해당 회원이 보유 중인 쿠폰 리스트(list)
	 */
	@Override
	public List<Coupon> searchByMember(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select coupon_no, coupon_name, discount, valid_from, valid_until, is_used	"
				+ "from coupon where member_id = ?"; 
				
		List<Coupon> list = new ArrayList<Coupon>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, memberId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Coupon coupon = new Coupon(
					rs.getInt(1),
					rs.getString(2),
					rs.getInt(3),
					rs.getString(4),
					rs.getString(5),
					rs.getInt(6)
				);
				
				list.add(coupon);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}
	
	
	/**
	 * 쿠폰 등록
	 * @param coupon (CouponDTO coupon, 등록할 쿠폰 정보)
	 */
	@Override
	public int insert(Coupon coupon) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into coupon(coupon_name, discount, valid_from, valid_until, is_used, member_id)	"
				+ "values (?, ?, ?, ?, ?, ?);"; 

		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, coupon.getCouponName());
			ps.setInt(2, coupon.getDiscount());
			ps.setString(3, coupon.getValidFrom());
			ps.setString(4, coupon.getValidUntil());
			ps.setInt(5, coupon.getIsUsed());
			ps.setString(6, coupon.getMemberId());
			
			result = ps.executeUpdate();
			
		} finally {
			DBManager.dbClose(con, ps);
		}//end finally
		
		return result;
	}

	
	/**
	 * 쿠폰번호(PK)로 쿠폰 사용여부를 조회
	 * @param couponNo (쿠폰번호, PK)
	 * @return 쿠폰정보가 담긴 쿠폰객체 (CouponDTO)
	 */
	@Override
	public int searchByCouponNo(int couponNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select is_used	"
				+ "from coupon where coupon_no = ?"; 
				
		int result = -1;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, couponNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}//end if
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return result;
	}
	
	
	/**
     * 쿠폰 사용여부 상태 갱신
     * @param couponNo
     * @param isUsed (true: 사용됨, false: 사용가능)
     */
	@Override
	public int updateUsage(int couponNo, int isUsed) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update coupon	"
				+ "set is_used = ?	"
				+ "where coupon_no = ?";

		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, isUsed);
			ps.setInt(2, couponNo);
			
			result = ps.executeUpdate();
			
		} finally {
			DBManager.dbClose(con, ps);
		}//end finally
		
		return result;
	}

	
	/**
     * 쿠폰 삭제
     * @param couponNo (삭제할 쿠폰 번호)
     */
	@Override
	public int delete(int couponNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from coupon	"
				+ "where coupon_no = ?"; 

		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, couponNo);
			
			result = ps.executeUpdate();
			
		} finally {
			DBManager.dbClose(con, ps);
		}//end finally
		
		return result;
	}

}
