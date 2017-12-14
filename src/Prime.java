import java.util.*;
import java.math.*;
import java.util.Collections;
import java.util.Arrays;
public class Prime
{

  //instance variables
  List<Long> primeFactors=new ArrayList<Long>();


  //checks if prime
  public static boolean isPrime(long inNumber)
  {
    if (inNumber==2) return true;
    if (inNumber%2==0) return false;
    for(long i=3;i*i<=inNumber;i+=2)
    {
      if (inNumber%i==0)
      {
        return false;
      }
    }
    if (inNumber<=1) return false;
    return true;
  }

  //obtain a pair of factors
  public static long [] getFactors(long inNumber)
  {
    long[] factors = new long[2];
    for (long i=2L;i<inNumber;i++)
    {
      if (inNumber%i==0)
      {
       factors[0]=i;
       factors[1]=inNumber/i;
       i=inNumber;
     }
   }
   return factors;
 }

  //checks if its a palindrome
   public static boolean getPalindrome(int inNumber)
   {
     String str=Integer.toString(inNumber);
     for (int i=0;i<str.length()/2;i++)
     {
       if (str.charAt(i)!=str.charAt(str.length()-1-i))
       {
         return false;
       }
     }
     return true;
   }

   public static boolean getPalindrome(String str)
   {
    for (int i=0;i<str.length()/2;i++)
    {
     if (str.charAt(i)!=str.charAt(str.length()-1-i))
     {
       return false;
     }
   }
   return true;
  }

    //returns the sum of the squares of the first 100 natural numbers
  public static int sumSquares()
  {
    int sum=0;
    for (int i=1;i<=100;i++)
    {
     sum+=i*i;
   }
   return sum;
  }

    //returns the square of the sum of the first 100 natural numbers
  public static int squareSum()
  {
   int sum=0;
   for (int i=1;i<=100;i++)
   {
    sum+=i;
  }
  sum*=sum;
  return sum;
  }

    //gets the product of a 13-digit number
  public static long getProduct(String inNumbers)
  {
    long product=1;
    for (int i=0;i<13;i++)
    {
     product*=Character.getNumericValue(inNumbers.charAt(i));
   }
   return product;
  }

    //greatest product
  public static long greatestProduct(String inNumbers)
  {
    long max=0L;
    long num;
    int beg=0,end=13;
    for (int i=1;i<987;i++)
    {
      num=Prime.getProduct(inNumbers.substring(beg,end));
      if (num>max)
      {
        max=num;
      }
      beg+=1;
      end+=1;
    }
    return max;
  }

    //pythagorean square
  public static int pythagoreanSum()
  {
   for (int a =1;a<1000;a++)
   {
    for (int b=1;b<1000;b++)
    {
     for (int c=1;c<1000;c++)
     {
       if ((a*a+b*b)==(c*c))
       {
        if (a+b+c==1000)
        {
         return (a*b*c);
       }
     }
   }
  }
  }
  return 0;
  }

    //puts 20x20 string into an array
  public static int [][] intoArray(String inNumbers)
  {
    int [][] d=new int [20][20];
    int beg=0;
    int end=2;
    for (int i=0;i<d.length;i++)
    {
      for (int j=0;j<d[0].length;j++)
      {
        d[i][j]=Integer.parseInt(inNumbers.substring(beg,end),10);
        beg+=3;
        end+=3;
      }
    }
    return d;
  }

    //gets the greatest product of 4 numbers on a 20x20 grid that are next to each other
  public static int greatestSeq(int [][] c)
  {
      //get greatest product of 4 adjacent numbers horizontally
    int horMax=0;
    int product;
    for (int i=0;i<c.length;i++)
    {
      for (int j=0;j<c[0].length-3;j++)
      {
        product=1;
        for (int k=0;k<4;k++)
        {
         product*=c[i][j+k];
       }
       if (product>horMax)
       {
        horMax=product;
      }
    }
  }

      //get greatest product of 4 adjacent numbers vertically
  int verMax=0;
  for (int i=0;i<c[0].length;i++)
  {
    product=1;
    for (int j=0;j<c.length-3;j++)
    {
      product=1;
      for (int k=0;k<4;k++)
      {
       product*=c[j+k][i];
     }
     if (product>verMax)
     {
      verMax=product;
    }
  }
  }

      //get greatest product of 4 adjacent numbers diagonlly in this way:\
  int diaglMax=0;
  for (int i=0;i<c.length-3;i++)
  {
   for (int j=0;j<c[0].length-3;j++)
   {
     product=1;
     for (int k=0;k<4;k++)
     {
      product*=c[i+k][j+k];
    }
    if (product>diaglMax)
    {
      diaglMax=product;
    }
  }
  }

      //get greatest product of 4 adjacent numbers diagonally in this way:/
  int diagRMax=0;
  for (int i=19;i>2;i--)
  {
   for (int j=0;j<c[0].length-3;j++)
   {
     product=1;
     for (int k=0;k<4;k++)
     {
      product*=c[i-k][j+k];
    }
    if (product>diagRMax)
    {
      diagRMax=product;
    }
  }
  }
  return Prime.getMax(horMax, verMax, diaglMax,diagRMax);



  }

    //greatest of ints fed in
  public static int getMax(int...args)
  {
    int max=0;
    for (int i=0;i<args.length;i++)
    {
     if (args[i]>max)
     {
      max=args[i];
    }
  }
  return max;
  }

  public static long sumOfPrimes(int n)
  {
      //get primes
    boolean[] primes = simpleSieve(n);
    long sum = 0;

    for(int i = 0; i < primes.length; i++)
    {
      if(!primes[i])
        { sum += i; }
    }

    return sum;
  }


    //triangular numbers
  public static int getTriangular()
  {
    int triangular=76576500;
    for (int i=1;i<15000;i++)
    {
     triangular+=i;
     System.out.print(triangular);
     int count=2;
     if (triangular%Math.sqrt(triangular)==0)
     {
      count+=2;
    }
    for (int j=2;j*j<triangular;j++)
    {
      if (triangular%j==0)
      {
        count++;
      }
    }
    if (count>500)
      return triangular;
    System.out.println(": "+count+":"+i);
  }
  return -1;
  }

    //get sum of 150 digit number
  public static BigInteger getSum(String inString)
  {
   BigInteger sum=new BigInteger("0");
   int beg=0;
   int end=50;
   for (int i=0;i<100;i++)
   {
    sum=sum.add(new BigInteger(inString.substring(beg,end)));
    beg+=50;
    end+=50;
  }
  return sum;
  }

    //Longest Collatz Sequence
  public static int bilgi(long n) {
    long result=n;
    if (result <= 1) return 1;
    if (result % 2 == 0) return 1+bilgi(result/2);
    return 1+bilgi(3*result+1);
  }

