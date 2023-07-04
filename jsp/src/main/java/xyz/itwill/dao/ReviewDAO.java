package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.ReviewDTO;

public class ReviewDAO extends JdbcDAO{
	private static ReviewDAO _dao;
	
	private ReviewDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ReviewDAO();
	}
	
	public static ReviewDAO getDAO() {
		return _dao;
	}
	
	//=====================================================================================
	// review 테이블에 저장된 게시글 중 검색 처리된 전체 게시글의 개수를 검색하여 반환하는 메소드
	public int selectReviewCount(String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count = 0;
		try {
			con=getConnection();
			
			if(keyword.equals("")) {  // 게시글 검색기능을 사용하지 않은 경우
				String sql="select count(*) from review";
				pstmt=con.prepareStatement(sql);
			} else {  // search : 컬럼명
				String sql="select count(*) from review join member on review.id=member.id where "
						+search+" like '%'||?||'%' and status <> 0";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
			}

 			rs=pstmt.executeQuery();
			
			if(rs.next()) {	
				count = rs.getInt(1);
			}
 		} catch (SQLException e) {
			System.out.println("[에러]selectRiviewCount() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return count;
	}
	
	//=====================================================================================
	// 페이징 처리관련 정보와 게시글 검색 기능 관련 정보를 전달하여 review 테이블에 저장된
	//  게시글 목록을 검색하여 List 객체로 반환하는 메소드
	public List<ReviewDTO> selectReviewList(int startRow, int endRow, String search, String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ReviewDTO> reviewList = new ArrayList<>();
		
		try {
			con=getConnection();
			
			if(keyword.equals("")) {  // 게시글 검색기능을 사용하지 않은 경우
				
				/*  페이징 처리를 위해선 SQL에서 했던 인라인뷰에 RANKING과 같은 번호를 하나더 만듬
				EMP 테이블의 모든 사원중 급여를 6번째 ~ 10번째로 많이 받는 사원
				SELECT * FROM  (SELECT ROWNUM "RANKING", TEMP.* FROM 
					    (SELECT EMPNO, ENAME, SAL FROM EMP ORDER BY SAL DESC) TEMP)
					    WHERE RANKING BETWEEN 6 AND 10;
				*/
				String sql="select * from (select rownum rn, temp.* from (select num, reviewid"
						+ ", name, subject, content, reviewimg, regdate, readcount, ref, restep"
						+ ", relevel,ip, status from review join member on reviewid=id order by"
						+ " ref desc, restep) temp) where rn between ? and ?";
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					
				} else {//게시글 검색 기능을 사용한 경우
					String sql="select * from (select rownum rn, temp.* from (select num, reviewid"
						+ ", name, subject, content, reviewimg, regdate, readcount, ref, restep"
						+ ", relevel,ip, status from review join member on reviewid=id where "
						+ search + " like '%'||?||'%' and status <> 0 order by ref desc, restep)"
						+ " temp) where rn between ? and ?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, keyword);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
				}

 			rs=pstmt.executeQuery();
			
 			
 			while(rs.next()) {
				ReviewDTO review=new ReviewDTO();
				review.setNum(rs.getInt("num"));
				review.setReviewid(rs.getString("reviewid"));
				review.setName(rs.getString("name"));
				review.setSubject(rs.getString("subject"));
				review.setContent(rs.getString("content"));
				review.setReviewimg(rs.getString("reviewimg"));
				review.setRegdate(rs.getString("regdate"));
				review.setReadcount(rs.getInt("readcount"));
				review.setRef(rs.getInt("ref"));
				review.setRestep(rs.getInt("restep"));
				review.setRelevel(rs.getInt("relevel"));
				review.setIp(rs.getString("ip"));
				review.setStatus(rs.getInt("status"));
				reviewList.add(review);
			}
 			
 		} catch (SQLException e) {
			System.out.println("[에러]selectReviewList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return reviewList;
		
	}
	
	//=====================================================================================
	// review_SEQ 시퀀스의 다음값을 검색하여 반환하는 메소드
	public int selectNetNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int nextNum=0;
		
		try {
			con=getConnection();
			
			String sql = "select review_seq.nextval from dual";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {	
					nextNum = rs.getInt(1);
				}
					
		} catch (SQLException e) {
			System.out.println("[에러]selectNetNum() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return nextNum;
		
	}
	
	//=====================================================================================
	//게시글정보를 전달받아 REVIEW 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertReview(ReviewDTO review) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql = "insert into review values(?,?,?,?,?,sysdate,0,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, review.getNum());
				pstmt.setString(2, review.getReviewid());
				pstmt.setString(3, review.getSubject());
				pstmt.setString(4, review.getContent());
				pstmt.setString(5, review.getReviewimg());
				pstmt.setInt(6, review.getRef());
				pstmt.setInt(7, review.getRestep());
				pstmt.setInt(8, review.getRelevel());
				pstmt.setString(9, review.getIp());
				pstmt.setInt(10, review.getStatus());
				
				rows = pstmt.executeUpdate();
				
		} catch (SQLException e) {
			System.out.println("[에러]insertReview() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	//=====================================================================================
	// 부모글 관련 정보를 전달받아 review 테이블의 restep 컬럼의 값을 변경하고 변경 행 개수 반환
	public int updateRestep(int ref, int restep) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="update review set restep=restep+1 where ref=? and restep>?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, restep);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateRestep() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//=====================================================================================
	// 글 번호를 전달받아 review 테이블에 저장된 게시글을 검색하여 DTO 객체로 반환하는 메소드
	public ReviewDTO selectReview(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ReviewDTO review = null;
		
		try {
			con=getConnection();
			
			String sql="select num, reviewid, name, subject, content, reviewimg, redate"
						+ ", readcount, ref, restep, relevel, ip, status from review join member"
						+ " on reviewid=id where num=? and status<>0";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				review=new ReviewDTO();
				review.setNum(rs.getInt("num"));
				review.setReviewid(rs.getString("reviewid"));
				review.setName(rs.getString("name"));
				review.setSubject(rs.getString("subject"));
				review.setContent(rs.getString("content"));
				review.setReviewimg(rs.getString("reviewimg"));
				review.setRegdate(rs.getString("regdate"));
				review.setReadcount(rs.getInt("readcount"));
				review.setRef(rs.getInt("ref"));
				review.setRestep(rs.getInt("restep"));
				review.setRelevel(rs.getInt("relevel"));
				review.setIp(rs.getString("ip"));
				review.setStatus(rs.getInt("status"));
				
			}
			
		} catch (SQLException e) {
			System.out.println("[에러]selectRiview() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return review;
	}
	
	//=====================================================================================
	// 글번호를 전달받아 review 테이블에 저장된 게시글의 조회수를 1 증시시키고 변경 행의 개수를 반환
	public int updateReadcount(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="update review set readcount=readcount+1 where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateReadcount() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//=====================================================================================
	// 게시글을을 변경하고 변경행 개수 반환
	public int updateReview(ReviewDTO review) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			//동적 SQL 기능을 사용하여 컬럼값 변경을 다르게 설정 
			if(review.getReviewimg()!=null) {
				String sql="update review set subject=?,content=?,reviewimg=?,status=? where num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, review.getSubject());
				pstmt.setString(2, review.getContent());
				pstmt.setString(3, review.getReviewimg());
				pstmt.setInt(4, review.getStatus());
				pstmt.setInt(5, review.getNum());
			} else {
				String sql="update review set subject=?,content=?,status=? where num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, review.getSubject());
				pstmt.setString(2, review.getContent());
				pstmt.setInt(3, review.getStatus());
				pstmt.setInt(4, review.getNum());
			}
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateReView() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
		
	}
}





















