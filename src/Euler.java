import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.Math;
import java.io.IOException;
public class Euler
{
  public static void main(String [] args) throws IOException
  {
    long start = System.nanoTime();

    FileData boo=new FileData();
    String [] moo=boo.moo();
    String [] hoo=new String [moo.length-1];
    for (int i=0;i<hoo.length;i++)
    {
        hoo[i]=moo[i];
        //System.out.println(hoo[i]);
    }
    Prime.sudoku(hoo);


    //Prime.primeDigitReplacements();


    System.out.println();
    System.out.println("Time: " + ((System.nanoTime()-start)/Math.pow(10,6)) + " milliseconds");
  }
}