public class SmallFraction implements Comparable {
    private int numerator;
    private int denominator;
    private int gcd;

    public SmallFraction(int numerator, int denominator) {
        if (denominator==0) {
            throw new IllegalArgumentException("denominator is zero");
        }
        if (denominator<0) {
            numerator = -1*numerator;
            denominator = -1*numerator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public void simplify() {
        gcd = Prime.gcd(numerator, denominator);
        numerator = numerator/(gcd);
        denominator = denominator/(gcd);
    }

    public String toString() {
        return (numerator+ " / " + denominator);
    }

    // public void add(Fraction toAdd) {
    //     numerator = numerator.multiply(toAdd.denominator).add(toAdd.numerator.multiply(denominator));
    //     denominator = denominator.multiply(toAdd.denominator);
    //     simplify();
    // }

    // public boolean numMoreDigits() {
    //     if(numerator.toString().length()>denominator.toString().length()) {
    //         return true;
    //     }
    //     return false;
    // }

    // public void complement() {
    //     BigInttemp = numerator;
    //     numerator = denominator;
    //     denominator = temp;
    // }

    public boolean getGCD() {
        return (gcd==1);
    }

    public int compareTo(Object other) {
        SmallFraction that = (SmallFraction) other;
        int thisNumerator = (numerator*(that.denominator));
        int thatNumerator = that.numerator*(denominator);
        return (thisNumerator-(thatNumerator));
    }

    public int hashCode() {
        int prime = 31;
        int result =1;
        result = prime*result + numerator;
        result = prime*result + denominator;
        return result;
    }

    public boolean equals(Object obj) {
        //if (obj == null) return false;
        //if (!(obj instanceof SmallFraction)) return false;
        SmallFraction that = (SmallFraction) obj;
        return (numerator==(that.numerator)&&denominator==(that.denominator));
    }




}