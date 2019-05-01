import model.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Helper {

    public UserClass user=new UserClass();
    public Board board=new Board();

//    public void setUpBoard(){
//        user.sendMessage("Enter the key:");
//        board.setKey(user.untangleResponse(user.readUserString()));
//    }
//    public void setUpBoard(String key){
//        board.setKey(key.toCharArray());
//    }

    public Integer doIntro() {
        user.sendMessage("Welcome to Mastermind!");
        user.sendMessage("Here, we have 6 letters to play with: A,B,C,D,E,F");
        user.sendMessage("Either the computer will make the code or you can have a friend play with you.");
        user.sendMessage("As you guess the key, the computer will give you clues.");
        user.sendMessage("A 'W' means that you guessed a piece right and it is in the correct spot.");
        user.sendMessage("A 'B' means that there is a peg guessed correctly, but not in the right spot.");

        user.sendMessage("Enter 1 if you are playing with the computer and 2 if you are playing with another player.");
        return user.readUserInteger();
    }

    public void playWithComputer(){
        board.setKey(generateKey());
    }

    public void playWithFriend(){
        user.sendMessage("Enter the key:");
//        Scanner keyboard=new Scanner(System.in);
//        String key=keyboard.nextLine();
        String key=user.readUserString(); //TODO:Why doesn't this work?
        board.setKey(user.untangleResponse(key));
    }

    public String generateKey(){
        // TODO: Make a random key.
        return "fadc";
    }

    public List<Character> giveFeedback(char[] guess) {
        List<Character> feedback=new ArrayList<>();
        char[]key=board.getKey();
        for(int i=0; i<4; i++){
            if ((guess[i]==key[0])||(guess[i]==key[1])||(guess[i]==key[2])||(guess[i]==key[3])){
                if(guess[i]==key[i]){
                    feedback.add('W');//W is if that peg is in the right spot.
                }
                else{
                    feedback.add('B');//B is if that peg is in the key but not in the right spot.
                }
            }
        }
        //TODO:sort the W's and B's
        //TODO:make sure that the letter that is there just in the wrong spot isn't covered already by a W.
        //I think that it isn't!
        System.out.println(feedback);
        return feedback;
    }
}
