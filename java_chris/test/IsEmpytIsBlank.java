package test;

public class IsEmpytIsBlank {
    public static void main(String[] args) {

        System.out.println("Example text".isEmpty());//false
        System.out.println("".isEmpty());//true
        System.out.println(" ".isEmpty());//false
        System.out.println("\t\n\r\f".isEmpty());//false

        System.out.println("============================");

        System.out.println("Example text".isBlank());//false
        System.out.println("".isBlank());//true
        System.out.println(" ".isBlank());//true
        System.out.println("\t\n\r\f".isBlank());//true

    }
}
