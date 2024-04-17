public class StaticBlockTest {

    static {
        System.out.println("Static block is called");
    }

    public static void main(String[] args) {
        StaticBlockTest test1 = new StaticBlockTest();
        System.out.println("===");
        StaticBlockTest test2 = new StaticBlockTest();
    }
}
