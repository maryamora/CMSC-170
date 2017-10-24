import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    private String filename;
    private char [][] arrayMaze = null;
    private ArrayList<String> list = new ArrayList<String>();
    private int rowSize;
    private int colSize;

    public char[][] getArrayFile(String filename){
        this.filename = filename;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
            }
            arrayMaze = toArray(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayMaze;
    }

    private char[][] toArray(ArrayList<String> lines){
        rowSize = lines.size();
        colSize = lines.get(0).length();
        char [][] array = new char[rowSize][colSize];

        String line;
        int a = 0;
        int b;
        for(int i = 0; i < lines.size(); i++){
            line = lines.get(i);
            b = 0;
            for(int j = 0; j < colSize; j++){
                array[a][b] = line.charAt(j);
                b++;
            }
            a++;
        }
        return array;
    }

    public int getColSize(){
        return colSize;
    }

    public int getRowSize(){
        return rowSize;
    }

    public char [][] getArrayMaze(){
        return arrayMaze;
    }

}
