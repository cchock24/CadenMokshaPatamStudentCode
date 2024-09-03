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
        int position = 0;
        while(position != 100){

        }



        return 0;
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

}

