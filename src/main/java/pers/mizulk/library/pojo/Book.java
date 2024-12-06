package pers.mizulk.library.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
	private Integer id;
	private String name;
	private String publisher;
	private String brief;
	private Integer comments;
	private Integer collect;
	private Integer likes;
	private String type;
	private String img;
	private Integer views;
	private Integer share;
	private Float price;
	private Author author;
}
