package team09;

import java.util.List;


public interface UserDAO {
	
	// 완성
	
	// 로그인
	UserDTO selectUser(String id);
	
	// 회원가입
	int insertUser(UserDTO user);
	
	
	// 미완
	int updateUser(UserDTO user);
	
	int deleteUser(int user);

	UserDTO selectUser(int USER_NO);
	
	List<UserDTO> selectNameUserList(String USER_NAME);

	List<UserDTO> selectAllUserList();
}