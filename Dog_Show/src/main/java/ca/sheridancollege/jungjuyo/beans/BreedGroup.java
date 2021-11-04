package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreedGroup implements Serializable {
	
	private static final long serialVersionUID = 5760563510663783397L;

	private String breed;
	private int maleClass;
	private int femaleClass;
	private int maleSpecialty;
	private int femaleSpecialty;
	
	private int total;
	private String format;
	
	public BreedGroup(String breed, int maleClass, int femaleClass, int maleSpecialty, int femaleSpecialty) {
		super();
		this.breed = breed;
		this.maleClass = maleClass;
		this.femaleClass = femaleClass;
		this.maleSpecialty = maleSpecialty;
		this.femaleSpecialty = femaleSpecialty;
		
		total = maleClass + femaleClass + maleSpecialty + femaleSpecialty;
		format = maleClass + "-" + femaleClass + "-" + maleSpecialty
				+ "-" + femaleSpecialty;
	}
	
	
}
