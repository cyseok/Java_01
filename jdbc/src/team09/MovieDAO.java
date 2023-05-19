package team09;

import java.util.List;

public interface MovieDAO {
	
	int insertMovie(MovieDTO movie);
	
	List<MovieDTO> selectAllMovieList();
	
}