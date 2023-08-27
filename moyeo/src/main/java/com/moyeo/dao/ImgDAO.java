package com.moyeo.dao;

import com.moyeo.dto.Img;

public interface ImgDAO {
	int insertImg(Img img);
	Img selectImg(Img img);
}

