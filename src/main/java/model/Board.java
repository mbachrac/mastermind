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
    private List<Character> key;

    private char[] feedback;
    public char[] guess;
    @Getter
    @Setter
    private Integer size=0;

    //public void setKey(String code){
        //key=code.toCharArray();
    //}
    public void setKey(List<Character> code){
        key=code;
        System.out.println(key);
    }
    public List<Character> getKey(){
        return key;
    }

    public List<Row> fillBoard(List<Character> guess,List<Character> feedback){
        gameBoard.add(new Row(guess,feedback));
        size++;
        return gameBoard;
    }
    public void clearBoard(){
        gameBoard.clear();
    }

    //getters and setters to its state
    //controller should handle input output after being called by main
    //orchestration service could handle calling all the different loops
}
