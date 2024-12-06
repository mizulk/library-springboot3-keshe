package pers.mizulk.library.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubComment {
	private Integer id;
	private Integer commentId;
	private String content;
	private LocalDateTime createTime;
	private Integer like;
}
