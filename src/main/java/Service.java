import model.Board;

import java.util.Arrays;
import java.util.List;

public class Service {
    //this calls the methods that play the game

    public Board board=new Board();
    public UserClass user=new UserClass();
    public Helper helper=new Helper();
    public Viewer viewer=new Viewer();

    public void playGame(){
        Integer players=helper.doIntro();
        char[]guess;
        List<Character>feedback;
        if(players==1){ helper.playWithComputer(); }
        else{ helper.playWithFriend(); }

        do{
            user.sendMessage("Enter your guess:");
            guess=user.untangleResponse(user.readUserString());
            feedback=helper.giveFeedback(guess);
            viewer.displayBoard(board.fillBoard(guess,feedback));

        }while(!feedback.equals(Arrays.asList('W','W','W','W')));
    }
}
