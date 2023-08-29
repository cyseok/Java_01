package com.moyeo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.moyeo.dto.Img;
import com.moyeo.mapper.ImgMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ImgDAOImpl implements ImgDAO{
	private final SqlSession sqlSession;

	@Override
	public int insertImg(Img img) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ImgMapper.class).insertImg(img);
	}

	@Override
	public int deleteImg(String img) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Img selectImg(String imgIdx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Img> selectImgList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}



}
