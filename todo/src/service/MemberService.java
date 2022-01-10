package service;

import java.sql.Connection;
import java.sql.SQLException;

import commons.DBUtil;
import dao.MemberDao;
import dao.TodoDao;
import vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private TodoDao todoDao;
	
	public boolean removeMember(String memberId, String memberPw) {
		boolean result = false;
		Connection conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
		try {
			conn.setAutoCommit(false);
			todoDao = new TodoDao();
			memberDao = new MemberDao();
			
			todoDao.deleteTodo(conn, memberId);
			if(memberDao.deleteMember(conn, memberId, memberPw) != 1) {
				throw new Exception();
			}

			conn.commit();
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Member login(Member member) {
		System.out.println(member + "<-- MemberService.member");
		Member loginMember = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
			memberDao = new MemberDao();
			loginMember = memberDao.login(conn, member);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
	public void addMember(Member member) {
		System.out.println(member + "<-- MemberService.member");
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
			memberDao = new MemberDao();
			memberDao.addMember(conn, member);
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
}
