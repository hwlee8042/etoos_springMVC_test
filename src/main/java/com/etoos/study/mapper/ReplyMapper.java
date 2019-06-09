package com.etoos.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoos.study.domain.Criteria;
import com.etoos.study.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(Long bno);

	public int delete(Long bno);
	
	public int update(ReplyVO reply);
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	//댓글 갯수 파악
	public int getCountByBno(Long bno);
}
