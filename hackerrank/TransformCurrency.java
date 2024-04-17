import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 *  <a href="https://www.geeksforgeeks.org/numberformat-getcurrencyinstance-method-in-java-with-examples/">geeksforgeeks</a>
 * */

public class TransformCurrency {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat nfUs = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nfIndian = NumberFormat.getCurrencyInstance(new Locale("en","IN"));
        NumberFormat nfChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat nfFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String india = nfIndian.format(payment);
        String us = nfUs.format(payment);
        String china = nfChina.format(payment);
        String france = nfFrance.format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
