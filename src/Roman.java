import java.util.ArrayList;
public class Roman {

    //instance variables
    private int beg;
    private int end;

    public Roman(String in) {
        beg=in.length();
        System.out.println(in);
        //first, separate into different pairs
        ArrayList<String> pairs = getPairs(in);
        System.out.println(pairs);
        //then, get value of each pair, and add
        int value = getValue(pairs);
        //now, find the most efficient way to write the numerals
        String l = getMostEfficient(value);
        System.out.println(l);
        System.out.println(value);
        end=l.length();
        System.out.println();
    }

    public int numSaved() {
        return beg-end;
    }

    public String getMostEfficient(int value) {
        String eff = "";
        while (value>=1000) {
            eff+="M";
            value-=1000;
        }
        while (value>=900) {
            eff+="CM";
            value-=900;
        }
        while (value>=500) {
            value-=500;
            eff+="D";
        }
        while (value>=400) {
            value-=400;
            eff+="CD";
        }
        while (value>=100) {
            value-=100;
            eff+="C";
        }
        while (value>=90) {
            value-=90;
            eff+="XC";
        }
        while (value>=50) {
            value-=50;
            eff+="L";
        }
        while (value>=40) {
            value-=40;
            eff+="XL";
        }
        while (value>=10) {
            value-=10;
            eff+="X";
        }
        while (value>=9) {
            value-=9;
            eff+="IX";
        }
        while (value>=5) {
            value-=5;
            eff+="V";
        }
        while (value>=4) {
            value-=4;
            eff+="IV";
        }
        while (value>=1) {
            value-=1;
            eff+="I";
        }
        return eff;
    }

    public int getValue(ArrayList<String> pairs) {
        int j=0;
        for (int i=0;i<pairs.size();i++) {
            if (pairs.get(i).equals("M")) {
                j+=1000;
            }
            else if (pairs.get(i).equals("D")) {
                j+=500;
            }
            else if (pairs.get(i).equals("C")) {
                j+=100;
            }
            else if (pairs.get(i).equals("L")) {
                j+=50;
            }
            else if (pairs.get(i).equals("X")) {
                j+=10;
            }
            else if (pairs.get(i).equals("V")) {
                j+=5;
            }
            else if (pairs.get(i).equals("I")) {
                j+=1;
            }
            else if (pairs.get(i).equals("IV")) {
                j+=4;
            }
            else if (pairs.get(i).equals("IX")) {
                j+=9;
            }
            else if (pairs.get(i).equals("XL")) {
                j+=40;
            }
            else if (pairs.get(i).equals("XC")) {
                j+=90;
            }
            else if (pairs.get(i).equals("CD")) {
                j+=400;
            }
            else if (pairs.get(i).equals("CM")) {
                j+=900;
            }
        }
        return j;
    }

    public ArrayList<String> getPairs(String in) {
        ArrayList<String> pairs = new ArrayList<>();
        boolean samePair = true;
        for (int i=0;i<in.length();i++) {
            if (in.charAt(i)=='I') {
                if (i+1<in.length()) {
                    if (in.charAt(i+1)=='X'||in.charAt(i+1)=='V') {
                        pairs.add(in.substring(i,i+2));
                    }
                    else {
                        pairs.add(in.substring(i,i+1));
                    }
                }
                else {
                    pairs.add(in.substring(i,i+1));
                }
            }
            else if (in.charAt(i)=='V') {
                if (i-1>=0) {
                    if (in.charAt(i-1)=='I') {
                        //do nothing
                    }
                    else {
                        pairs.add(in.substring(i,i+1));
                    }
                }
                else {
                    pairs.add(in.substring(i,i+1));
                }
            }
            else if (in.charAt(i)=='X') {
                if (i-1>=0&&in.charAt(i-1)=='I') {
                    //do nothing
                }
                else if (i+1<in.length()&&((in.charAt(i+1)=='L'||in.charAt(i+1)=='C'))) {
                        pairs.add(in.substring(i,i+2));
                }
                else {
                    pairs.add(in.substring(i,i+1));
                }
            }
            else if (in.charAt(i)=='L') {
                if (i-1>=0&&in.charAt(i-1)=='X') {
                    //do nothing
                }
                else {
                    pairs.add(in.substring(i,i+1));
                }
            }
            else if (in.charAt(i)=='C') {
                if (i-1>=0&&in.charAt(i-1)=='X') {
                    //do nothing
                }
                else if (i+1<in.length()&&(in.charAt(i+1)=='D'||in.charAt(i+1)=='M')) {
                        pairs.add(in.substring(i,i+2));
                }
                else {
                    pairs.add(in.substring(i,i+1));
                }
            }
            else if (in.charAt(i)=='D') {
                if (i-1>=0) {
                    if (in.charAt(i-1)=='C') {
                        //do nothing
                    }
                    else {
                        pairs.add(in.substring(i,i+1));
                    }
                }
                else {
                    pairs.add(in.substring(i,i+1));
                }
            }
            else if (in.charAt(i)=='M') {
                if (i-1>=0) {
                    if (in.charAt(i-1)=='C') {
                        //do nothing
                    }
                    else {
                        pairs.add(in.substring(i,i+1));
                    }
                }
                else {
                    pairs.add(in.substring(i,i+1));
                }
            }
         }
        return pairs;
    }

}