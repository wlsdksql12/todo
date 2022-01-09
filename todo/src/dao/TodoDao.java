package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Todo;

public class TodoDao {
	
	public int updateContent(Connection conn, Todo todo) throws SQLException {
		String sql = TodoQuery.UPDATE_TODO_CONTENT;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoContent());
		stmt.setString(2, todo.getMemberId());
		stmt.setInt(3, todo.getTodoNo());
		int rs = stmt.executeUpdate();
		stmt.close();
		return rs;
	}
	
	// 현재 월 모든 일정 조회
		public List<Todo> selectTodoListByMonth(Connection conn, Todo todo) throws SQLException{
			List<Todo> list = new ArrayList<Todo>();
			String sql = TodoQuery.SELECT_TODO_LIST_BY_MONTH;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, todo.getMemberId());
			stmt.setString(2, todo.getTodoDate());
			System.out.println(stmt + "TodoDao.selectTodoListByMonth");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Todo t = new Todo();
				t.setTodoDate(rs.getString("todoDate"));
				t.setTodoContent(rs.getString("todoContent5"));
				t.setFontColor(rs.getString("font_color"));
				list.add(t);
			}
			return list;
		}
	
	public int insertTodo(Connection conn, Todo todo) throws SQLException {
		String sql = TodoQuery.INSERT_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		stmt.setString(3, todo.getTodoContent());
		stmt.setString(4, todo.getFontColor());
		int row = stmt.executeUpdate();
		stmt.close();
		return row;
		
	}
	
	public List<Todo> selectTodoListByDate(Connection conn, Todo todo) throws SQLException {
		List<Todo> list = new ArrayList<Todo>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_DATE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getTodoDate());
		stmt.setString(2, todo.getMemberId());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoNo(rs.getInt("todoNo"));
			t.setTodoDate(rs.getString("todoDate"));
			t.setTodoContent(rs.getString("TodoContent"));
			t.setCreateDate(rs.getString("CreateDate"));
			t.setUpdateDate(rs.getString("UpdateDate"));
			list.add(t);
		}
		
		return list;
		
	}
	
	public void deleteTodo(Connection conn, String memberId) throws SQLException {
		String sql = TodoQuery.DELETE_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.executeUpdate();
		stmt.close();
	}
	
	public void deleteTodoContent(Connection conn, String memberId, int todoNo) throws SQLException {
		String sql = TodoQuery.DELETE_TODO_CONTENT;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.setInt(2, todoNo);
		stmt.executeUpdate();
		stmt.close();
	}
}
