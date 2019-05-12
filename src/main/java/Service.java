import model.Board;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.List;

public class Service {
    //this calls the methods that play the game

    public Board board=new Board();
    public UserClass user=new UserClass();
    public Helper helper=new Helper();
    public Viewer viewer=new Viewer();

    public void playGame(Player player1,Player player2){
        Integer numberOfGames=0;
        Integer max;
        List<Character>guess;
        List<Character>feedback;
        Boolean duplicates;
        Integer now;
        String choiceDuplicates;
        Integer players=helper.doIntro();
        user.sendMessage("How many times would you like to play?");
        user.sendMessage("If you are playing with a friend enter how many times each of you should go.\nThe most is 4 times each which would be 8 total.");
        user.sendMessage("If you are playing with the computer you can play 5 games at a time at most.");
        max=players==1 ? 5:8;
        numberOfGames=user.readUserInteger(max,players);
        for(int i=1;i<=players;i++){
            user.sendMessage("You are player number "+i);
            user.sendMessage("Enter your name");
            if(i==1){
                player1.setName(user.readUserString());}
            else{
                player2.setName(user.readUserString());}
        }
        for(int i=1;i<=numberOfGames;i++) {
            now=(i%2==0)?2:1;//sets who is playing now.
            user.sendMessage("Enter 'T' if you want to play with duplicates or 'F' if you do not.");
            choiceDuplicates = user.readUserString(1, Arrays.asList('t', 'f'));
            duplicates = choiceDuplicates.equals("t");
            System.out.println(duplicates);
            if (players == 1) {
                helper.playWithComputer(duplicates);
            } else {
                helper.playWithFriend(duplicates);
            }
            do {

                user.sendMessage("Enter your guess:");

                guess = user.untangleResponse(user.readUserString(4, Arrays.asList('a', 'b', 'c', 'd', 'e', 'f')));
                feedback = helper.giveFeedback(guess);
                helper.clearScreen();
                viewer.displayBoard(board.fillBoard(guess, feedback));

            } while ((!feedback.equals(Arrays.asList(' ','W', 'W', 'W', 'W')) && (board.getSize() < 12)));//either they got it right or ran out of room.
            if(now==1){
                player1.findScore(player1,player2,feedback,now,board);}
            else{
                player2.findScore(player1,player2,feedback,now,board);}
            board.clearBoard();
            feedback.clear();
            helper.clearScreen();
            viewer.displayScore(player1, player2);

        }
        user.sendMessage("Yay, "+helper.findWinner(player1,player2).getName()+", you won!");
    }
}
