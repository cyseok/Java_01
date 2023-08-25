package com.moyeo.mapper;

import java.util.List;

import com.moyeo.dto.Notice;

public interface NoticeMapper {
	int insertNotice(Notice notice);
	int updateNotice(Notice notice);
	int deleteNotice(String noticeNum);
	List<Notice> selectNoticeList();
}
