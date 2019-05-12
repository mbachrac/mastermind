import lombok.Getter;
import lombok.Setter;

public class Player {
    public UserClass user=new UserClass();
    @Getter
    @Setter
    private String name;
    public String setName(String name){
        this.name=name;
        return name;
    }
    @Getter
    @Setter
    private Integer score;
    public Integer setScore(Integer score){
        return this.score=score;
    }
    @Getter
    @Setter
    private Integer id;
    public Player (Integer id){
        setId(id);
    }
    public Integer calculateScore(Player player,Integer boardSize){
        user.sendMessage("Yay, " + player.getName() + " you got it!!");//TODO:tally up the points
        return player.getScore()+12-boardSize;
    }
}
