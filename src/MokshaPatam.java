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
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        // Find the Biggest Ladder
        int largest = 0;
        for(int i = 0; i < ladders.length; i++){
            int challenger = 0;
            int place = 0;
            for(int j = 0; j < ladders[i].length; j++){
                // Calculate How Much Distance the Latter Covers
                challenger += j==0 ? ladders[i][j] : -ladders[i][j];
            }
            if(challenger > largest){
                largest = challenger;
                place = i;
            }
        }
        return 0;
    }
}
