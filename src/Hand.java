import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
public class Hand{

    //instance variables
    private Card[] hand=new Card[5];
    private HashSet<Integer> set=new HashSet<>();
    private ArrayList<Integer> list=new ArrayList<>();
    private boolean threeKind = false;
    private boolean firstPair = false;
    private boolean secondPair = false;
    private int firstP = -1;
    private int secondP = -1;
    private int threek = -1;
    private int fourK = -1;

    public Hand(Card[] inHand)
    {
        hand=inHand;
        startBasic();
    }

    public Hand(String c1, String c2, String c3, String c4, String c5) {
        hand[0] = new Card(c1);
        hand[1] = new Card(c2);
        hand[2] = new Card(c3);
        hand[3] = new Card(c4);
        hand[4] = new Card(c5);
        startBasic();
    }

    public void startBasic() {
        Arrays.sort(hand);
        for (Card a:hand) {
            set.add(a.getValue());
            list.add(a.getValue());
        }
    }

    public String toString()
    {
        String result="";
        for (int i=0;i<5;i++)
        {
            result+=hand[i]+" ";
        }
        return result;
    }

    public boolean beats(Hand player2)
    {
        int p1 = getPointValues();
        int p2 = player2.getPointValues();
        if (p1>p2) {
            return true;
        }
        else if (p1==p2) {
            switch (p1) {
                case 1:
                return basicHighCard(player2);
                case 2:
                return onePairHighCard(player2);
                case 3:
                return twoPairHighCard(player2);
                case 4:
                return threeKindHighCard(player2);
                case 5:
                return straightHighCard(player2);
                case 6:
                return basicHighCard(player2);
                case 7:
                return fullHouseHighCard(player2);
                case 8:
                return fourofAKindHighCard(player2);
                case 9:
                break;
                case 10:
                break;
            }
        }
        return false;
    }

    public boolean basicHighCard(Hand player2) {
        for (int i=hand.length-1;i>=0;i++) {
            if (hand[i].getValue()>player2.hand[i].getValue()) {
                return true;
            }
            else if (hand[i].getValue()<player2.hand[i].getValue()) {
                return false;
            }
        }
        //should never reach this location
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        return false;
    }

    public boolean onePairHighCard(Hand player2) {
        if (firstP>player2.firstP) {
            return true;
        }
        else if (firstP<player2.firstP) {
            return false;
        }
        return basicHighCard(player2);
    }

    public boolean twoPairHighCard(Hand player2) {
        if (secondP>player2.secondP) {
            return true;
        }
        else if (secondP<player2.secondP) {
            return false;
        }
        return onePairHighCard(player2);
    }

    public boolean threeKindHighCard(Hand player2) {
        if (threek>player2.threek) {
            return true;
        }
        else if (threek<player2.threek) {
            return false;
        }
        return basicHighCard(player2);
    }

    public boolean straightHighCard(Hand player2) {
        if (hand[0].getValue()>player2.hand[0].getValue()) {
            return true;
        }
        else if (hand[0].getValue()<player2.hand[0].getValue()) {
            return false;
        }
        //should never reach this location
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        System.out.println("ERROR-------------------");
        return false;
    }

    public boolean fullHouseHighCard(Hand player2) {
            if (threek>player2.threek) {
            return true;
        }
        else if (threek<player2.threek) {
            return false;
        }
           return onePairHighCard(player2);
    }

    public boolean fourofAKindHighCard(Hand player2) {
    if (fourK>player2.fourK) {
            return true;
        }
        else if (fourK<player2.fourK) {
            return false;
        }
           return basicHighCard(player2);
    }

    public int getPointValues() {
        if (isRoyalFlush()) {
            System.out.println("Royal Flush");
            return 10;
        }
        else if (straightFlush()) {
            System.out.println("Straight Flush");
            return 9;
        }
        else if (fourofAKind()) {
            System.out.println("Four of A Kind");
            return 8;

        }
        else if (fullHouse()) {
            System.out.println("Full House");
            return 7;
        }
        else if (isFlush()) {
            System.out.println("is Flush");
            return 6;
        }
        else if (isStraight()) {
            System.out.println("is straight");
            return 5;
        }
        else if (threeofAKind()) {
            System.out.println("three of a kind");
            return 4;
        }
        else if (twoPair()) {
            System.out.println("two pair");
            return 3;
        }
        else if (onePair()) {
            System.out.println("one pair");
            return 2;
        }
        System.out.println("high card");
        return 1;

    }

    public boolean isFlush()
    {
        for (int i=1;i<hand.length;i++)
        {
            if (hand[i-1].getSuite() != hand[i].getSuite())
            {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight()
    {
        for (int i=1;i<hand.length;i++) {
            if (hand[i].getValue() != hand[i-1].getValue()+1) {
                return false;
            }
        }
        return true;
    }

    public boolean isRoyalFlush() {
        if (straightFlush()) {
            if (hand[0].getRank()=='T') {
                return true;
            }
        }
        return false;
    }

    public boolean straightFlush() {
        if (isStraight()&&isFlush()) {
            return true;
        }
        return false;
    }

    public boolean fourofAKind()  {
        boolean result=false;
        int count=0;
        int maxPair=-1;
        int maxLoc = -1;
        for (int a:set) {
            count=0;
            for (int b:list) {
                if (a==b) {
                    count++;
                }
            }
            if (count>maxPair) {
                maxPair=count;
                maxLoc=a;
            }
            if ((count==2) && (!firstPair)) {
                firstPair = true;
                firstP=a;
            }
            else if (count==2) {
                secondPair = true;
                secondP=a;
            }

        }
        if (maxPair==4) {
            result = true;
            fourK=maxLoc;
        }
        else if (maxPair==3) {
            threeKind = true;
            threek=maxLoc;
        }
        return result;
    }

    public boolean fullHouse() {
        return (firstPair&&threeKind);
    }

    public boolean threeofAKind()  {
        return threeKind;
    }

    public boolean twoPair() {
        return secondPair;
    }

    public boolean onePair() {
        return firstPair;
    }
}