package xyz.itwill.dao;

import java.util.List;

import xyz.itwill.dto.Notice;

	public interface NoticeDAO {
		int insertNotice(Notice notice);
		int updateNotice(Notice notice);
		int deleteNotice(String noticeNum);
		List<Notice> selectNoticeList(String noticeTitle, String noticeContent);
	}

