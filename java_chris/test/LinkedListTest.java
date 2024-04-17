package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Volvo");
        for (String car : cars){
            System.out.println(car);
        }

    }
}