  public static int getCollatz()
  {
    int max=-1;
    int maxPos=-1;
    for (int i=100;i<1000000;i++)
    {
      if (bilgi(i)>max)
      {
        maxPos=i;
        max=bilgi(i);
      }
    }
    return maxPos;
  }

    //power digit sum
  public static int getPDSum()
  {
    BigInteger pd=new BigInteger("2");
    pd=pd.pow(1000);
    int sum=0;
    String n=pd.toString();
    for (int i=0;i<n.length();i++)
    {
      sum+=Character.getNumericValue(n.charAt(i));
    }
    return sum;
  }

    //Number Letter Counts
  public static int getLetters()
  {
    int count=0;
    int one=3;
    int two=3;
    int three=5;
    int four=4;
    int five=4;
    int six=3;
    int seven=5;
    int eight=5;
    int nine=4;
    int ten=3;
    int eleven=6;
    int twelve=6;
    int thirteen=8;
    int fourteen=8;
    int fifteen=7;
    int sixteen=7;
    int seventeen=9;
    int eighteen=8;
    int nineteen=8;
    int and=3;
    int twenty=6;
    int thirty=6;
    int forty=5;
    int fifty=5;
    int sixty=5;
    int seventy=7;
    int eighty=6;
    int ninety=6;
    int hundred=7;
    int thousand=8;
    for (int i=0;i<90;i++)//one's place
    {
      count+=(one+two+three+four+five+six+seven+eight+nine);
    }

     for (int i=0;i<10;i++)//teens
     {
       count+=(ten+eleven+twelve+thirteen+fourteen+fifteen+sixteen+seventeen+eighteen+nineteen);
     }

     for (int i=0;i<100;i++)//tens
     {
       count+=(twenty+thirty+forty+fifty+sixty+seventy+eighty+ninety);
     }

     for (int i=0;i<900;i++)//hundreds
     {
       count+=hundred;
     }

     for (int i=0;i<100;i++)
     {

      count+=(one+two+three+four+five+six+seven+eight+nine);
    }

    for (int i=0;i<891;i++)
    {
      count+=and;
    }


    count+=(one+thousand);


    return count;
  }

  public static void getAmicalNumbers()
  {
    int sum=0;
    int nSum=0;
    int totalSum=0;
    for (int i=1;i<10000;i++)
    {
      sum=0;
      nSum=0;
      for (int j=1;j<i;j++)
      {
        if (i%j==0)
        {
          sum+=j;
        }
      }
      for (int j=1;j<sum;j++)
      {
        if (sum%j==0)
        {
          nSum+=j;
        }
      }
      if (nSum==i&&i!=sum)
      {
        totalSum+=(sum+i);
        System.out.println(sum+" "+i);
      }
    }
    System.out.println(totalSum/2);
  }

  public static boolean isNotSum(int insum)
  {
    //return true if it is not a sum of two abundant numbers
    //returns false if sum of two abundant numbers
    int a=0;
    for (int i=0;i<abundantNums.size();i++)
    {
      a=abundantNums.get(i);
      for (int j=0;a+abundantNums.get(j)<=insum;j++)
      {
        if (a+abundantNums.get(j)==insum)
        {
          return false;
        }
      }
    }
    return true;
  }

  static ArrayList<Integer> abundantNums = new ArrayList<Integer>();

  public static void addAbundantNums()
  {
    for (int i=1;i<=28123;i++)
    {
      int sum=0;
      for (int j=1;j<i;j++)
      {
        if (i%j==0)
        {
          sum+=j;
        }
      }
      if (sum>i)
      {
        abundantNums.add(i);
      }
    }
  }

  public static void nonAbundantSums()
  {
    addAbundantNums();
      //for (int i=0;i<abundantNums.size();i++)
      //{
        // System.out.println(abundantNums.get(i));
      //}


    int sum=0;
    for (int i=1;i<=28123;i++)
    {
      if (isNotSum(i))
      {
        sum+=i;
        System.out.println(i);
      }
    }
    System.out.println(sum);
  }

  public static void fibonacci()
  {
    BigInteger bigBoy=new BigInteger("10");
    bigBoy=bigBoy.pow(999);

    BigInteger a=new BigInteger("1");
    BigInteger b=new BigInteger("1");
    BigInteger c=new BigInteger("0");
    int count=2;
    while (b.compareTo(bigBoy)==-1)
    {
      c=a.add(b);
      a=b.add(c);
      b=c.add(a);
      count+=3;
    }
    System.out.println(a.compareTo(bigBoy));
    System.out.println(b.compareTo(bigBoy));
    System.out.println(c.compareTo(bigBoy));
  }


  public static void doublePalindrome()
  {
    int sum=0;
    for (int i=1;i<1000000;i++)
    {
      if (getPalindrome(i))
      {
        if (getPalindrome(Integer.toBinaryString(i)))
        {
          sum+=i;
        }
      }
    }
    System.out.println(sum);
  }

  public static int isTriangle(int i)
  {
    int a=0, b=0, c=0, count=0;
    for (a=1;a<i;a++)//hypotenuse
    {
      for (b=1;b<a;b++)
      {
        for (c=1;c<=b;c++)
        {
          if (isRightTriangle(a,b,c,i)&&a+b+c==i)
          {
            count++;
          }
        }
      }
    }
    return count;
  }

  public static boolean isRightTriangle(int c, int b, int a, int i)
  {
    if (a*a+b*b==c*c)
    {
      return true;
    }
    return false;
  }

  public static boolean isRightTriangle(int a, int b, int c)
  {
    if (a*a+b*b==c*c)
    {
      return true;
    }
    return false;
  }

  public static void rightTriangles()
  {
    int p=1;
    int max=0;
    for (int i=1;i<=1000;i++)
    {
      if (isTriangle(i)>max)
      {
        max=isTriangle(i);
        p=i;
      }
    }
    System.out.println(p);
  }


  public static boolean getRoots(int a, int b, long c) //quadratic
  {
          //Finding out the roots
    double temp1 = Math.sqrt(b * b - 4 * a * c);

    double root = (-b +  temp1) / (2*a) ;
          //double root2 = (-b -  temp1) / (2*a) ;

    if (root%1==0)
    {
      return true;
    }
    return false;

  }

  public static void tripenthex()
  {
    long h=0;
    for (long i=150l;i<100000000000000l;i++)
    {
      //System.out.println(i);
     h=(i)*(2*i-1l);
     if (getRoots(3,-1,-2*h))
     {
      System.out.println("Is Pentagonal");
      if (getRoots(1,1,-2*h))
      {
        System.out.println(h);
          //i=100000000000000l;
      }
    }
  }
  }

