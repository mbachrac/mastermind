import java.util.Scanner;

public class UserClass {

    public void sendMessage(String message){
        System.out.println(message);
    }
    private Scanner keyboard=new Scanner(System.in);

    public String readUserString(){
        keyboard.reset();
        String key= keyboard.nextLine();
        return key;
    }

    public Integer readUserInteger(){
        return keyboard.nextInt();
    }

    public char[] untangleResponse(String input){
        return input.toCharArray();
    }
}
