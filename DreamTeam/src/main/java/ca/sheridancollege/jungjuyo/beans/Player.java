package ca.sheridancollege.jungjuyo.beans;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private int number;
    private int team;
   
    public static final String[] TEAMS = {"NC Dinos", "DOOSAN Bears", 
    		"KT Wiz", "LG Twins", "KIWOOM Heros", "KIA Tigers", "LOTTE Ziants",
    		"SAMSUNG Lions", "SSG Landers", "HANHWA Eagles"};
   
}
 