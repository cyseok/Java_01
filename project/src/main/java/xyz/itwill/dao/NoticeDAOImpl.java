package xyz.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.Notice;

@Repository
@RequiredArgsConstructor
public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public int insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(String notice_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Notice> selectNoticeList(String noticeTitle, String noticeContent) {
		// TODO Auto-generated method stub
		return null;
	}
}
