package model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Row {

    @Getter
    @Setter
    private List<Character> pegs=new ArrayList<>();

    public Row (List<Character> guess,List<Character> feedback){
        for (int i=0; i<guess.size();i++) {
            pegs.add(guess.get(i));
        }
        pegs.addAll(feedback);
    }




}
