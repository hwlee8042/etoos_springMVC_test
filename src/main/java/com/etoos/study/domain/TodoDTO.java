package com.etoos.study.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	//private Date duDate; //@InitBider를 사용할때
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
}
