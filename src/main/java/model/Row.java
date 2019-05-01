package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Row {

    @Getter
    @Setter
    private List<Character> pegs=new ArrayList<>();

    public Row (char[] guess,List<Character> feedback){
        for (int i=0; i<guess.length;i++) {
            pegs.add(guess[i]);
        }
//        for (char peg:feedback) {
//            pegs.add(peg);
//        }
        pegs.addAll(feedback);
    }




}
