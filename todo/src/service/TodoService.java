package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	public void deleteTodoList(String memberId, int todoNo) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			todoDao.deleteTodoContent(conn, memberId, todoNo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean updateContent(Todo todo) {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			int rs = todoDao.updateContent(conn, todo);
			// rs가 1이면 result를 ture로 변경 (0이면 실패 1이면 성공)
			if(rs == 1) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean addTodo(Todo todo) {
		boolean result = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			int rs = todoDao.insertTodo(conn, todo);
			// rs가 1이면 result를 ture로 변경 (0이면 실패 1이면 성공)
			if(rs == 1) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<Todo> getTodoListByDate(Todo todo) {
		List<Todo> list = new ArrayList<>();
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
			todoDao = new TodoDao();
			list = todoDao.selectTodoListByDate(conn, todo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
