import java.util.ArrayList;
import java.util.Arrays;
public class Sudoku {

    //instance variables
    public int[][] table = new int[9][9];
    private String name;
    public ArrayList<SudokuTile> tiles = new ArrayList<>();
    public int numChoices=0;
    private boolean changesMade=true;
    private String beginning;
    private int guessCount=0;
    private boolean works=true;

    private static boolean done = false;
    private int smallTile;
    private int set;
    public Sudoku father=null;
    private static Sudoku solution;

    public void makeEqual(Sudoku guess) {
        this.table=guess.table;
        this.tiles=guess.tiles;
        this.numChoices=guess.numChoices;
    }

    public int getTopLeft() {
        int one=table[0][0];
        int two=table[0][1];
        int three=table[0][2];
        String s=""+one+two+three;
        return Integer.parseInt(s);
    }

    public Sudoku(String[] in) {
        name=in[0];
        done=false;
        solution=null;
        for (int i=1;i<in.length;i++) {
            table[i-1]=getArray(in[i]);
        }
        beginning=toString();
        getTiles();

        while (changesMade) {
            changesMade=false;
            configureTiles();
            //System.out.println(numChoices);
            //System.out.println(tiles);
        }
        if (numChoices!=0) {
            guessAndCheck();
            //System.out.println(numChoices);
            //System.out.println(tiles);
            //System.out.println(Arrays.deepToString(table));
        }
        //printUpdates();
        System.out.println(toString());
        // System.out.println(getTopLeft());
        // System.out.println();
    }

    public Sudoku(int[][] newTable, String inName, ArrayList<SudokuTile> inTiles,int guessCount) {
        table=newTable;
        name=inName;
        tiles=inTiles;
        while(changesMade) {
            changesMade=false;
            configureTiles();;
        }
        if (emptyTileExists()) {
            works=false;
            if (numChoices==0) {
                done=true;
            }
        }
        else {
            works=true;
        }
        this.guessCount=guessCount;
    }

    public void guessAndCheck() {
        if (works) {
            smallTile=getSmallestTile();
            // if (done) {
            //     System.out.println("done");
            //     solution=this;
            // }
            System.out.println("Smallest Tile: "+tiles.get(smallTile));
            int[][] newTable=makeACopy(table);
            ArrayList<SudokuTile> newTiles = makeACopy(tiles);
            set = tiles.get(smallTile).getFirst();
            newTable[tiles.get(smallTile).getX()][tiles.get(smallTile).getY()]=set;
            newTiles.remove(smallTile);
            Sudoku guess = new Sudoku(newTable, ("Guess"+(guessCount+1)),newTiles, (guessCount+1));
            guess.father=this;

            System.out.println("Guess"+guess.guessCount + " has just been created");
            System.out.println(guess.name+"'s father is : "+guess.father.name);
            if (guess.works) {
                System.out.println(guess.name+" works!!");
                System.out.println("Because it works, we shall go deeper into another level");
                if (guess.numChoices!=0) {
                    guess.guessAndCheck();
                }
                else {
                    System.out.println("You are done!");
                    done=true;
                    solution=guess;
                    System.out.println(guess.toString());

                }
            }
            else {
                System.out.println(guess.name+" doesn't work!!");
                System.out.println("Because it doesn't work, we shall go outside one level and update it");
                boolean removed = tiles.get(smallTile).removeVals(set);
                //System.out.println(table[tiles.get(smallTile).getX()][tiles.get(smallTile).getY()]);
                if (tiles.get(smallTile).hasOneOnly()) {
                //System.out.println("Has one only so these nums should have changed");
                    table[tiles.get(smallTile).getX()][tiles.get(smallTile).getY()]=tiles.get(smallTile).getFinalVal();
                //System.out.println(table[tiles.get(smallTile).getX()][tiles.get(smallTile).getY()]);
                }
                removeFinals();
                changesMade=true;
                while (changesMade) {
                    changesMade=false;
                    configureTiles();
                }
                if (emptyTileExists()) {
                    works=false;
                    System.out.println("GRAVE ERROR: ");
                    System.out.println(name+ " doesn't work either");
                    System.out.println("we need to go outside another level and update it");
                    System.out.println("we need to get to : guess"+(guessCount-1));
                    checkFather(this);
                }
                else {
                    works = true;
                    System.out.println(name + " still works");
                    if (numChoices==0) {
                        done=true;
                    }
                    else {
                        done =false;
                    }
                    if (done) {
                        solution=this;
                        System.out.println("done");
                    }
                    else {
                        guessAndCheck();
                    }
                }
            }
        }
        if (numChoices==0||done) {
            makeEqual(solution);
        }
        System.out.println("on the way out, we are here: "+name);

    }

    public void checkFather(Sudoku current) {
        Sudoku gg=current.father;
        gg.tiles.get(gg.smallTile).removeVals(gg.set);
        if (gg.tiles.get(gg.smallTile).hasOneOnly()) {
            gg.table[gg.tiles.get(gg.smallTile).getX()][gg.tiles.get(gg.smallTile).getY()]=gg.tiles.get(gg.smallTile).getFinalVal();
        }
        gg.removeFinals();
        gg.changesMade=true;
        while (gg.changesMade) {
            gg.changesMade=false;
            gg.configureTiles();
        }
        if (gg.emptyTileExists()) {
            gg.works=false;
        }
        else {
            gg.works=true;
        }
        if (gg.works) {
            if (gg.numChoices==0) {
                //System.out.println("done");
                done=true;
                solution=gg;
            }
            else {
                gg.guessAndCheck();
            }
        }
        else {
            checkFather(gg);
        }
    }

