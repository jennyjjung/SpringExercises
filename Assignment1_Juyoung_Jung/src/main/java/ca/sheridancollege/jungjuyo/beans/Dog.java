package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog implements Serializable {
	
	private static final long serialVersionUID = 1919646434015536409L;
	
	private int id;
	private String name;
	private String owner;
	private String breed;
	private String gender;
	private String category;
	
}
