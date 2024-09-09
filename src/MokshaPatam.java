import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    // Steps
    // 1) Find Closest Ladder
    // 2) Find How Many Moves to Make it to Ladder (While Avoiding Snakes)
    // 3) Check if Ladder is Worth it (Distance per Moves and what Ladders Missing)
    // 4) Repeat Until End
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
       // Set Up Board
        int position = 1;
        // ArrayList of All Snake Locations
        ArrayList<Integer> snake1 = new ArrayList<Integer>();
        //ArrayList of All Snake Destinations
        ArrayList<Integer> snake2 = new ArrayList<Integer>();
        // ArrayList of All Ladder Locations
        ArrayList<Integer> ladder1 = new ArrayList<Integer>();
        // ArrayList of All Ladder Destinations
        ArrayList<Integer> ladder2 = new ArrayList<Integer>();
        //
        for(int i = 0; i < ladders.length; i++){
            ladder1.add(ladders[i][0]);
            ladder2.add(ladders[i][1]);
            }
        for(int i = 0; i < snakes.length; i++) {
            snake1.add(snakes[i][0]);
            snake2.add(snakes[i][1]);
        }
        // Initialize a Board of Squares
        Square[] board = new Square[boardsize+1];
        int numb = 0;
        for(int i = 1; i < boardsize+1; i++){
            numb = 0;
            // Is Ladder
            for(int j = 0; j < ladder1.size(); j++){
                if(i == (ladder1.get(j))){
                    board[i] = new Square(true,false,i, ladder2.get(j));
                    numb = 1;
                }
            }
            // Is Snake
            for(int j = 0; j < snake1.size(); j++){
                if(snake1.get(j) == i){
                    board[i] = new Square(false,true,i, snake2.get(j));
                    numb = 1;
                }
            }
            // Is Normal Space
            if(numb == 0){
                board[i] = new Square(i);
            }
        }
        return BFS(position,board,boardsize);
    }
// Breadth First Search
    public static int BFS(int position, Square[] board, int boardsize){
        // Make Queue
        Queue<Square> gameSolver = new LinkedList<Square>();
        Square current = board[position];
        int turns = 1;
        current.setVisited(0);
        while(position != boardsize){
            // Checks if Space is Snake or Ladder, Moves to the Resulting Space
            if(current.isLadder){
                board[current.getTransport()].setVisited(current.getVisited());
                current = board[current.getTransport()];
            }
            if(current.isSnake){
                board[current.getTransport()].setVisited(current.getVisited());
                current = board[current.getTransport()];
            }
            // Sets Position and Turns to the Current one
            position = current.getNumber();
            turns = current.getVisited();
            //Adds Valid Squares to Queue
            for(int i = 1; i < 7; i++){
                if((position + i) <= boardsize && board[position+i].getVisited() == 0){
                    gameSolver.add(board[position+i]);
                    board[position+i].setVisited(turns+1);
                }
            }
            // If Code Goes Through The Entire Board Return -1
            if(gameSolver.isEmpty()){
                return -1;
            }
            current = gameSolver.remove();
            position = current.getNumber();
            System.out.println(current.getNumber());
            // Return Answer
            if(position == boardsize){
                return board[boardsize].getVisited();
            }
        }
        return board[boardsize].getVisited();
    }
}

