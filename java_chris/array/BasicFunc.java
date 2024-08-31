package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class BasicFunc {
    private static void divider(){
        System.out.println("===========================");
    }
    public static void main(String[] args) {
        //The closest Java has to a Python List is the ArrayList<> and can be declared as such
        //Declaring an ArrayList
        ArrayList<String> stringArrayList = new ArrayList<String>();

        //add to the end of the list
        stringArrayList.add("foo");

        //add to the beggining of the list
        stringArrayList.add(0, "food");
        stringArrayList.add(1, "drink");
        stringArrayList.add(2, "snack");

        //remove an element at a spesific index
        stringArrayList.remove(1);

        //get the size of the list
        stringArrayList.size();

        //clear the whole list
//        stringArrayList.clear();

        //copy to a new ArrayList
        ArrayList<String> oldArrayList = new ArrayList<>();
        oldArrayList.add("BMW");
        ArrayList<String> myNewArrayList = new ArrayList<>(oldArrayList);

        //to reverse
        Collections.reverse(stringArrayList);

        //something that could work as "pop" could be
        System.out.println(stringArrayList.size());
        stringArrayList.remove(stringArrayList.size() - 1);

        divider();
        //finding max
        int[] nums = {1,4,6,2,10};
        int maxNum = Arrays.stream(nums).max().getAsInt();
        System.out.println(maxNum);

        int[] nums2 = new int[]{};
//        nums2[0] = 1;
    }
}
