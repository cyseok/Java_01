package team09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl extends JdbcDAO implements MovieDAO {
	private static MovieDAOImpl _dao;

	static {
		_dao = new MovieDAOImpl();
	}

	public static MovieDAOImpl getDao() {
		return _dao;
	}

	public MovieDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MovieDTO> selectAllMovieList() {
		
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieDTO> MovieList = new ArrayList<>();

		try {
			con = getConnection();

			String sql = "select * from MOVIE_INFO order by MOVIE_NO";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 검색행이 0개 이상인 경우 반복문 사용
			while (rs.next()) {
				// 하나의 검색행을 DTO 객체로 매핑 처리
				MovieDTO movie = new MovieDTO();
				movie.setMOVIE_NO(rs.getInt("MOVIE_NO"));
				movie.setMOVIE_TITLE(rs.getString("MOVIE_TITLE"));
				movie.setMOVIE_GENRE(rs.getString("MOVIE_GENRE"));
				movie.setMOVIE_TIME(rs.getString("MOVIE_TIME"));
				movie.setMOVIE_COUNTRY(rs.getString("MOVIE_COUNTRY"));
				movie.setMOVIE_DIRECTOR(rs.getString("MOVIE_DIRECTOR"));

				// DTO 객체를 List 객체의 요소로 추가
				MovieList.add(movie);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudentList() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}

		return MovieList;
	
}
}