package com.moyeo.dao;

import java.util.List;
import java.util.Map;

import com.moyeo.dto.Img;


public interface ImgDAO {
	int insertImg(Img img);
	int deleteImg(String img);
	Img selectImg(String imgIdx);
	List<Img> selectImgList(Map<String, Object> map);
	
}

