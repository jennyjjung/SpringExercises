package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Breed implements Serializable {

	private static final long serialVersionUID = -7721042654182750625L;

	private int id;
	private String name;	

}
