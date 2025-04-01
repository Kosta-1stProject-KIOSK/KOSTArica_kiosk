package com.kiosk.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kiosk.admin.model.dto.Menu;
import com.kiosk.util.DBManager;

public class MenuDAOImpl implements MenuDAO {

	
	/**
	 * 메뉴번호로 메뉴 정보 조회
	 * @param menuNo
	 * @return MenuDTO (메뉴 정보가 담긴 객체)
	 */
	@Override
	public Menu searchById(int menuNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 카테고리 번호로 해당 카테고리의 메뉴를 조회
     * @param categoryNo 카테고리 번호
     * @return 해당 카테고리의 메뉴 리스트(List)
     */
	@Override
	public List<Menu> searchByCategory(int categoryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
     * 전체 메뉴 목록 조회
     * @return 메뉴 리스트(List)
     */
	@Override
	public List<Menu> searchAll() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select menu_no, menu_name, basic_price, description, input_date, capacity,  is_active, category_name	"
				+ "from menu join category using(category_no)"; 
				
		List<Menu> list = new ArrayList<Menu>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Menu menu = new Menu(
						rs.getInt(1), 
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getString(8));
				
				list.add(menu);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}//searchAll

	
	
	/**
     * 메뉴 등록
     * @param 등록할 메뉴 정보(MenuDTO menu)
     */
	@Override
	public int insert(Menu menu) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into menu(menu_name, basic_price, description, capacity, category_no) values(?, ?, ?, ?, ?)"; 

		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, menu.getMenuName());
			ps.setInt(2, menu.getBasicPrice());
			ps.setString(3, menu.getDescription());
			ps.setInt(4, menu.getCapacity());
			ps.setInt(5, menu.getCategoryNo());
			
			result = ps.executeUpdate();
			
		} finally {
			DBManager.dbClose(con, ps);
		}//end finally
		
		return result;
	}//insert

	
	
	/**
     * 메뉴 정보 수정
     * @param 수정할 메뉴 정보 객체(MenuDTO menu)
     */
	@Override
	public int update(Menu menu) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update menu	"
				+ "set basic_price = ?, description = ?, capacity = ?	"
				+ "where menu_no = ?"; 

		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, menu.getBasicPrice());
			ps.setString(2, menu.getDescription());
			ps.setInt(3, menu.getCapacity());
			ps.setInt(4, menu.getMenuNo());
			
			result = ps.executeUpdate();
			
		} finally {
			DBManager.dbClose(con, ps);
		}//end finally
		
		return result;
		
	}

	
	
	/**
     * 메뉴 삭제
     * @param menuNo 삭제할 메뉴 번호
     */
	@Override
	public int delete(int menuNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from menu	"
				+ "where menu_no = ?"; 

		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, menuNo);
			
			result = ps.executeUpdate();
			
		} finally {
			DBManager.dbClose(con, ps);
		}//end finally
		
		return result;
	}
	
	////////////////////////////전체 메인 화면 용//////////////////////////
	
	/**
     * 신메뉴명 3개 조회
     */
	@Override
	public List<String> searchNewMenu() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select menu_name	"
				+ "from menu	" 
				+ "order by input_date desc limit 3 ";
				
		List<String> list = new ArrayList<String>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
					String menu = rs.getString(1);
				list.add(menu);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}//searchNewMenu
	
	/**
     * 베스트 메뉴명 3개 조회
     */
	@Override
	public List<String> searchBestMenu() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT m.menu_name, SUM(od.quantity) AS total_quantity	"
				+ "FROM order_detail od	" 
				+ "JOIN menu m ON od.menu_no = m.menu_no	" 
				+ "GROUP BY m.menu_no, m.menu_name	" 
				+ "ORDER BY SUM(od.quantity) DESC	LIMIT 3";
				
		List<String> list = new ArrayList<String>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
					String menu = rs.getString(1);
				list.add(menu);
			}//end while
			
		} finally {
			DBManager.dbClose(con, ps, rs);
		}//end finally
		
		return list;
	}//searchBestMenu

}
