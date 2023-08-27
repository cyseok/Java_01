package com.moyeo.dao;

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
	public Img selectImg(Img img) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ImgMapper.class).selectImg(img);
	}

}
