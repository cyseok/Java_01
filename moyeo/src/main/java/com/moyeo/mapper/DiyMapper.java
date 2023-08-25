package com.moyeo.mapper;

import java.util.List;

import com.moyeo.dto.Diy;

public interface DiyMapper {
	int insertDiy(Diy diy);
	int updateDiy(Diy diy);
	int deleteDiy(String noticeNum);
	Diy selectDiy(String diyTitle);
	List<Diy> selectDiyList();

}
