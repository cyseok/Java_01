package xyz.itwill.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.Notice;
import xyz.itwill.mapper.NoticeMapper;

@Repository
@RequiredArgsConstructor
public class NoticeDAOImpl implements NoticeDAO {
	private final SqlSession sqlSession;

	@Override
	public int insertNotice(Notice notice) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).insertNotice(notice);
	}

	@Override
	public int updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).updateNotice(notice);
	}

	@Override
	public int deleteNotice(String noticeNum) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).deleteNotice(noticeNum);
	}

	@Override
	public List<Notice> selectNoticeList() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).selectNoticeList();
	}
}
