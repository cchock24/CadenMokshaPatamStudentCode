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
        int position = 0;
        // ArrayList of All Snake Locations
        ArrayList<Integer> snake1 = new ArrayList<Integer>();
        //ArrayList of All Snake Destinations
        ArrayList<Integer> snake2 = new ArrayList<Integer>();
        // ArrayList of All Ladder Locations
        ArrayList<Integer> ladder1 = new ArrayList<Integer>();
        // ArrayList of All Ladder Destinations
        ArrayList<Integer> ladder2 = new ArrayList<Integer>();
        for(int i = 0; i < ladders.length; i++){
            ladder1.add(ladders[i][0]);
            ladder2.add(ladders[i][1]);
            }

        for(int i = 0; i < ladders.length; i++) {
            ladder1.add(ladders[i][0]);
            ladder2.add(ladders[i][1]);
        }

        for(int i = 0; i < snakes.length; i++) {
            snake1.add(ladders[i][0]);
            snake2.add(ladders[i][1]);
        }
        // Initialize a Board of Squares
        Square[] board = new Square[boardsize];
        for(int i = 0; i < boardsize; i++){
            // Is Ladder
            for(int x: ladder1){
                if(x == i){
                    board[i] = new Square(true,false,i, ladder2.get(i));
                }
            }
            // Is Snake
            for(int x: snake1){
                if(x == i){
                    board[i] = new Square(false,true,i, snake2.get(i));
                }
            }
            // Is Normal Space
            board[i] = new Square(i);
        }
        BFS(0,board);

        return board[boardsize-1].getVisited();
    }

    public static int BFS(int position, Square[] board){
        // Make Queue
        Queue<Square> GameSolver = new LinkedList<Square>();
        Square current = board[position];
        int turns = 0;
        while(position != 100){
            //Determine if Turns Resets or Not
            if(){

            }
            else{

            }
            if(current.isLadder){
                current = board[current.getTransport()];
            }
            if(current.isSnake){
                current = board[current.getTransport()];
            }

            position = current.getNumber();
            // Need to Determine When to Reset Turns
            current.setVisited(turns);
            //Adds Valid Squares to Queue
            for(int i = 1; i < 7; i++){
                if((position + i) < 100){
                    if(board[position+i].getVisited() > turns){
                        GameSolver.add(board[position+i]);
                    }
                }
            }
            current = GameSolver.remove();
        }
    }









    // Find the Biggest Ladder
    public int findLargerLadder(int[][] ladders){
        int largest = 0;
        int place = 0;
        for(int i = 0; i < ladders.length; i++){
            int challenger = 0;

            for(int j = 0; j < ladders[i].length; j++){
                // Calculate How Much Distance the Latter Covers
                challenger += j==0 ? ladders[i][j] : -ladders[i][j];
            }
            if(challenger > largest){
                largest = challenger;
                place = i;
            }
        }
        return place;
    }
    // Find the Closest Ladder
    public int findCloseLadder(int[][] ladders, int position) {
        int place = 0;
        boolean bool = true;
        int counter = 0;
        while (bool){
            if (ladders[counter][0] > position) {
                place = counter;
                bool = false;
            }
            counter++;
            if(counter > ladders.length){
                bool = false;
            }
        }
        return place;
    }

    // Find Distance to Next Ladder
    public int distanceToLadder(int[][] ladders, int position, int ladder){
        int distance = ladders[ladder][0] - position;
        return distance;
    }

    // Check Distance Covered by Next Ladder
    public int distance(int[][] ladders, int ladder){
        int distance = ladders[ladder+1][0] - ladders[ladder][1];
        return distance;
    }

    // Check if Space Has Snake
    public boolean Snake(int[][] snakes, int position){
        for(int i = 0; i < snakes.length; i++){
            if(position == snakes[i][0]){
                return true;
            }
        }
        return false;
    }

    //Returns an Array of Ladders Skipped
    public int[] skipped(int[][]ladders, int position, int distance){
        ArrayList<Integer> skipped = new ArrayList<Integer>();
        for(int i = 0; i < ladders.length; i++){
            if(ladders[i][0] < position + distance && ladders[i][0] > position){
                skipped.add(i);
            }
        }
        int[] skips = new int[skipped.size()];
        for(int i = 0; i < skipped.size(); i++){
            skips[i] = skipped.get(i);
        }
        return skips;
    }

}

