package com.moyeo.dao;

import java.util.List;

import com.moyeo.dto.Notice;


public interface NoticeDAO {
	int insertNotice(Notice notice);
	int updateNotice(Notice notice);
	int deleteNotice(String noticeNum);
	List<Notice> selectNoticeList();
}

