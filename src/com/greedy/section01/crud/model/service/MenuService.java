package com.greedy.section01.crud.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.greedy.section01.crud.model.dao.MenuDAO;
import com.greedy.section01.crud.model.dto.MenuDTO;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.rollback;

/* Service 클래스에서 할 일
 * 1. Connection 생성
 * 2. DAO 호출하면서 Connection과 Controller로 부터 받은 값 전달
 * 3. 트랜젝션 제어 (단, 조회인 경우 트렌젝션 제어가 필요 없음)
 * 4. Connection 닫기
 * 5. Controller로 결과 응답*/
public class MenuService {
	
	public boolean crateNewMenu(MenuDTO menu) {
		
		Connection con = getConnection();
		
		MenuDAO menuDAO = new MenuDAO();
		int result = menuDAO.insertNewMenu(con,menu);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
					
		close(con);
		
		return result > 0? true: false;
	}

}
