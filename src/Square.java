public class Square {
    private int row;
    private int col;

    private Square parent;

    private int gCost;
    private int hCost;
    private int totalCost;

    public Square(){
        //constructor
    }

    public Square(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Square getParent() {
        return parent;
    }

    public void setParent(Square parent) {
        this.parent = parent;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int gCost) {
        this.gCost = gCost;
    }

    public int gethCost() {
        return hCost;
    }

    public void sethCost(int hCost) {
        this.hCost = hCost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void printStats(){
        System.out.println("Row: "+getRow()+"\nColumn: "+getCol()+"\nG(x): "+getgCost()+"\nH(x): "+gethCost()+"\nTotal cost: "+getTotalCost());
    }
}
