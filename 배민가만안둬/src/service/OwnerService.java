package service;

import java.util.*;
import java.sql.*;
import static common.JDBCTemplate.*;

import model.dao.OwnerDAO;
import model.dto.MenuDTO;
import model.dto.OwnerDTO;

public class OwnerService {
	private OwnerDAO ownerDAO = new OwnerDAO();

	public List<OwnerDTO> selectAllOwner() {
		Connection con = getConnection();
		
		List<OwnerDTO> ownerList = ownerDAO.selectAllOwner(con);
		
		close(con);
		
		return ownerList;
	}

	public OwnerDTO login(String id, String pwd) {
		Connection con = getConnection();
		
		OwnerDTO owner = ownerDAO.login(con, id);
		
		close(con);
		
		return owner;
	}

	public int signup(String id, String pwd) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.signup(con, id, pwd);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
		
		return result;
	}

	public int updatePassword(String id, String inputPwd) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.updatePassword(con, id, inputPwd);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int createMenu(MenuDTO menu) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.createMenu(con, menu);
		
		if(result >0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteMenu(String menuName, String id) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = ownerDAO.deleteMenu(con, menuName, id);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
