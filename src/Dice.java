public class Dice {

    //instance variables
    public int side1;
    public int side2;
    public int side3;

    public Dice(int side1, int side2, int side3) {
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    public boolean beats(Dice other) {
        int wins=0;
        if (side1>other.side1) wins++;
        if (side1>other.side2) wins++;
        if (side1>other.side3) wins++;
        if (side2>other.side1) wins++;
        if (side2>other.side2) wins++;
        if (side2>other.side3) wins++;
        if (side3>other.side1) wins++;
        if (side3>other.side2) wins++;
        if (side3>other.side3) wins++;
        if (wins>4) return true;
        return false;
    }

    public String toString(){
        return  side1+" "+side2+" "+side3;
    }
}
