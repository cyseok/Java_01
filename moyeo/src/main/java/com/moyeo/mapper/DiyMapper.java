package com.moyeo.mapper;

import java.util.List;

import com.moyeo.dto.Diy;

public interface DiyMapper {
	int insertDiy(Diy diy);
	int updateDiy(Diy diy);
	int deleteDiy(int diyIdx);
	
	// DIY 작성 디테일 페이지
	Diy selectDiy(int diyIdx);
	
	// 전체 글 검색
	List<Diy> selectDiyList();
	
	// 제목으로 글 검
	List<Diy> selectDiyList(String diyTitle);
	
	// *** 내용으로 검색도 추가하기 
	
	// 전체 글 개수 
	int selectDiyListCount();
	
	// *** 맵 추가하기
	
	// String userinfo, Userinfo userinfo
	
	// String id => 아이디 컬럼 하나만 가져와서 다른 테이블 아이디 where로 사용할수있게하고
		// 				User user로 다 가져오면모든걸 쓸수있음..?
	
}