    public boolean emptyTileExists() {
        for (SudokuTile s:tiles) {
            if (s.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void configureTiles() {
        for (int i=0;i<tiles.size();i++) {
            //horizontal
            tiles.set(i,configureHorizontal(tiles.get(i)));
            //vertical
            tiles.set(i,configureVertical(tiles.get(i)));
            //box
            tiles.set(i,configureBoxes(tiles.get(i)));

            //check if can be set
            if (tiles.get(i).hasOneOnly()) {
                table[tiles.get(i).getX()][tiles.get(i).getY()]=tiles.get(i).getFinalVal();
                changesMade=true;
            }
        }
        removeFinals();
        getNumChoices();
    }

    public void removeFinals() {
        ArrayList<SudokuTile> jj = new ArrayList<>();
        for (SudokuTile s:tiles) {
            if (s.hasOneOnly()) {
                jj.add(s);
                changesMade=true;
            }
        }
        for (SudokuTile s:jj) {
            if (tiles.contains(s)) {
              //System.out.println(s+": removed from " + name);
              //System.out.println("should not be false:");
              //System.out.println(tiles.remove(s));
                tiles.remove(s);

            }
        }
    }

    public int getSmallestTile() {
        int min=1000;
        int loc=-1;
        for (int i=0;i<tiles.size();i++) {
            if (tiles.get(i).getSize()<min) {
                min=tiles.get(i).getSize();
                loc=i;
            }
        }
        return loc;
    }


    public void printUpdates() {
        //print beginning
        System.out.println(beginning);

        //print current
        System.out.println(toString());

        //print each tile's blocks
        // for (SudokuTile s:tiles) {
        //     System.out.println();
        //     System.out.println(s.getX() + " , " + s.getY());
        //     System.out.println(s);
        // }
    }

    public int[] getArray(String in) {
        int[] s = new int[9];
        for (int i=0;i<in.length();i++) {
            s[i]=Integer.parseInt(in.substring(i,i+1));
        }
        return s;
    }

    public void getNumChoices() {
        int count=0;
        for (SudokuTile s:tiles) {
            count+=s.getSize();
        }
        numChoices=count;
    }

    public String toString() {
        String result = (name)+"\n";
        for (int i=0;i<table.length;i++) {
            for (int j=0;j<table[0].length;j++) {
                result+=(table[i][j]);
            }
            result+="\n";
        }
        return result;
    }

    public void getTiles() {
        for (int i=0;i<table.length;i++) {
            for (int j=0;j<table[0].length;j++) {
                if (table[i][j]==0) {
                    SudokuTile newTile = new SudokuTile(i,j);
                    tiles.add(newTile);
                }
            }
        }
    }

    public SudokuTile configureVertical(SudokuTile s) {
        int x=s.getX();
        for (int i=0;i<9;i++) {
            if (table[x][i]!=0) {
                if (s.removeVals(table[x][i])) changesMade=true;
            }
        }
        return s;
    }

    public SudokuTile configureHorizontal(SudokuTile s) {
        int y=s.getY();
        for (int i=0;i<9;i++) {
            if (table[i][y]!=0) {
                if (s.removeVals(table[i][y])) changesMade=true;
            }
        }
        return s;
    }

    public SudokuTile configureBoxes(SudokuTile s) {
        ArrayList<Integer> nums=getBoxNums(s.getX(),s.getY());
        for (int i=0;i<nums.size();i++) {
            if (s.removeVals(nums.get(i))) changesMade=true;
        }
        return s;
    }

    public ArrayList<Integer> getBoxNums(int x, int y) {
        ArrayList<Integer> boxNums = new ArrayList<>();
        int begX;
        int begY;
        if (x<=2) {
            begX=0;
            if (y<=2) {
                begY=0;
            }
            else if (y<=5) {
                begY=3;
            }
            else{
                begY=6;
            }
        }
        else if (x<=5) {
            begX=3;
            if (y<=2) {
                begY=0;
            }
            else if (y<=5) {
                begY=3;
            }
            else {
                begY=6;
            }
        }
        else{
            begX=6;
            if (y<=2) {
                begY=0;
            }
            else if (y<=5) {
                begY=3;
            }
            else {
                begY=6;
            }
        }
        for (int i=begX;i<=begX+2;i++) {
            for (int j=begY;j<=begY+2;j++) {
                if (table[i][j]!=0) {
                    boxNums.add(table[i][j]);
                }
            }
        }
        return boxNums;
    }

    public int[][] makeACopy(int[][] table) {
        int[][] newTable = new int[9][9];
        for (int r=0;r<table.length;r++) {
            for (int c=0;c<table[0].length;c++) {
                newTable[r][c]=table[r][c];
            }
        }
        return newTable;
    }

    public ArrayList<SudokuTile> makeACopy(ArrayList<SudokuTile> tiles) {
        ArrayList<SudokuTile> newTiles = new ArrayList<>();
        for (int i=0;i<tiles.size();i++) {
            newTiles.add(tiles.get(i).makeACopy());
        }
        return newTiles;
    }

}