package pers.mizulk.library.pojo;

import lombok.Data;

@Data
public class Follow {
	private Integer id;
	private Integer userId;
	private Author author;
}
