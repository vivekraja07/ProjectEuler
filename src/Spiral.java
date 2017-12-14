import java.util.Arrays;
import java.util.ArrayList;
public class Spiral {

    //instance variables
    private int[][] table;
    private int currentSideSize=1;
    private int current =1;
    private int rows;
    private int columns;
    private ArrayList<Integer> diagonals = new ArrayList<>();

    //constructors
    public Spiral(int sideSize) {
        // table=new int[sideSize][sideSize];
        // rows=sideSize/2;
        // columns=sideSize/2;

        // table[rows][columns]=current;

        // while (currentSideSize!=sideSize) {
        //     addAnotherLayer(--rows,++columns);
        //     currentSideSize+=2;
        //     //System.out.println(toString());
        // }
        //getDiagonals();
        //System.out.println(toString());

    }

    public double getRatioPrimes() {
        int numPrices=0;
        for (int i=0;i<diagonals.size();i++) {
            if (Prime.isPrime(diagonals.get(i))) {
                numPrices++;
            }
        }
        return (100.0*numPrices)/diagonals.size();
    }


    public void getDiagonals() {
        for (int i=0;i<currentSideSize;i++) {
            //System.out.println(table[i][i]);
            diagonals.add(table[i][i]);
            diagonals.add(table[i][currentSideSize-i-1]);
        }
        //warning: there are two 1's in diagonals in this
        diagonals.remove(new Integer(1));
    }



    public int getDiagonalSums() {
        int sum=0;
        //first get top-left to bottom-right diagonal
        for (int i=0;i<currentSideSize;i++) {
            sum+=table[i][i];
            //System.out.println(table[i][i]);
            sum+=table[i][currentSideSize-i-1];
            //System.out.println(table[i][currentSideSize-i-1]);
        }


        return sum-1;

    }

    public void addAnotherLayer(int row, int column) {
        //go down for currentSize+2 times
        for (int i=1;i<currentSideSize+2;i++) {
            //System.out.println("DOWN ONE");
            row=row+1;
            current++;
            table[row][column]=current;
        }

        //System.out.println(toString());


        //go left for currentSize+2 times
        for (int i=1;i<currentSideSize+2;i++) {
            //System.out.println("LEFT ONE");
            column=column-1;
            current++;
            table[row][column]=current;
        }

        //go up for current size+2 times
        for (int i=1;i<currentSideSize+2;i++) {
            //System.out.println("UP ONE");
            row=row-1;
            current++;
            table[row][column]=current;
        }

        //go right for current size+2 times
        for (int i=1;i<currentSideSize+2;i++) {
            //System.out.println("RIGHT ONE");
            column++;
            current++;
            table[row][column]=current;
        }

        rows=row;
        columns=column;


    }

    //toString
    public String toString() {
        String toReturn = "";
        for (int i=0;i<table.length;i++) {
            for (int j=0;j<table[0].length;j++) {
                toReturn+=(table[i][j]+"    ");
            }
            toReturn+=("\n");
        }
        return toReturn;
    }
}