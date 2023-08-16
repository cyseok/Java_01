package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.Notice;

public interface NoticeMapper {
	int insertNotice(Notice notice);
	int updateNotice(Notice notice);
	int deleteNotice(String noticeNum);
	List<Notice> selectNoticeList();
}
