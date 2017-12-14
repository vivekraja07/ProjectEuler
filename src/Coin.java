public class Coin
{
    //instance variables
    int one=1;
    int two=2;
    int five=5;
    int ten=10;
    int twenty=20;
    int fifty=50;
    int hundred=100;
    int thundred=200;

    int purse;

    public Coin(int inOnes, int inTwos, int inFives, int inTens, int inTwentys,
        int inFifties, int inHundreds, int intHundreds)
    {
        one=inOnes;
        two=inTwos;
        five=inFives;
        ten=inTens;
        twenty=inTwentys;
        fifty=inFifties;
        hundred=inHundreds;
        thundred=intHundreds;

        purse=one+two*2+5*five+10*ten+20*twenty+50*fifty+100*hundred+200*thundred;
    }

    public boolean fullPurse()
    {
        if (purse==200)
            return true;
        else return false;
    }

}