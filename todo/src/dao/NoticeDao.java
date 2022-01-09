package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Notice;

public class NoticeDao {
   public List<Notice> selectNoticeList5(Connection conn) throws SQLException{
      List<Notice> list = new ArrayList<>();
      String sql = NoticeQuery.SELECT_NOTICE_LIST5;
      PreparedStatement stmt = conn.prepareStatement(sql);
      System.out.println(stmt + "NoticeDao.selectNoticeList5");
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
         Notice notice = new Notice();
         notice.setNoticeNo(rs.getInt("noticeNo"));
         notice.setNoticeTitle(rs.getString("noticeTitle"));
         notice.setCreateDate(rs.getString("createDate"));
         list.add(notice);
      }
      rs.close();
      stmt.close();
      return list;
   }
}