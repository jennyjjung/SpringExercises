package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {

	private static final long serialVersionUID = -1416372411077198083L;

	private String firstName;
	private String lastName;
	private int number;
	private int kboTeam;
	
	
	public static final String[] KBOTEAMS = { "NC Dinos", "Doosan Bears", 
			"KT Wiz", "LG Twins", "KIWOOM Heros", "KIA Tigers", "SAMSUNG Lions",
			"SSG Landers", "HANHWA Eagles"};
}
