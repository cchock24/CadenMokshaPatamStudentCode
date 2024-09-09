public class Square {

    int number;
    int visited;
    boolean isLadder;
    boolean isSnake;
    int transport;

    // Constructor If Square is  Ladder or Snake
    public Square(boolean ladder, boolean snake, int number, int destination){
        this.visited = 0;
        isLadder = ladder;
        isSnake = snake;
        this.number = number;
        transport = destination;
    }

    // Constructor If Square is Normal Square
    public Square(int number){
        this.number = number;
        isLadder = false;
        isSnake = false;
        transport = 0;
        visited = 0;
    }
    // Rolls Needed to Get to Space
    public int getVisited() {
        return visited;
    }

    public boolean isLadder() {
        return isLadder;
    }

    public boolean isSnake() {
        return isSnake;
    }
    // Space Number/Position
    public int getNumber() {
        return number;
    }
    // If Snake or Ladder the Space Where it Goes
    public int getTransport() {
        return transport;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }
}
