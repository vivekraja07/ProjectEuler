import java.util.ArrayList;
public class SudokuTile {
    //instance variables
    private int x;
    private int y;
    private ArrayList<Integer> poss = new ArrayList<>();

    public SudokuTile makeACopy() {
        SudokuTile s = new SudokuTile(x,y);
        ArrayList<Integer> possibilities = new ArrayList<>(poss);
        // ArrayList<Integer> possibilities = new ArrayList<>();
        // for (int i=0;i<poss.size();i++) {
        //     possibilities.add(new Integer(poss.get(i)));
        // }
        s.poss=possibilities;
        return s;

    }

    public SudokuTile(int x, int y) {
        this.x=x;
        this.y=y;
        fillAllVals();
    }

    public boolean removeVals(int z) {
        return poss.remove(new Integer(z));
    }

    public void setPoss(ArrayList<Integer> newPoss) {
        this.poss=newPoss;
    }

    public boolean hasOneOnly() {
        if (poss.size()==1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return poss.isEmpty();
    }

    public int getFirst() {
        return poss.get(0);
    }

    public int getFinalVal() {
        return poss.get(0);
    }

    public ArrayList<Integer> getPoss() {
        return poss;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return poss.size();
    }

    public void fillAllVals() {
        poss.add(1);
        poss.add(2);
        poss.add(3);
        poss.add(4);
        poss.add(5);
        poss.add(6);
        poss.add(7);
        poss.add(8);
        poss.add(9);
    }

    public String toString() {
        return "x: "+ x+" "+" y: "+y+" "+poss.toString()+"\n";
        //return poss.toString();
    }

    // public boolean equals(Object compare) {
    //     if (this==compare) {
    //         return true;
    //     }
    //     if (compare==null) {return false;}
    //     SudokuTile that = (SudokuTile) compare;
    //     if (that.poss.containsAll(this.poss)) {
    //         return true;
    //     }
    //     return false;
    // }

}