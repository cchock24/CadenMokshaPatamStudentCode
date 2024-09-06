public class Square {

    int number;
    int visited;
    boolean isLadder;
    boolean isSnake;
    int transport;
    int parent;

    public Square(boolean ladder, boolean snake, int number, int destination){
        this.visited = 0;
        isLadder = ladder;
        isSnake = snake;
        this.number = number;
        transport = destination;
        parent = 0;
    }

    public Square(int number){
        this.number = number;
        isLadder = false;
        isSnake = false;
        transport = 0;
        parent = 0;
        visited = 0;
    }

    public int getVisited() {
        return visited;
    }

    public boolean isLadder() {
        return isLadder;
    }

    public boolean isSnake() {
        return isSnake;
    }

    public int getNumber() {
        return number;
    }

    public int getTransport() {
        return transport;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
