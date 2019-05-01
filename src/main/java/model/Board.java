package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Board {
    @Getter
    @Setter
    private List<Row> gameBoard=new ArrayList<>();
    @Getter
    @Setter
    private char[] key;
    @Getter
    @Setter
    private char[] feedback;
    public char[] guess;
    private Integer size=0;

    public void setKey(String code){
        key=code.toCharArray();
    }
    public void setKey(char[] code){
        key=code;
    }
    public char[] getKey(){
        return key;
    }

    public List<Row> fillBoard(char[] guess,List<Character> feedback){
        gameBoard.add(new Row(guess,feedback));
        size++;
        return gameBoard;
    }

    //getters and setters to its state
    //controller should handle input output after being called by main
    //orchestration service could handle calling all the different loops
}
