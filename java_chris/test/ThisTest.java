package test;

public class ThisTest {

    private int a;

    public ThisTest() {
        this(42);
    }

    public ThisTest(int a) {
        this.a = a;
    }

    public void roar(){
        int a = 1;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(this);
    }

    public void recursiveCall(int x){
        if (x == 0) {
            return;
        }
        System.out.println(x);
        this.recursiveCall(x - 1);
    }

    @Override
    public String toString() {
        return "ThisTest a = " + a;
    }

    public static void main(String[] args) {
        ThisTest t = new ThisTest();
        t.roar();
        t.recursiveCall(5);
    }
}
