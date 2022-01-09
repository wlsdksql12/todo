package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import commons.DBUtil;
import dao.NoticeDao;
import vo.Notice;

public class NoticeService {
   private NoticeDao noticeDao;
   
   public List<Notice> getNoticeList5(){
      List<Notice> list = null;
      Connection conn = null;
      
      try {
         conn = DBUtil.getConnection("jdbc:mariadb://52.79.93.109:3306/todo", "root", "java1004");
         noticeDao = new NoticeDao();
         list = noticeDao.selectNoticeList5(conn);
         System.out.println("공지사항 출력 완료");
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("공지사항 출력 실패");
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