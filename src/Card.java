public class Card implements Comparable{

    //instance variables
    private char rank;
    private char suite;
    private char[] ranks={'2','3','4','5','6','7','8','9','T','J','Q','K','A'};

    public Card(String in) //parameter
    {
        rank=in.charAt(0);
        suite=in.charAt(1);
    }

    public String toString()
    {
        return ""+rank+suite;
    }

    public char getRank()
    {
        return rank;
    }

    public char getSuite()
    {
        return suite;
    }

    public int getValue()
    {
        for(int i=0;i<ranks.length;i++)
        {
            if (rank==ranks[i])
            {
                return i;
            }
        }
        return -1;
    }

    public int compareTo(Object other)
    {
        Card that= (Card) other;
        return this.getValue()-that.getValue();
    }



}