package com.etoos.study.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
	  
	private String type;
	private String keyword;
	
	public Criteria() {
	  this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
	  this.pageNum = pageNum;
	  this.amount = amount;
	}
	  
	//T,W,C 로 구성되어 배열로 만들어서 한번에 처리
	public String[] getTypeArr() {
	   return type == null? new String[] {}: type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
	}
	  
	  
}
