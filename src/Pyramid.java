import java.util.*;
public class Pyramid
{
    List<Integer> allNums;
    int rows;

    public Pyramid(int inRows, List<Integer> inAllNums)
    {
        allNums=inAllNums;
        rows=inRows;
    }

    public int maxSum()
    {
        while (rows!=1)
        {
            rowDown();
            p();
            System.out.println();
            System.out.println();
        }
        return(allNums.get(0));
    }

    public void rowDown()
    {
        List<Integer> toDelete=new ArrayList<Integer>();
        List<Integer> ultimate=new ArrayList<Integer>();

        for(int i=1;i<=rows;i++)
        {
            toDelete.add(allNums.get(allNums.size()-i));
        }
        for (int i=1;i<=rows-1;i++)
        {
            ultimate.add(allNums.get(allNums.size()-i-rows));
        }

        for (int i=0;i<rows-1;i++)
        {
            if (toDelete.get(i)>toDelete.get(i+1))
            {
                ultimate.set(i,toDelete.get(i)+ultimate.get(i));
            }
            else
            {
                ultimate.set(i,toDelete.get(i+1)+ultimate.get(i));
            }
        }

        allNums.subList(allNums.size()-rows, allNums.size()).clear();

        for (int i=1;i<=ultimate.size();i++)
        {
            allNums.set(allNums.size()-i,ultimate.get(i-1));
        }
        rows--;
    }

    public void p()
    {
        int inRows=1;
        int toPrint=0;
        int i=0;
        while (inRows<=rows)
        {
            System.out.print(allNums.get(toPrint+i)+" ");
            i++;
            if (i==inRows)
            {
                System.out.println();
                inRows++;
                toPrint+=i;
                i=0;
            }
        }
    }


}