package pers.mizulk.library.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Author implements Serializable {
	private Integer id;
	private String name;
	private String brief;
	private String img;
}