  public static void quadraticPrimes()
  {
    int max=0;
    int maxVal=0;
    int count=0;
    int n=0;
    for (int a=-999;a<1000;a++)
    {
      for (int b=-1000;b<=1000;b++)
      {
        count=0;
        n=0;
        while (isPrime((n*n+a*n+b)))
        {
          count++;
          n++;
        }
        if(count>max)
        {
          max=count;
          maxVal=a*b;
        }
      }
    }
    System.out.println(maxVal);
  }

  public static void distinctPowers()
  {
    List<Double> intCombos=new ArrayList<Double>();
    for (int a=2;a<=100;a++)
    {
      for (int b=2;b<=100;b++)
      {
        if (!intCombos.contains(Math.pow(a,b)))
        {
          intCombos.add((Math.pow((double)a,(double)b)));
        }
      }
    }
    System.out.println(intCombos.size());
  }

  public static boolean canBeWritten(int in) //for int i that is odd and composite
  {
    double j=0;
    for (int i=3;i<in;i+=2)
    {
      if (isPrime(i))
      {
        j=Math.sqrt(((in-i)/2));
      }
      if (j>0&&j%1==0)
      {
        return true;
      }
    }
    return false;
  }

  public static void goldbach()
  {
    boolean truth=true;
    int in=7;
    while (truth)
    {
      in+=2;
      if(!isPrime(in))
      {
        truth=canBeWritten(in);
      }
    }
    System.out.println(in);
  }
  //get Factorial Sum
  public static void getFactSum()
  {
    BigInteger z=new BigInteger("1");
    BigInteger b=new BigInteger("-1");
    BigInteger n=new BigInteger("100");
    BigInteger sum=new BigInteger("100");
    while (n.compareTo(z)==1)
    {
      n=n.add(b);
      sum=sum.multiply(n);
    }
    String s=sum.toString();
    int numSum=0;
    for (int i=0;i<s.length();i++)
    {
      numSum+=Character.getNumericValue((s.charAt(i)));
    }
    System.out.println(numSum);


  }

  public static BigInteger getCombinatoric(int n, int r)//n>=r
  {
    BigInteger result=new BigInteger("1");
    BigInteger decrease=new BigInteger("-1");
    int nc=n-r;

    if (r>nc)
    {
      while (n>nc)
      {
        result=result.multiply(new BigInteger(Integer.toString(n)));
        n--;
      }
      while (r>1)
      {
        result=result.divide(new BigInteger(Integer.toString(r)));
        r--;
      }
      return result;
    }
    else
    {
      while (n>r)
      {
        result=result.multiply(new BigInteger(Integer.toString(n)));
        n--;
      }
      while (nc>1)
      {
        result=result.divide(new BigInteger(Integer.toString(nc)));
        nc--;
      }
      return result;
    }
  }

  public static void combinatoric()
  {
    int count=0;
    for (int n=23;n<=100;n++)
    {
      for (int r=1;r<=n;r++)
      {
        System.out.println(n+":"+r);
        if (getCombinatoric(n,r).compareTo(new BigInteger("1000000"))==1)
        {
          count++;
        }
      }
    }
    System.out.println(count);
  }

  public static boolean fifthSum(int i)
  {
    String digits=""+i;
    int sum=0;
    int fifth=1;

    for (int j=0;j<digits.length();j++)
    {
     fifth=1;
     for (int k=0;k<5;k++)
     {
      fifth*=Character.getNumericValue(digits.charAt(j));
    }
    sum+=fifth;
  }
    //System.out.println(i+" : "+sum);
  if (sum==i)
  {
    return true;
  }
  return false;
  }

  public static void digitFifthPowers()
  {
    int count=0;
    for (int i=2;i<=295245;i++)
    {
      if (fifthSum(i))
      {
        count+=i;
      }
    }
    System.out.println(count);
  }

  public static boolean isLeftTrunc(int i)
  {
    String j=""+i;
    String t="";
    for (int k=0;k<j.length();k++)
    {
      t=j.substring(k);
      if (!isPrime(Integer.valueOf(t)))
      {
        return false;
      }
    }
    return true;
  }

  public static boolean isRightTrunc(int i)
  {
    String j=""+i;
    String t="";
    for (int k=j.length()-1;k>0;k--)
    {
      t=j.substring(0,k);
      if (!isPrime(Integer.valueOf(t)))
      {
        return false;
      }
    }
    return true;
  }

  public static void truncatablePrimes()
  {
    int count=0;
    int sum=0;
    int i=11;
    while (count<11)
    {
      if (isPrime(i)&&isLeftTrunc(i)&&isRightTrunc(i))
      {
        count++;
        sum+=i;
        System.out.println(i);
      }
      i+=2;
    }
    System.out.println(sum);
  }


