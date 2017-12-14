public class A {

    private int a;
    private int b=0;

    public A(int a) {
        this.a=a;
        System.out.println(this);
        A two = new A(a,b);
        System.out.println(this);
        System.out.println(two);
    }

    public A(int a, int b) {
        this.a=a+5;

    }

    public String toString() {
        return "A: "+a+"\nB: "+b;
    }
}