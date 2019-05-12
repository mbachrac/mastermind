import java.util.Arrays;

public class Controller {

    public static void main(String []args){
        Player player1=new Player(1);
        Player player2=new Player(2);
        Service service=new Service();
        UserClass user=new UserClass();
        Boolean again=false;
        do {
            service.playGame(player1,player2);
            user.sendMessage("Do you want to play again?");
            user.sendMessage("Enter 'Y' if you do and 'N' if you don't.");
            if(user.readUserString(1, Arrays.asList('y','n')).equals("y")){
                again=true;
            }
        }while (again);
    }
}
