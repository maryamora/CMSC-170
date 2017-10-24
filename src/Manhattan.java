import java.util.ArrayList;

public class Manhattan {

    private Square start;
    private Square goal;
    private Square current;

    private char[][] maze;

    private int rows;
    private int cols;

    private ArrayList<Square> openList;
    private ArrayList<Square> closedList;

    public Manhattan() {
        //constructor
        openList = new ArrayList<Square>();
        closedList = new ArrayList<Square>();
    }

    public Manhattan(char[][] maze, int rows, int cols) {
        this.maze = maze;
        this.rows = rows;
        this.cols = cols;

        openList = new ArrayList<Square>();
        closedList = new ArrayList<Square>();
    }

    //find the start
    public void findStart() {
        for (int roww = 0, coll = 0; roww < rows; roww++) {
            for (coll = 0; coll < cols; coll++) {
                if (maze[roww][coll] == 'P') {
                    start = new Square(roww, coll);
                    start.setgCost(0);
                    start.sethCost(0);
                    start.setTotalCost(0);
                    current = start;
                    openList.add(current);
                    break;
                }
            }
        }
        //check
        System.out.println("Start: ");
        start.printStats();
    }

    //find the goal

    public void findGoal() {
        for (int roww = 0, coll = 0; roww < rows; roww++) {
            for (coll = 0; coll < cols; coll++) {
                if (maze[roww][coll] == '.') {
                    goal = new Square(roww, coll);
                    goal.setgCost(0);
                    goal.sethCost(0);
                    goal.setTotalCost(0);
                    break;
                }
            }
        }
        //check
        System.out.println("End: ");
        goal.printStats();
    }

    //start with the current

    public void findNeighbors(){
        closedList.add(current);
        openList.remove(current);
        //int index = 0;
        /*for (Square sq: openList){
            if (sq.getRow() == current.getRow() && sq.getCol() == current.getCol()){
                openList.remove(index);
            }
            index++;
        }*/
        //UP
            if (maze[current.getRow() - 1][current.getCol()] != '%'){
                //check closedlist
                boolean canAdd = true;

                for (Square s: closedList){
                    if (s.getRow() == (current.getRow()-1) && s.getCol() == current.getCol()){
                        canAdd = false;
                    }
                }
                if (canAdd){
                    Square newSquare = new Square(current.getRow()-1,current.getCol());
                    newSquare.setgCost(current.getgCost()+1);
                    newSquare.sethCost(findHCost(newSquare.getRow(), newSquare.getCol()));
                    newSquare.setTotalCost(newSquare.getgCost()+newSquare.gethCost());
                    newSquare.setParent(current);
                    openList.add(newSquare);
                }
            }
        //DOWN

            if (maze[current.getRow() + 1][current.getCol()] != '%'){
                //check closedlist
                boolean canAdd = true;
                for (Square s: closedList){
                  if (s.getRow() == (current.getRow()+1) && s.getCol() == current.getCol()){
                    canAdd = false;
                  }
                }
                if (canAdd){
                    Square newSquare = new Square(current.getRow()+1,current.getCol());
                    newSquare.setgCost(current.getgCost()+1);
                    newSquare.sethCost(findHCost(newSquare.getRow(), newSquare.getCol()));
                    newSquare.setTotalCost(newSquare.getgCost()+newSquare.gethCost());
                    newSquare.setParent(current);
                    openList.add(newSquare);
                }
        }

        //LEFT
        if (maze[current.getRow()][current.getCol()-1] != '%'){
            //check closedlist
            boolean canAdd = true;
            for (Square s: closedList){
                if (s.getRow() == current.getRow() && s.getCol() == (current.getCol() -1)){
                    canAdd = false;
                }
            }
            if (canAdd){
                Square newSquare = new Square(current.getRow(),current.getCol()-1);
                newSquare.setgCost(current.getgCost()+1);
                newSquare.sethCost(findHCost(newSquare.getRow(), newSquare.getCol()));
                newSquare.setTotalCost(newSquare.getgCost()+newSquare.gethCost());
                newSquare.setParent(current);
                openList.add(newSquare);
            }

        }

        //RIGHT

        if (maze[current.getRow()][current.getCol()+1] != '%'){
            //check closedlist
            boolean canAdd = true;
            for (Square s: closedList){
                if (s.getRow() == current.getRow() && s.getCol() == (current.getCol()+1)){
                    canAdd = false;
                }
            }
            if (canAdd){
                Square newSquare = new Square(current.getRow(),current.getCol()+1);
                newSquare.setgCost(current.getgCost()+1);
                newSquare.sethCost(findHCost(newSquare.getRow(), newSquare.getCol()));
                newSquare.setTotalCost(newSquare.getgCost()+newSquare.gethCost());
                newSquare.setParent(current);
                openList.add(newSquare);
            }
        }
        //check openList
        System.out.println("\nOpen List: ");
        for (Square s: openList){
            s.printStats();
        }
        System.out.println("\nClosed List: ");
        for (Square s: closedList){
            s.printStats();
        }
    }

    public int findHCost(int row, int col){
        return Math.abs(row - goal.getRow()) + Math.abs(col - goal.getCol());
    }

    public void chooseNewSquare(){
        Square nextSquare = openList.get(0);
        for (Square square: openList){
            if (nextSquare.getTotalCost() > square.getTotalCost()){
                nextSquare = square;
            }
        }
        current = nextSquare;
        System.out.println("\nNew Square: ");
        current.printStats();
    }

    public boolean goalNotFound(){
        if (maze[current.getRow()][current.getCol()] == '.'){
            return false;
        }
        return true;
    }

}