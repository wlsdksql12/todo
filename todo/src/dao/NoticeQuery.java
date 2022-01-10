package dao;

public class NoticeQuery {
	public static final String SELECT_NOTICE_LIST5;
	public static final String SELECT_NOTICE_ONE;
	
	static {
		SELECT_NOTICE_LIST5 = "SELECT notice_no noticeNo, notice_title noticeTitle, notice_content noticeContent, create_date createDate, update_date updateDate FROM notice ORDER BY createDate DESC LIMIT 0,5";
		SELECT_NOTICE_ONE = "SELECT notice_no noticeNo, notice_title noticeTitle, notice_content noticeContent, create_date createDate, update_date updateDate FROM notice WHERE notice_no = ?";
	}
}
