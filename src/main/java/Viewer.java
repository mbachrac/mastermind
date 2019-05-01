import model.Board;
import model.Row;

import java.util.List;

public class Viewer {
    //the board should not know how to print itself
    //pass in the board and it is void


    public void displayBoard(List<Row> board){
        for (int i=0; i<board.size();i++){
            for (Character peg:board.get(i).getPegs()) {
                System.out.print(peg);
            }
            System.out.println();
        }
    }
}
