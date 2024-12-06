package pers.mizulk.library.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cart {
	private Integer id;
	private Integer userId;
	private Book book;
	private Integer count;
	private Byte checked;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
}
