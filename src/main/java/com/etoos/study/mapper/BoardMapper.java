package com.etoos.study.mapper;

import java.util.List;

import com.etoos.study.domain.BoardVO;
import com.etoos.study.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	//Criteria타입을 파라미터로 사용하는 매소드
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//단순히 seq 다음값을 구해서 insert에 사용
	public void insert(BoardVO board);
	
	//seq조회 후 insert
	public void insertSelectKey(BoardVO board);
	
	//BoardVO 클래스의 bno타입 정보를 이용해서 처리
	public BoardVO read(Long bno);
	
	//Delete처리
	public int delete(Long bno);
	
	//Update처리
	public int update(BoardVO board);
	
	//total
	public int getTotalCount(Criteria cri);
	
	
}
