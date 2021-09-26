package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Student implements Serializable {

	private static final long serialVersionUID = 366671460755550063L;

	private String name;
	private String studentId;
	private String course1;
	private String course2;
	private String course3;
	private String course4;
	private boolean regiCoop;
	private boolean fullTime;
	private boolean paidTuition;
	
	
}
