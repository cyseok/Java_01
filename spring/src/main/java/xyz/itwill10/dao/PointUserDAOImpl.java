package xyz.itwill10.dao;
//
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.mapper.PointUserMapper;
//
@Repository//무조건 써야함
@RequiredArgsConstructor//final을 꼭 써서 인젝션 처리
public class PointUserDAOImpl implements PointUserDAO {
	//@Autowired
	//private SqlSession sqlSession;
	//위에 코드랑 다른 방법
	//
	private final SqlSession sqlSession;
	//
	@Override
	public int insertPointUser(PointUser user) {
		return sqlSession.getMapper(PointUserMapper.class).insertPointUser(user);
	}
	@Override
	public int updatePlusPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updatePlusPointUser(id);
	}
	@Override
	public int updateMinusPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).updateMinusPointUser(id);
	}
	@Override
	public PointUser selectPointUser(String id) {
		return sqlSession.getMapper(PointUserMapper.class).selectPointUser(id);
	}
}