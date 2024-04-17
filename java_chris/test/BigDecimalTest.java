package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {
        //可以表示一个任意大小且精度完全准确的浮点数。
        BigDecimal a = new BigDecimal("1.23");
        System.out.println(a);
        System.out.println(a.multiply(a));

        //scale()表示小數位數
        BigDecimal b = new BigDecimal("123.4500");
        BigDecimal c = new BigDecimal("0.878");
        BigDecimal d = new BigDecimal(".23");
        BigDecimal f = new BigDecimal("02.123000");
        System.out.println("a.scale(): "+a.scale());
        System.out.println("b.scale(): "+b.scale());
        System.out.println("c.scale(): "+c.scale());
        System.out.println("d.scale(): "+d.scale());
        System.out.println("f: " + f + ", f.scale(): "+f.scale());

        //通过BigDecimal的stripTrailingZeros()方法，
        // 可以将一个BigDecimal格式化为一个相等的，
        // 但去掉了末尾0的BigDecimal：
        BigDecimal e = new BigDecimal("456.7000");
        BigDecimal g = new BigDecimal("12345000");
        BigDecimal e2 = e.stripTrailingZeros();
        BigDecimal g2 = g.stripTrailingZeros();
        System.out.println("e.scale(): "+e.scale());
        System.out.println("e2.scale(): "+e2.scale());
        System.out.println("g.scale(): "+g.scale());
        //-3，表示这个数是个整数，并且末尾有3个0。
        System.out.println("g2.scale(): "+g2.scale());

        //可以对一个BigDecimal setScale
        // 如果精度比原始值低，那么按照指定的方法进行四舍五入或者直接截断：
        BigDecimal h = new BigDecimal("1234.456789");
        BigDecimal h2 = h.setScale(4, RoundingMode.HALF_UP);
        BigDecimal h3 = h.setScale(4, RoundingMode.DOWN);
        System.out.println(h2);
        System.out.println(h3);

        // compare BigDecimal, use equals()
        //使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等：
        BigDecimal i1 = new BigDecimal("123.456");
        BigDecimal i2 = new BigDecimal("123.45600");
        System.out.println(i1.equals(i2)); // false,因为scale不同
        System.out.println(i1.equals(i2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为3
        //必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
        System.out.println(i1.compareTo(i2));
        //❗ 总是使用compareTo()比较两个BigDecimal的值，不要使用equals()！


    }

}
