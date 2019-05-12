import model.Board;

import javax.print.DocFlavor;
import java.util.*;


public class Helper {

    public UserClass user=new UserClass();
    public Board board=new Board();
    public Player player1=new Player(1);
    public Player player2=new Player(2);

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
        Integer players= user.readUserInteger(2,1);

        return players;
    }

    public void playWithComputer(Boolean duplicates){
        board.setKey(generateKey(duplicates));
    }

    public void playWithFriend(Boolean duplicates){
        Boolean isThere;
        String key;
        //Scanner keyboard = new Scanner(System.in);
        user.sendMessage("Enter the key:");
        //key=keyboard.nextLine();
            do {
                isThere = false;
                key = user.readUserString(4, Arrays.asList('a','b','c','d','e','f'));
                if(duplicates){
                    continue;//if doesn't work use break
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j < 4; j++) {//starts at 1 because it is comparing 0 and 1.
                        if (j != i && key.toCharArray()[i] == key.toCharArray()[j]) {
                            isThere = true;
                        }
                    }
                }
//            for (char k : key.toCharArray()) {
//                isThere = checkDuplicates(duplicates, user.untangleResponse(key), k);
//            }
                if (isThere) {
                    user.sendMessage("One of your letters in the key was there two times and you did not want to play with duplicates.");
                    user.sendMessage("So please type in a new key without duplicates this time.");
                }
            } while (isThere);

        //String key=user.readUserString(); //TODO:Why doesn't this work? It didn't go because it was nextLine()

        board.setKey(user.untangleResponse(key));
        clearScreen();
    }
    public static void clearScreen() {
        for(int i=0;i<35;i++){
            System.out.println();
        }
    }

    public List<Character> generateKey(Boolean duplicates){
        Random rand=new Random();
        Boolean isThere;
        Integer keyPart;
        Character  k;
        List<Character> key=new ArrayList<>();
        for(int i=0;i<4;i++){
            keyPart=rand.nextInt(5);
            k = getCharacter(keyPart);
            isThere=checkDuplicates(duplicates,key,k);
            if(isThere){
                i--;
            }
            else{
                key.add(k);
            }
            //if(!duplicates) {
//                if (!key.contains(k)) {
//                    key.add(k);
//                } else {//if no duplicates and that letter is already in the key, don't put it in and make i less.
//                    i--;
//                }
//            }
//            else{key.add(k);}
        }
        return key;
    }

    private Character getCharacter(Integer keyPart) {
        switch (keyPart){
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            default:
                return ' ';
        }
    }

    public Boolean checkDuplicates(boolean duplicates, List<Character> key, char k) {
        Boolean isThere=false;
        if(!duplicates) {//if the player does not want duplicates,
            if (key.contains(k)) {//if that letter is there already,
                isThere=true;
            }
        }
    return isThere;
    }

    public List<Character> giveFeedback(List<Character> guess) {
        List<Character> feedback=new ArrayList<>();
        List<Character> key=board.getKey();
        List<Character> keyCopy1 = createCopy(key);

        for(int i=0; i<4; i++){
                if(guess.get(i)==key.get(i)){
                    feedback.add('W');//W is if that peg is in the right spot.
                    keyCopy1.remove(i);
                    keyCopy1.add(i,' ');
                }
        }
        for(Character c:guess){
            if(keyCopy1.contains(c)){//if the copy still has it even after all the exact matches were found,
                feedback.add('B');//add it to the feedback
                keyCopy1.remove(c);//and then remove it from the copy so that it can't be used again.
            }
        }
        //TODO:sort the W's and B's => this happened when I did the next todo
        //TODO:make sure that the letter that is there just in the wrong spot isn't covered already by a W.
        // =>use a tracking object to see what to come back to that wasn't a perfect match==>it worked!!

        System.out.println(feedback);
        return feedback;
    }

    private List<Character> createCopy(List<Character>key) {
        List<Character>keyCopy=new ArrayList<>();
        keyCopy.addAll(key);
        return keyCopy;
    }
}
