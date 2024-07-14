package test;

import java.util.ArrayList;
import java.util.List;

public class TraverseList {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        for (int i : a){
            System.out.println(i);
        }

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(2);
        b.add(1);
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        for (int i = 0; i< a.size();i++){
            if (a.get(i) > b.get(i)){
                int val = result.get(0).intValue();
                val++;
                result.set(0, val);
            } else if (a.get(i) < b.get(i)){
                int val = result.get(1).intValue();
                val++;
                result.set(1,val);
            }
        }

        System.out.println(result);
    }
}
