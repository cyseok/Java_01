package xyz.itwill10.dao;
//
import java.util.List;
import xyz.itwill10.dto.PointBoard;
//
public interface PointBoardDAO {
	int insertPointBoard(PointBoard board);
	int deletePointBoard(int num);
	PointBoard selectPointBoard(int num);//단일행
	List<PointBoard> selectPointBoardList();//다중행
}