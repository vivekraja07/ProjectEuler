import java.math.BigInteger;
public class Fraction implements Comparable {
    private BigInteger numerator;
    private BigInteger denominator;
    private BigInteger gcd;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("denominator is zero");
        }
        if (numerator == null) {
            throw new IllegalArgumentException("numerator is null");
        }
        if (denominator == null) {
            throw new IllegalArgumentException("denominator is null");
        }
        if (denominator.compareTo(BigInteger.ZERO)==-1) {
            numerator = numerator.negate();
            denominator = numerator.negate();
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction(BigInteger numerator) {
        this(numerator, BigInteger.ONE);
    }


    public void simplify() {
        gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    public String toString() {
        return (numerator.toString() + " / " + denominator.toString());
    }

    public void add(Fraction toAdd) {
        numerator = numerator.multiply(toAdd.denominator).add(toAdd.numerator.multiply(denominator));
        denominator = denominator.multiply(toAdd.denominator);
        simplify();
    }

    public boolean numMoreDigits() {
        if(numerator.toString().length()>denominator.toString().length()) {
            return true;
        }
        return false;
    }

    public void complement() {
        BigInteger temp = numerator;
        numerator = denominator;
        denominator = temp;
    }

    public boolean getGCD() {
        return (gcd.equals(BigInteger.ONE));
    }

    public int compareTo(Object other) {
        Fraction that = (Fraction) other;
        BigInteger thisNumerator = (numerator.multiply(that.denominator));
        BigInteger thatNumerator = that.numerator.multiply(denominator);
        return (thisNumerator.compareTo(thatNumerator));
    }

    public int hashCode() {
        int prime = 31;
        int result =1;
        result = prime*result + numerator.hashCode();
        result = prime*result + denominator.hashCode();
        return result;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Fraction)) return false;
        Fraction that = (Fraction) obj;
        return (numerator.equals(that.numerator)&&denominator.equals(that.denominator));
    }




}