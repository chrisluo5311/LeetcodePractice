package bits;

public class BitsTest {
    public static void main(String[] args) {
        int x = 4;
        int y = -4;
        System.out.println("x = " + x);

        // Signed right shift operator >>
        // Right shit means divided by 2^{i}
        System.out.print("x right shift 1= ");
        System.out.println(x >> 1);
        System.out.print("y right shift 1= ");
        System.out.println(y >> 1);

        // Left shift means multiply 2^{i}
        System.out.print("x left shift 1= ");
        System.out.println(x << 1);
        System.out.print("y left shift 1= ");
        System.out.println(y << 1);


        // Unsigned right shift operator >>>
        System.out.print("Unsigned x right shift 1= ");
        System.out.println(x >>> 1);



    }
}