  public static void getCoins()
  {
    //List<Coin> allCoins=new ArrayList<Coin>();
    int count=0;
    for (int thundreds=0;thundreds<=1;thundreds++)
    {
      for (int hundreds=0;hundreds<=2;hundreds++)
      {
        for (int fiftys=0;fiftys<=4;fiftys++)
        {
          for (int twenties=0;twenties<=10;twenties++)
          {
            for (int tens=0;tens<=20;tens++)
            {
              for (int fives=0;fives<=40;fives++)
              {
                for (int twos=0;twos<=100;twos++)
                {
                  for (int ones=0;ones<=200;ones++)
                  {
                    if (1*ones+2*twos+5*fives+10*tens+20*twenties+50*fiftys+100*hundreds+200*thundreds==200)
                    {
                      count++;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    System.out.println(count);

  }

  public static void selfPowers()
  {
    BigInteger sum=new BigInteger("0");
    BigInteger upperLimit=new BigInteger("1000");
    BigInteger i=new BigInteger("1");
    BigInteger one=new BigInteger("1");
    int pow=1;
    while (i.compareTo(upperLimit)!=1)
    {
      sum=sum.add(i.pow(pow));
      pow++;
      i=i.add(one);
    }
    System.out.println(sum);

  }

  public static boolean hasSameDigits(int num, int num2)
  {
    String a=""+num;
    String b=""+num2;
    char[] aa=a.toCharArray();
    char[] bb=b.toCharArray();
    if (a.length()!=b.length()) return false;
    Arrays.sort(aa);
    Arrays.sort(bb);
    for (int i=0;i<aa.length;i++)
    {
      if (aa[i]!=bb[i])
      {
        return false;
      }
    }
    return true;
  }

  public static void permutedMultiples()
  {
    boolean notFound=true;
    int i=0;
    while (notFound)
    {
      i++;
      if (hasSameDigits(i,2*i)&&hasSameDigits(i,3*i)&&hasSameDigits(i,4*i)
        &&hasSameDigits(i,5*i)&&hasSameDigits(i,6*i))
      {
        notFound=false;
      }
    }
    System.out.println(i);
  }

  //learning recursion

  public static int gcd(int p, int q)
  {
    if (q==0)
    {
      return p;
    }
    return gcd(q,p%q);
  }

  public static void moves(int n, boolean left)
  {
    if (n==0)
    {
      return;
    }
    moves(n-1, !left);
    if (left) System.out.println(n+" left");
    else System.out.println(n+" right");
    moves(n-1, !left);
  }

  public static List<String> combos=new ArrayList<String>();
  public static String storage="";
  public static void allCombos(String given) {
    if (given.length()==0)
    {
      combos.add(storage);
      storage="";
    }
    else
    {
      for (int i=0;i<given.length();i++) {
        storage+=given.substring(i,i+1);
        allCombos(given.substring(0,i)+given.substring(i+1));
      }
    }
  }

  // public static void allCombos(String given) {
  //   for (int i=0;i<given.length();i++) {

  //   }
  // }

  public static void fixCombos()
  {
    for (int i=0;i<combos.size()-1;i++)
    {
      if (combos.get(i+1).length()<combos.get(i).length())
      {
        int distance=combos.get(i).length()-combos.get(i+1).length();
        String temp=combos.get(i).substring(0,distance);
        combos.set(i+1,temp+combos.get(i+1));
      }
    }
  }

  public static void permutations(String given)
  {
    allCombos(given);
    fixCombos();
    //System.out.println(combos);
    //System.out.println("Total Combinations: "+combos.size());
  }

  public static boolean propertyHolds(String in)
  {
    if (Long.parseLong(in.substring(1,4))%2!=0)
    {
      return false;
    }
    if (Long.parseLong(in.substring(2,5))%3!=0)
    {
      return false;
    }
    if (Long.parseLong(in.substring(3,6))%5!=0)
    {
      return false;
    }
    if (Long.parseLong(in.substring(4,7))%7!=0)
    {
      return false;
    }
    if (Long.parseLong(in.substring(5,8))%11!=0)
    {
      return false;
    }
    if (Long.parseLong(in.substring(6,9))%13!=0)
    {
      return false;
    }
    if (Long.parseLong(in.substring(7))%17!=0)
    {
      return false;
    }
    return true;
  }

  public static void substringDivisibility()
  {
    permutations("0123456789");
    long sum=0l;
    for (int i=0;i<combos.size();i++)
    {
      if (propertyHolds(combos.get(i)))
      {
        System.out.println(combos.get(i));
        sum+=(Long.parseLong(combos.get(i)));
      }
    }
    System.out.println(sum);
  }

  public static void panPrime()
  {
    String to="";
    int max=-1;
    for (int i=1;i<=9;i++)
    {
      to+=i;
      combos.clear();
      permutations(to);
      for (int j=0;j<combos.size();j++)
      {
        if (isPrime(Integer.parseInt(combos.get(j)))&&Integer.parseInt(combos.get(j))>max)
        {
          max=Integer.parseInt(combos.get(j));
        }
      }
    }
    System.out.println(max);
  }

  public static void panProducts()
  {
    permutations("123456789");
    for (int i=0;i<combos.size();i++)
    {
      hasPandigitalProd(combos.get(i));
    }
    long sum=0l;
    for (int i=0;i<toProduct.size();i++)
    {
      sum+=toProduct.get(i);
    }
    System.out.println(sum);
  }

  public static List<Long> toProduct=new ArrayList<Long>();
  public static boolean hasPandigitalProd(String in)
  {
    long multiplicand;
    long multiplier;
    for (int i=0;i<in.length();i++)
    {
      multiplicand=Long.parseLong(in.substring(0,i+1));
      for (int j=2;j<in.length()-i;j++)
      {
        multiplier=Long.parseLong(in.substring(i+1,i+j));
        if (multiplicand*multiplier==Long.parseLong(in.substring(i+j)))
        {
          System.out.println("COINTAINS PRODUCT");
          if (!toProduct.contains(Long.parseLong(in.substring(i+j))))
          {
            System.out.println(multiplicand+" X "+multiplier+" = "+in.substring(i+j));
            toProduct.add(Long.parseLong(in.substring(i+j)));
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void circularPrimes()
  {
    int count=1;
    for (int i=3;i<1000000;i+=2)
    {
      if (isCircularPrime(i))
      {
        System.out.println(i);
        count++;;
      }
    }
    System.out.println(count);
  }

  public static boolean isCircularPrime(int i)
  {
    if (!isPrime(i))
    {
      return false;
    }
    String num=""+i;
    String n=num.substring(1)+num.charAt(0);
    while(!n.equals(num))
    {
      if (!isPrime(Integer.parseInt(n)))
      {
        return false;
      }
      n=n.substring(1)+n.charAt(0);
    }
    return true;
  }

  public static void primeSum()
  {
    int max=0;
    int loc=-1;
    primes.add(2);
    for (int i=3;i<1000000;i+=2)
    {
      if(isPrime(i))
      {
        primes.add(i);
      }
    }
    for (int i=0;i<primes.size();i++)
    {
      System.out.println(primes.get(i));
      if (getMaxConsecutive(i)>max)
      {
        max=getMaxConsecutive(i);
        loc=i;
      }
    }
    System.out.println(primes.get(loc));
  }

  //in is the index of the prime whose highest consecutive sum should be returned
  public static int getMaxConsecutive(int in)
  {
    int  maxPath=0;
    int sum=0;
    int count=0;
    for (int i=0;i<in;i++)//index of the first consecutive number
    {
      sum=0;
      count=0;
      for (int j=i;j<in;j++)//actually calculates the sum from the first num
      {
        sum+=primes.get(j);
        count++;
        if (sum==primes.get(in)&&count>maxPath)
        {
          maxPath=count;
          j=in;
        }
        else if (sum>primes.get(in))
        {
          j=in;
        }
      }
    }
    return maxPath;
  }

  //maximum path sum
  public static void getMaxPath(String inString)
  {
    List<Integer> allNums=new ArrayList<Integer>();
    for (int i=0;i<inString.length();i+=3)
    {
      String number=inString.substring(i,i+2);
      allNums.add(Integer.parseInt(number));
    }

    Pyramid pyramid=new Pyramid(100, allNums);
    System.out.println(pyramid.maxSum());
  }

  public static void getNameVal(String n)
  {
    long sum=0l;
    n=n.replaceAll("\"","");
    List<String> allNames=orderNames(n);
    allNames=alphabeticalOrder(allNames);
    //System.out.println(allNames.get(936));
    //System.out.println(getNameScores("COLIN",938));
    System.out.println(allNames.size());
    for (int i=0;i<allNames.size();i++)
    {
      sum+=getNameScores(allNames.get(i),i+1);
    }

    System.out.println(sum);
  }

  public static List<String> alphabeticalOrder(List<String> allNames)
  {
    String temp;
    for (int i=0;i<allNames.size();i++)
    {
      for (int j=i+1;j<allNames.size();j++)
      {
        if (comesBefore(allNames.get(j),allNames.get(i)))
        {
          temp=allNames.get(i);
          allNames.set(i,allNames.get(j));
          allNames.set(j,temp);
        }
      }
    }
    return allNames;
  }

  public static boolean comesBefore(String a, String b)
  {
    for (int i=0;i<a.length()&&i<b.length();i++)
    {
      if (a.charAt(i)<b.charAt(i))
      {
        return true;
      }
      else if (a.charAt(i)>b.charAt(i))
      {
        return false;
      }
    }
    if (a.length()>b.length())
    {
      return false;
    }
    return true;
  }

  public static List<String> orderNames(String n)
  {
    List<String> allNames=new ArrayList<String>();
    int beg=0;
    for (int i=0;i<n.length();i++)
    {
      if (n.charAt(i)==',')
      {
        allNames.add(n.substring(beg,i));
        beg=i+1;
      }
    }
    allNames.add("YOUTH");
    return allNames;
  }

  public static long getNameScores(String n, int pos)
  {
    long total=0l;
    for (int i=0;i<n.length();i++)
    {
      if (n.charAt(i)=='A') total+=1;
      else if (n.charAt(i)=='B') total+=2;
      else if (n.charAt(i)=='C') total+=3;
      else if (n.charAt(i)=='D') total+=4;
      else if (n.charAt(i)=='E') total+=5;
      else if (n.charAt(i)=='F') total+=6;
      else if (n.charAt(i)=='G') total+=7;
      else if (n.charAt(i)=='H') total+=8;
      else if (n.charAt(i)=='I') total+=9;
      else if (n.charAt(i)=='J') total+=10;
      else if (n.charAt(i)=='K') total+=11;
      else if (n.charAt(i)=='L') total+=12;
      else if (n.charAt(i)=='M') total+=13;
      else if (n.charAt(i)=='N') total+=14;
      else if (n.charAt(i)=='O') total+=15;
      else if (n.charAt(i)=='P') total+=16;
      else if (n.charAt(i)=='Q') total+=17;
      else if (n.charAt(i)=='R') total+=18;
      else if (n.charAt(i)=='S') total+=19;
      else if (n.charAt(i)=='T') total+=20;
      else if (n.charAt(i)=='U') total+=21;
      else if (n.charAt(i)=='V') total+=22;
      else if (n.charAt(i)=='W') total+=23;
      else if (n.charAt(i)=='X') total+=24;
      else if (n.charAt(i)=='Y') total+=25;
      else total+=26;
    }
    total*=pos;
    //System.out.println(n+" :"+pos);
    return total;
  }

  public static void codedTriangleNums(String n)
  {
    int count=0;
    updateNums();
    System.out.println("Triangle Numbers added");
    n=n.replaceAll("\"","");
    List<String> allNames=orderNames(n);

    for (int i=0;i<allNames.size();i++)
    {
      if (isTriNum(alphaValue(allNames.get(i))))
      {
        count++;
      }
    }
    System.out.println(count);
  }

  public static List<Integer> triNums=new ArrayList<Integer>();
  public static void updateNums()
  {
    for (int i=0;i<1000;i++)
    {
      triNums.add(i*(i+1)/2);
    }
  }

  public static int alphaValue(String n)
  {
    int total=0;
    for (int i=0;i<n.length();i++)
    {
      if (n.charAt(i)=='A') total+=1;
      else if (n.charAt(i)=='B') total+=2;
      else if (n.charAt(i)=='C') total+=3;
      else if (n.charAt(i)=='D') total+=4;
      else if (n.charAt(i)=='E') total+=5;
      else if (n.charAt(i)=='F') total+=6;
      else if (n.charAt(i)=='G') total+=7;
      else if (n.charAt(i)=='H') total+=8;
      else if (n.charAt(i)=='I') total+=9;
      else if (n.charAt(i)=='J') total+=10;
      else if (n.charAt(i)=='K') total+=11;
      else if (n.charAt(i)=='L') total+=12;
      else if (n.charAt(i)=='M') total+=13;
      else if (n.charAt(i)=='N') total+=14;
      else if (n.charAt(i)=='O') total+=15;
      else if (n.charAt(i)=='P') total+=16;
      else if (n.charAt(i)=='Q') total+=17;
      else if (n.charAt(i)=='R') total+=18;
      else if (n.charAt(i)=='S') total+=19;
      else if (n.charAt(i)=='T') total+=20;
      else if (n.charAt(i)=='U') total+=21;
      else if (n.charAt(i)=='V') total+=22;
      else if (n.charAt(i)=='W') total+=23;
      else if (n.charAt(i)=='X') total+=24;
      else if (n.charAt(i)=='Y') total+=25;
      else total+=26;
    }
    //System.out.println(n+" :"+pos);
    return total;
  }


  public static boolean isTriNum(int a)
  {
    return triNums.contains(a);
  }

  public static void primePerms()
  {
    List<Integer> primeNums=new ArrayList<Integer>();
    for (int i=1000;i<=9999;i++)
    {
      if (isPrime(i))
      {
        primeNums.add(i);
      }
    }
    System.out.println("Primes Added to Array: "+primeNums.size());

    for (int i=0;i<primeNums.size();i++)
    {
      for (int seq=1;seq*2+primeNums.get(i)<=9999;seq++)
      {
        if (isPermutation(""+primeNums.get(i),""+(primeNums.get(i)+seq))&&(isPermutation(""+primeNums.get(i),""+(primeNums.get(i)+2*seq))))
        {
          if (primeNums.contains(primeNums.get(i)+seq)&&primeNums.contains(primeNums.get(i)+2*seq))
          {
            System.out.println(""+primeNums.get(i)+(primeNums.get(i)+seq)+(primeNums.get(i)+seq+seq));
          }
        }
      }
    }

  }

  public static boolean isPermutation(String a, String b)
  {
    if (a.length()!=b.length()) return false;
    for (int i=0;i<a.length();i++)
    {
      if (b.contains(a.substring(i,i+1)))
      {
        b=b.replaceFirst(a.substring(i,i+1),"");
      }
      else
      {
        return false;
      }
    }
    return true;
  }

  public static void panDigitalMultiples()
  {
    List<Integer> aCombos=new ArrayList<Integer>();

    permutations("123456789");
    for (int i=0;i<combos.size();i++)
    {
      if (Integer.parseInt(combos.get(i))>918273645)
      {
        aCombos.add(Integer.parseInt((combos.get(i))));
      }
    }

    List<Integer> n=new ArrayList<Integer>();
    n.add(9);
    for (int i=91;i<=98;i++)
    {
      n.add(i);
    }
    for (int i=912;i<=987;i++)
    {
      n.add(i);
    }
    for (int i=9123;i<=9876;i++)
    {
      n.add(i);
    }
    for (int i=91234;i<=98765;i++)
    {
      n.add(i);
    }
    for (int i=0;i<n.size();i++)
    {
      int j=2;
      String k=""+n.get(i);
      while (k.length()<9)
      {
        k+=(n.get(i)*j);
        j++;
      }
      if (combos.contains(k))
      {
        System.out.println(k);
      }
    }

  }

  public static void lychrelNums()
  {
    int count=0;
    for (int i=0;i<10000;i++)
    {
      if (isLychrel(i))
      {
        //System.out.println(i);
        count++;
      }
    }
    System.out.println(count);
  }

  public static boolean isLychrel(int j)
  {
    int iterations=0;
    BigInteger l = new BigInteger(""+j);
    while (iterations<50)
    {
      //System.out.println(l+" "+ reverse(l)+" "+ (l.add(reverse(l))));
      l=l.add(new BigInteger(""+reverse(l)));
      if (getPalindrome(l.toString()))
      {
        return false;
      }
      iterations++;
    }
    return true;
  }

  public static BigInteger reverse(BigInteger a)
  {
    String num=""+a;
    String result="";
    for (int i=num.length()-1;i>=0;i--)
    {
      result+=num.charAt(i);
    }
    return new BigInteger(result);
  }

  public static void distinctPrimeFactors()
  {
    for (int i=2;i<1000000;i++)
    {
      if (isPrime(i))
      {
        primes.add(i);
      }
    }
    System.out.println("primes added");

    for (int i=100000;i<=1000000;i++)
    {
      //System.out.println(i);
      if (haveDistinctPrimeFactors(i))
      {
        System.out.println(i+" "+(i+1)+" "+(i+2)+" "+(i+3));
        i=1000000000;
      }
    }
  }

  public static boolean haveDistinctPrimeFactors(int i)
  {
    if (getPrimeFactors(i)&&getPrimeFactors(i+1)&&getPrimeFactors(i+2)&&getPrimeFactors(i+3))
      return true;
    return false;
  }

  public static List<BigInteger> pNums= new ArrayList<BigInteger>();

  public static void pentaNums()
  {
    updateNums(new BigInteger("10000"));
    System.out.println("Numbers Updated");
    for (int i=0;i<pNums.size();i++)
    {
      for (int j=i+1;j<pNums.size();j++)
      {
        System.out.println(i+" "+j);
        if (sumDiffPenta(pNums.get(i),pNums.get(j)))
        {
          System.out.println("FOUND!!");
          System.out.println(pNums.get(i));
          System.out.println(pNums.get(j));

          i=pNums.size();
          j=pNums.size();
        }
      }
    }
  }

  public static boolean sumDiffPenta(BigInteger a, BigInteger b)
  {
    return (pNums.contains(b.subtract(a))&&pNums.contains(a.add(b)));
  }

  public static void updateNums(BigInteger compare)
  {
    BigInteger i=new BigInteger("1");
    while (i.compareTo(compare)==-1)
    {
      pNums.add(i.multiply(i.multiply(new BigInteger("3")).subtract(new BigInteger("1"))).divide(new BigInteger("2")));
      i=i.add(new BigInteger("1"));
      //System.out.println(i);
    }
  }

  public static void digitCancellingFractions() {
    for (int numerator=10;numerator<=99;numerator++) {
      for (int denominator=10;denominator<numerator;denominator++) {
        if (isBadSimplification(denominator, numerator)) {
          //System.out.println(denominator+" / "+numerator);
        }
      }
    }
  }

  public static boolean isBadSimplification(int num, int den) {
    String n=""+num;
    String d=""+den;
    double sol=(double)num/den;

    double nn;
    double dd;

    if (n.charAt(0)==d.charAt(0)) {
      nn=Character.getNumericValue(n.charAt(1));
      dd=Character.getNumericValue(d.charAt(1));
      if (dd!=0&&nn/dd==sol) {
        System.out.println(num+"/"+den+" = "+sol+" "+nn+"/"+dd);
        return true;
      }
    }

    if (n.charAt(1)==d.charAt(0)) {
      nn=Character.getNumericValue(n.charAt(0));
      dd=Character.getNumericValue(d.charAt(1));
      if (dd!=0&&nn/dd==sol) {
        System.out.println(num+"/"+den+" = "+sol+" "+nn+"/"+dd);
        return true;
      }
    }

    if (n.charAt(0)==d.charAt(1)) {
      nn=Character.getNumericValue(n.charAt(1));
      dd=Character.getNumericValue(d.charAt(0));
      if (dd!=0&&nn/dd==sol) {
        System.out.println(num+"/"+den+" = "+sol+" "+nn+"/"+dd);
        return true;
      }
    }

    if (n.charAt(1)==d.charAt(1)) {
      nn=Character.getNumericValue(n.charAt(0));
      dd=Character.getNumericValue(d.charAt(0));
      if (dd!=0&&nn/dd==sol) {
        System.out.println(num+"/"+den+" = "+sol+" "+nn+"/"+dd);
        return true;
      }
    }

    return false;
  }

  public static int factorial(int n)
  {
    if (n<=1) return 1;
    return n*factorial(n-1);
  }

  public static List<Integer> primeFactor=new ArrayList<Integer>();

  public static boolean getPrimeFactors(int in)
  {
    //System.out.print(in+": ");
    primeFactor.clear();
    while (in!=1)
    {
      for (int i=0;i<primes.size()&&primes.get(i)<=in;i++)
      {
        while (in%primes.get(i)==0)
        {
          if (!primeFactor.contains(primes.get(i)))
          {
            primeFactor.add(primes.get(i));
          }
          in=in/primes.get(i);
        }
      }
    }
    //System.out.println(primeFactor);
    if (primeFactor.size()==4)
    {
      return true;
    }
    return false;
  }

  public static void digitFactorials() {
    for (long i=10l;i<Integer.MAX_VALUE;i++) {
      long sum=0l;
      String n=""+i;
      for (int j=0;j<n.length()&&sum<i;j++) {
        sum+=factorial((Character.getNumericValue(n.charAt(j))));
      }
      if (sum==i) {
        System.out.println(sum+" : "+i);
      }
    }
  }

  public static void champernownesConstant() {
    int d1=1;
    int d10=1;
    String n="";
    for (int i=1;i<=210000;i++) {
      n+=i;
    }
    System.out.println("Done Printing");
    System.out.println("Size = "+n.length());
    int d100=Character.getNumericValue(n.charAt(100-1));
    int d1000=Character.getNumericValue(n.charAt(1001-2));
    int d10000=Character.getNumericValue(n.charAt(10001-2));
    int d100000=Character.getNumericValue(n.charAt(100001-2));
    int d1000000=Character.getNumericValue(n.charAt(1000001-2));

    System.out.println(d100);
    System.out.println(d1000);
    System.out.println(d10000);
    System.out.println(d100000);
    System.out.println(d1000000);
    System.out.println();
    System.out.println(d1*d10*d100*d1000*d10000*d100000*d1000000);

    System.out.println();

    //System.out.println(n);
  }

  public static int count=0;
  public static void fourDice() {
    ArrayList<Integer> sideVals = new ArrayList<>();
    for (int i=1;i<=12;i++) {
      sideVals.add(i);
    }

    for (int a=0;a<sideVals.size();a++) {
      ArrayList<Integer> sideVals1= new ArrayList(sideVals);
      sideVals1.remove(a);
      for (int b=0;b<sideVals1.size();b++) {
        ArrayList<Integer> sideVals2= new ArrayList(sideVals1);
        sideVals2.remove(b);
        for (int c=0;c<sideVals2.size();c++) {
          ArrayList<Integer> sideVals3= new ArrayList(sideVals2);
          sideVals3.remove(c);
          for (int d=0;d<sideVals3.size();d++) {
            ArrayList<Integer> sideVals4= new ArrayList(sideVals3);
            sideVals4.remove(d);
            for (int e=0;e<sideVals4.size();e++) {
              ArrayList<Integer> sideVals5= new ArrayList(sideVals4);
              sideVals5.remove(e);
              for (int f=0;f<sideVals5.size();f++) {
                ArrayList<Integer> sideVals6= new ArrayList(sideVals5);
                sideVals6.remove(f);
                for (int g=0;g<sideVals6.size();g++) {
                  ArrayList<Integer> sideVals7= new ArrayList(sideVals6);
                  sideVals7.remove(g);
                  for (int h=0;h<sideVals7.size();h++) {
                    ArrayList<Integer> sideVals8= new ArrayList(sideVals7);
                    sideVals8.remove(h);
                    for (int i=0;i<sideVals8.size();i++) {
                      ArrayList<Integer> sideVals9= new ArrayList(sideVals8);
                      sideVals9.remove(i);
                      for (int j=0;j<sideVals9.size();j++) {
                        ArrayList<Integer> sideVals10= new ArrayList(sideVals9);
                        sideVals10.remove(j);
                        for (int k=0;k<sideVals10.size();k++) {
                          ArrayList<Integer> sideVals11= new ArrayList(sideVals10);
                          sideVals11.remove(k);
                          for (int l=0;l<sideVals11.size();l++) {
                            diceTricks(sideVals.get(a),sideVals1.get(b),sideVals2.get(c),sideVals3.get(d),
                              sideVals4.get(e),sideVals5.get(f),sideVals6.get(g),sideVals7.get(h),
                              sideVals8.get(i),sideVals9.get(j),sideVals10.get(k),sideVals11.get(l));
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    System.out.println(count);
  }

  public static void diceTricks(int e,int f, int g,int h, int i, int j, int k,
    int l, int m, int n, int o, int p) {
    Dice d= new Dice(e,f,g);
    Dice c= new Dice(h,i,j);
    Dice b= new Dice(k,l,m);
    Dice a=new Dice(n,o,p);
    if (a.beats(b)&&b.beats(c)&&c.beats(d)&&d.beats(a)) {
      count++;
      System.out.println("this works");
      System.out.println(a);
      System.out.println(b);
      System.out.println(c);
      System.out.println(d);
    }

  }

  public static int getGCD(int p, int q) {
    if (q==0) return p;
    else return gcd(q, p%q);
  }

  //sieve of eratoshetenes for prime numbers
  public static boolean[] simpleSieve(int n)
  {
      boolean[] sieve = new boolean[n+1];  //false = prime, true = composite
      sieve[0] = true; sieve[1] = true; sieve[2] = false;

      for(int i = 4; i <= n; i+=2)
        { sieve[i] = true; }

      int limit = (int)Math.sqrt(n)+1;
      for(int i = 3; i < limit; i+=2)
      {
          if(!sieve[i]) //if prime (or not composite)
          {
              for(int j = i*i; j <= n; j+=i) //mark all multiples of i as composite
              { sieve[j] = true; }
            }
          }

          return sieve;
  }


  public static void totientMaximum() {
    updatePrimes();
    double max=-1;
    int loc=1;
    System.out.println();
    for (int i=2;i<=1000000;i++) {
      System.out.println(i);
      ArrayList<Integer> pfactors= getPrimeFactorss(i);
      double q=i;
      for (int j=0;j<pfactors.size();j++) {
        q*=(1.0-1.0/pfactors.get(j));
      }
      if (i/q>max) {
        loc=i;
        max=i/q;
      }
    }
    System.out.println(loc);
  }

  public static ArrayList<Integer> primes= new ArrayList<>();

  public static void updatePrimes() {
    primes.add(2);
    for (int i=3;i<=1000000;i+=2) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    System.out.println("Primes updated");
  }

  public static ArrayList<Integer> getPrimeFactorss(int n) {
    ArrayList<Integer> primeFactors= new ArrayList<>();
    for (int i=0;i<primes.size()&&primes.get(i)<=n;i++) {
      if (n%primes.get(i)==0) {
        primeFactors.add(primes.get(i));
      }
    }
    return primeFactors;
  }

  public static void poker(String [] comeIn)
  {
    int player1w=0;
    for (int i=0;i<comeIn.length;i++)
    {
      Card[] player1=new Card[5];
      Card[] player2=new Card[5];
      int cardNum=0;
//System.out.println(comeIn[i].length());
      for (int j=0;j<15;j+=3)
      {
        player1[cardNum]=new Card(comeIn[i].substring(j,j+2));
        cardNum++;
      }
      cardNum=0;
      for (int j=15;j<comeIn[i].length();j+=3)
      {
        player2[cardNum]=new Card(comeIn[i].substring(j,j+2));
        cardNum++;
      }

      Hand p1=new Hand(player1);
      Hand p2=new Hand(player2);

      if (p1.beats(p2))
      {
        player1w++;
      }

      System.out.println(p1+": "+p2);
    }
    System.out.println(player1w);
  }

  public static int lcm (int a, int b) {
    return (a*b)/gcd(a,b);
  }

// public static void xorDecryption(String [] comeIn) {

// }

  public static void squareRootConvergents() {
    int count=0;
    for (int i=0;i<999;i++) {
      Fraction one = new Fraction(BigInteger.ONE);
      Fraction two = new Fraction(new BigInteger("2"));
      Fraction fr = new Fraction(new BigInteger("2"),new BigInteger("5"));

//not sure exactly how to format the for loop
      for (int j=i;j>0;j--) {
        fr.add(two);
        fr.complement();
      }
      fr.add(one);
      if (fr.numMoreDigits()) count++;
      System.out.println((i+2) + " : " + fr.numMoreDigits());
    }
    System.out.println("Count: " + count);
  }

  public static void countingFractionsInARange() {
    SmallFraction fr;
    int count =0;
    HashSet<SmallFraction> fractions = new HashSet<>();
    for (int d=1;d<=12000;d++) {
      System.out.println(d);

      int start = d/3;
      double end = d/2.0;
      for (int n=start;n<end;n++) {
        fr = new SmallFraction(n,d);
        fractions.add(fr);
      }
    }
    fractions.add(new SmallFraction(1,3));
    fractions.add(new SmallFraction(1,2));
    List<SmallFraction> list = new ArrayList(fractions);
    Collections.sort(list);
    int beg = list.indexOf(new SmallFraction(1, 3));
    int end = list.indexOf(new SmallFraction(1, 2));
    list = list.subList(beg+1, end);
    for (SmallFraction f:list) {
      if (f.getGCD()) count++;
    }
    System.out.println(list);
    System.out.println(count);
  }

  public static void digitFactorialChains() {
//in this array, c[i] represents the longest non-repeating chain starting with number i
// int[] c = new int[1000001];
// Arrays.fill(c,-1);
    int count=0;
    for (int i=1;i<=1000000;i++) {
      System.out.println(i);
//   int j=i;
//   if (c[j]!=-1) {
//     return c[j];
//   }
//   else {
//     j=getDigitFactorial(j);
//   }

      if(getChainLength(i)==60) {
        count++;
      }
    }
    System.out.println(count);


  }

  public static int getChainLength(int n) {
    HashSet<Integer> integers = new HashSet<>();
    integers.add(n);
    boolean truth=true;
    int count=0;
    while (truth) {
      n=getDigitFactorial(n);
      truth=integers.add(n);
      count++;
    }
    return count;
  }

  public static BigInteger getFactorial(int i)
  {
    BigInteger toReturn= new BigInteger("1");
    BigInteger result = new BigInteger(""+i);
    BigInteger negate = new BigInteger("-1");
    while (result.compareTo(BigInteger.ONE)==1)
    {
      toReturn=toReturn.multiply(result);
      result=result.add(negate);
    }
    return toReturn;
  }

  public static int getDigitFactorial(int i) {
    String s=""+i;
    int fact = 0;
    for (int j=0;j<s.length();j++) {
      fact+=factorial(Integer.parseInt(s.substring(j,j+1)));
    }
    return fact;
  }

  public static void sudoku(String [] in) {
    // int sum=0;
    // String [] puzzle = new String[10];
    // for (int i=0;i<in.length;i+=10) {
    //   for (int j=0;j<puzzle.length;j++) {
    //     puzzle[j]=in[i+j];
    //   }
    //   Sudoku s = new Sudoku(puzzle);
    //   sum+=s.getTopLeft();
    // }
    // System.out.println();
    // System.out.println("sum: "+sum);

  String[] puzzle = new String[10];
  for(int i=0;i<10;i++) {
    puzzle[i]=in[i];
  }
  Sudoku one = new Sudoku(puzzle);
  System.out.println(one);
      }

  public static void squareDigitChains() {
    int count=0;
    for (int i=1;i<=10000000;i++) {
      if (getSquareDigitChain(i)==89) {
        count++;
        System.out.println(i);
      }
    }
    System.out.println(count);
  }

  public static int getSquareDigitChain(int a) {
    if (a==1) {
      return 1;
    }
    if (a==89) {
      return 89;
    }
    String s=""+a;
    a=0;
    int b;
    for (int i=0;i<s.length();i++) {
      b=(Integer.parseInt(s.substring(i,i+1)));
      a+=b*b;
    }
    return getSquareDigitChain(a);
  }

  public static void largeNonMarsenneNumber() {
    BigInteger num = new BigInteger("2");
    num = num.pow(7830457);
    num = num.multiply(new BigInteger("28433"));
    num = num.add(BigInteger.ONE);

    String s = num.toString();
    for (int i=s.length()-10;i<s.length();i++) {
      System.out.print(s.charAt(i));
    }
  }

  public static void romanNumerals(String [] in) {
    int totalSaved=0;
    for (int i=0;i<in.length;i++) {
      Roman one = new Roman(in[i]);
      totalSaved+=one.numSaved();

    }
    System.out.println("Total Saved: " + totalSaved);
  }

  public static int bouncyNums=0;
  public static void bouncyNumbers() {
    int i=100;
    boolean found=false;
    while (!found) {
      if (getProportionBouncy(i)==99.0) {
        found=true;
        System.out.println(i);
      }
      i++;
    }
  }

  public static void nonBouncyNumbers() {
    int k=0;
    BigInteger googol = new BigInteger("10");
    googol = googol.pow(100);
    for (BigInteger i=BigInteger.ONE;i.compareTo(googol)!=1;i=i.add(BigInteger.ONE)) {
      String s = i.toString();
      if (isIncreasing(s)||isDecreasing(s)) {
        k++;
      }
      System.out.println(s);
    }
    System.out.println(k);
  }

  public static double getProportionBouncy(int i) {
    if (isBouncy(i)) {
      bouncyNums++;
    }
    return (100.0*bouncyNums/i);
  }

  public static boolean isBouncy(int i) {
    String s=""+i;
    if (!isIncreasing(s)&&!isDecreasing(s)) {
      return true;
    }
    return false;
  }

  public static boolean isIncreasing(String s) {
    for (int i=1;i<s.length();i++) {
      if (s.charAt(i)<s.charAt(i-1)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isDecreasing(String s) {
    for (int i=1;i<s.length();i++) {
      if (s.charAt(i)>s.charAt(i-1)) {
        return false;
      }
    }
    return true;
  }

  public static void numberSpiralDiagnosis() {
    Spiral spiral = new Spiral(1001);
  }

  public static void spiralPrimes() {
    int totalDiagonals=1;
    int primeDiagonals=0;
    boolean found=false;
    int i=3;
    int square;
    int separation=2;
    int bottomLeft;
    int topLeft;
    int topRight;
    while (!found) {
      totalDiagonals+=4;
      square=i*i;
      bottomLeft=square-separation;
      topLeft=bottomLeft-separation;
      topRight=topLeft-separation;
      if (isPrime(bottomLeft)) {
        primeDiagonals++;
      }
      if (isPrime(topLeft)) {
        primeDiagonals++;
      }
      if (isPrime(topRight)) {
        primeDiagonals++;
      }

      if (primeDiagonals*100.0/totalDiagonals<10.0) {
        found=true;
        System.out.println(primeDiagonals+"/"+totalDiagonals);
        System.out.println(i);
      }
      // if (i==7) {
      //   found=true;
      //   System.out.println(primeDiagonals+"/"+totalDiagonals);
      //   System.out.println(i);
      // }
      separation+=2;
      i+=2;
    }
  }

  public static void primeDigitReplacements() {

  }























    }



