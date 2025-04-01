package com.kiosk.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kiosk.member.model.dto.Menu;
import com.kiosk.util.DBManager;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<Menu> searchByCategory(int categoryNo) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT menu_no, menu_name, basic_price, category_name, description " +
                "FROM menu JOIN category ON menu.category_no = category.category_no " +
                "WHERE menu.category_no = ? AND is_active = 1";
		
        List<Menu> list = new ArrayList<>();
        
        try {
        	con = DBManager.getConnection();
        	ps = con.prepareStatement(sql);
            ps.setInt(1, categoryNo);
            rs = ps.executeQuery();

            while (rs.next()) {
                Menu menu = new Menu(
                    rs.getInt("menu_no"),
                    rs.getString("menu_name"),
                    rs.getInt("basic_price"),
                    rs.getString("description"),
                    rs.getString("category_name")
                );
                list.add(menu);
            }
        	
        }finally {
        	DBManager.dbClose(con, ps, rs);
        }
		
		return list;
	}//searchByCategory

}
