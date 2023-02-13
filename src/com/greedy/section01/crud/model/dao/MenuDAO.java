package com.greedy.section01.crud.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import static com.greedy.common.JDBCTemplate.close;
import com.greedy.section01.crud.model.dto.MenuDTO;

public class MenuDAO {
	
	private Properties prop;
	
	public MenuDAO() {
		this.prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			
			
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNewMenu(Connection con, MenuDTO menu) {
		
		String query = prop.getProperty("insertMenu");
		
		System.out.println(query);
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, menu.getName());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setInt(3, menu.getCategoryCode());
			pstmt.setString(4, menu.getOrderableStatus());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

}