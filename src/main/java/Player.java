import lombok.Getter;
import lombok.Setter;
import model.Board;

import java.util.Arrays;
import java.util.List;

public class Player {
    @Getter
    @Setter
    private String name;
    public String setName(String name){
        this.name=name;
        return name;
    }
    @Getter
    @Setter
    private Integer score=0;
    public Integer getScore(){
        return this.score;
    }
    public void setScore(Integer score){
        this.score=score;
    }
    @Getter
    @Setter
    private Integer id;
    public Player (Integer id){
        setId(id);
    }

    public Integer findScore(Player player1, Player player2, List<Character> feedback, Integer now, Board board){
        if(feedback.equals(Arrays.asList(' ','W', 'W', 'W', 'W'))) {
            this.setScore(this.getScore()+(13-(board.getSize())));
        }
        else {
            if (now == 1) {
                player2.setScore(player1.getScore()+1);
            } else {
                player1.setScore(player2.getScore()+1);
            }
        }
        return this.getScore();
    }
}
