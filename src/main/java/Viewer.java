import model.Board;
import model.Row;

import java.util.List;

public class Viewer {
    //the board should not know how to print itself
    //pass in the board and it is void


    public void displayBoard(List<Row> board){
        for (int i=0; i<board.size();i++){
            System.out.print((i+1)+") ");
            for (Character peg:board.get(i).getPegs()) {
                System.out.print(peg.toString().toUpperCase());
            }
            System.out.println();
        }
    }
    public void displayScore(Player player1,Player player2){
        if(player2.getName()==null){
            player2.setName("computer");
        }
        System.out.println(player1.getName()+ "  "+player1.getScore());
        System.out.println(player2.getName()+ "  "+player2.getScore());
    }
}
