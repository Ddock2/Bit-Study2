package com.bit.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.GalleryVO;

@Repository
public class GalleryDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(GalleryVO galleryVO) {
		return sqlSession.insert("gallery.insert", galleryVO);
	}
	
	public int delete(GalleryVO galleryVO) {
		return sqlSession.delete("gallery.delete", galleryVO);
	}
	
	public List<GalleryVO> getList(){
		return sqlSession.selectList("gallery.getList");
	}
}
