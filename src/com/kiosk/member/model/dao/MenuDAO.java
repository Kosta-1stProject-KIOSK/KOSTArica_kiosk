package com.kiosk.member.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.kiosk.member.model.dto.Menu;

public interface MenuDAO {

	List<Menu> searchByCategory(int categoryNo) throws SQLException;
	
}
