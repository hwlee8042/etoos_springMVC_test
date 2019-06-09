package com.etoos.study.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.etoos.study.domain.BoardVO;
import com.etoos.study.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.etoos.study.config.RootConfig.class})
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	/*
	 * @Test public void testGetList() { mapper.getList().forEach(board ->
	 * log.info(board)); }
	 * 
	 * @Test public void testInsert() { BoardVO board = new BoardVO();
	 * board.setTitle("새로 작성하는 글"); board.setContent("새로 작성하는 내용");
	 * board.setWriter("newbie");
	 * 
	 * mapper.insert(board);
	 * 
	 * log.info("========= insert board :: " + board); }
	 * 
	 * @Test public void testInsertSelectKey() { BoardVO board = new BoardVO();
	 * board.setTitle("새로 작성하는 글 select key");
	 * board.setContent("새로 작성하는 내용 select key"); board.setWriter("newbie");
	 * 
	 * mapper.insertSelectKey(board);
	 * 
	 * log.info("=========== insertSelectKey board :: " + board); }
	 * 
	 * @Test public void testRead() {
	 * 
	 * //존재하는 게시물 번호로 테스트 BoardVO board = mapper.read(5L);
	 * log.info("========= BoardVO read()" + board); }
	 * 
	 * @Test public void testDelete() { log.info("Delete COUNT : " +
	 * mapper.delete(3L)); }
	 * 
	 * @Test public void testUpdate() { BoardVO board = new BoardVO();
	 * 
	 * //실행전 존재하는 번호인지 확인할 것 board.setBno(5L); board.setTitle("수정된 제목");
	 * board.setContent("수정된 내용"); board.setWriter("user00");
	 * 
	 * int count = mapper.update(board); log.info("UPDATE COUNT : " + count); }
	 */
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		//10개씩 3페이지
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		log.info("=========== testPaging start");
		list.forEach(board -> log.info(board.getBno()));
		log.info("=========== testPaging end");
	}
	
	@Test
	public void testSearch() {
		log.info("========testSearch start");

		Criteria cri = new Criteria();
		
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
		log.info("========testSearch end");
	}
}
