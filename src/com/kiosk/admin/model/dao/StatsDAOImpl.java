package com.kiosk.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kiosk.admin.model.dto.Stats;
import com.kiosk.util.DBManager;

public class StatsDAOImpl implements StatsDAO {
	
	/**
	 * 메뉴 판매수 통계 조회 (일간)
	 */
	@Override
	public List<Stats> menuSalesDaily() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from menu_sales_daily"; 
				
		List<Stats> list = new ArrayList<Stats>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Stats stats = new Stats(rs.getInt(1), rs.getString(2), rs.getInt(3));
				
				list.add(stats);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}
	
	/**
	 * 제품 판매수 통계 조회 (주간)
	 */
	@Override
	public List<Stats> menuSalesWeekly() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from menu_sales_weekly"; 
				
		List<Stats> list = new ArrayList<Stats>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Stats stats = new Stats(rs.getInt(1), rs.getString(2), rs.getInt(3));
				
				list.add(stats);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}
	
	/**
	 * 제품 판매수 통계 조회 (월간)
	 */
	@Override
	public List<Stats> menuSalesMonthly() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from menu_sales_monthly"; 
				
		List<Stats> list = new ArrayList<Stats>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Stats stats = new Stats(rs.getInt(1), rs.getString(2), rs.getInt(3));
				
				list.add(stats);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}
	
	/**
	 * 시간별 주문수 통계 조회 (일간)
	 */
	public List<Stats> salesTimeDaily() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sales_time_daily"; 
				
		List<Stats> list = new ArrayList<Stats>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Stats stats = new Stats(rs.getInt(1), rs.getInt(2));
				
				list.add(stats);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}
	
	/**
	 * 시간별 주문수 통계 조회 (주간)
	 */
	public List<Stats> salesTimeWeekly() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from sales_time_weekly"; 
				
		List<Stats> list = new ArrayList<Stats>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Stats stats = new Stats(rs.getInt(1), rs.getInt(2));
				
				list.add(stats);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}

	
	
	/**
     * 가장 많이 판매된 상위 N개의 메뉴 조회
     * @param limit (상위 개수 제한)
     * @return 인기 메뉴 리스트
     */
	@Override
	public List<Stats> getTopMenus(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
	 * 전체 총 매출 금액 반환
	 * @return 총 매출 금액
	 */
	@Override
	public Stats getTotalSales() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Stats stats = null; //초기에 null로 설정
		
		String sql = "select * from total_sales";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				stats = new Stats(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			}//end if

		} finally {
			DBManager.dbClose(con, ps, rs);
		} // end finally

		return stats;
	}
	
	/**
	 * 지난 매출 비교 통계 조회 (주간)
	 */
	public Stats salesCompareWeekly() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Stats stats = null; //초기에 null로 설정
		
		String sql = "select * from sales_compare_weekly";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				stats = new Stats(rs.getInt(1), rs.getInt(2));
			}//end if

		} finally {
			DBManager.dbClose(con, ps, rs);
		} // end finally

		return stats;
	}
	
	
	/**
	 * 지난 매출 비교 통계 조회 (월간)
	 */
	public Stats salesCompareMonthly() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Stats stats = null; //초기에 null로 설정
		
		String sql = "select * from sales_compare_monthly";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				stats = new Stats(rs.getInt(1), rs.getInt(2));
			}//end if

		} finally {
			DBManager.dbClose(con, ps, rs);
		} // end finally

		return stats;
	}
	
	
	/**
     * 전체 주문 수를 반환합니다.
     * @return 총 주문 수
     */
	@Override
	public int getTotalOrders() {
		// TODO Auto-generated method stub
		return 0;
	}

}
