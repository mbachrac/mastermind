import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserClass {
    private Scanner keyboard=new Scanner(System.in);

    public void sendMessage(String message){
        System.out.println(message);
    }

    public String readUserString(){
        String name=keyboard.next();
        return name;
    }

    public String readUserString(Integer length, List<Character>choices){
        keyboard.reset();
        String key = keyboard.next().toLowerCase();
        try {
            if(key.length()!=length){
                throw new Exception();
            }
        }catch (Exception e){
            sendMessage("You did not enter a valid choice.");
            sendMessage("Please enter your response.");
            key=readUserString(length,choices);
            return key;
        }
        try {
            List<Character> list =new ArrayList<>();
            for (Character c:untangleResponse(key)) {
                if(choices.contains(c)){
                    list.add(c);
                }
            }
            if (list.size() != length) {
                throw new Exception();
            }
        }catch (Exception e){
            sendMessage("Your answer was not one of the choices.");
            key=readUserString(length,choices);
            return key;
        }
        return key;
    }


    public Integer readUserInteger(Integer max,Integer divisible){
        Integer iInput=0;
        String input= keyboard.next();
        try{
            iInput=Integer.parseInt(input);
            if(iInput>max){
                throw new Exception();
            }
            if(iInput%divisible!=0){
                throw new Exception();
            }
        }
        catch (Exception e){
            sendMessage("That is not a valid integer.");
            sendMessage("Please enter a valid integer from 1 to "+max+".");
            iInput=readUserInteger(max,divisible);
            return iInput;
        }
        return iInput;
    }

    public List<Character> untangleResponse(String input){
        List<Character> response=new ArrayList<>();
        for (char x:input.toCharArray()) {
            response.add(x);
        }
        return response;
    }
}
