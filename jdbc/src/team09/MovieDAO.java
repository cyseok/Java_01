package team09;

import java.util.List;

public interface MovieDAO {
	
	int insertMovie(MovieDTO movie);
	
	int deleteMovie(int movie);
	
	List<MovieDTO> selectAllMovieList();
	
}