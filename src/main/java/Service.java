import model.Board;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.List;

public class Service {
    //this calls the methods that play the game

    public Board board=new Board();
//    public Player player1=new Player(1);
//    public Player player2=new Player(2);
    public UserClass user=new UserClass();
    public Helper helper=new Helper();
    public Viewer viewer=new Viewer();

    public void playGame(){
        Integer players=helper.doIntro();
        Integer numberOfGames=0;
        Integer max;
        List<Character>guess;
        List<Character>feedback;
        Boolean duplicates;
        String choiceDuplicates;
        user.sendMessage("How many times would you like to play?");
        user.sendMessage("If you are playing with a friend enter how many times each of you should go./nThe most is 4 times each.");
        user.sendMessage("For example if you want to each go 2 times, enter 2 and the game will run 4 times.");
        user.sendMessage("If you are playing with the computer you can play 5 games at a time at most.");
        max=players==1 ? 5:8;
        numberOfGames=user.readUserInteger(max,players);
//        for(int i=1;i<=players;i++){
//            user.sendMessage("You are player number "+i);
//            user.sendMessage("Enter your name");
//            String name=i==1?player1.setName(user.readUserString()):player2.setName(user.readUserString());
//        }
        for(int i=1;i<=numberOfGames;i++) {
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
                viewer.displayBoard(board.fillBoard(guess, feedback));
            } while ((!feedback.equals(Arrays.asList('W', 'W', 'W', 'W')) || (board.getSize() > 12)));//either they got it right or ran out of room.
            if(board.getSize()<=12) {
//                if (players == 1) {
//                    player1.setScore(player1.calculateScore(player1,board.getSize()));
//                } else {
//                    player2.setScore(player2.calculateScore(player2,board.getSize()));
//                }
            }
//            System.out.println(player2.getName()+player2.getScore());
            board.clearBoard();
            feedback.clear();
        }
    }
}
