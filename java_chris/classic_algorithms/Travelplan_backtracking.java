package classic_algorithms;

import java.util.ArrayList;
import java.util.List;

public class Travelplan_backtracking {
    Integer[][] hours;
    String[] c_remained = new String[]{"NP","IS","CA","UK","US"};
    private void build_hour_table(){
        // NP: 0
        // IS: 1
        // UK: 3
        // US: 4
        this.hours = new Integer[5][5];

        hours[0][0] = 0;     // NP -> NP
        hours[0][1] = 14;    // NP -> IS
        hours[0][2] = 15;    // NP -> CA
        hours[0][3] = 17;    // NP -> UK
        hours[0][4] = 16;    // NP -> US

        hours[1][0] = 14;    // IS -> NP
        hours[1][1] = 0;     // IS -> IS
        hours[1][2] = 24;    // IS -> CA
        hours[1][3] = 8;     // IS -> UK
        hours[1][4] = 36;    // IS -> US

        hours[2][0] = 15;    // CA -> NP
        hours[2][1] = 24;    // CA -> IS
        hours[2][2] = 0;     // CA -> CA
        hours[2][3] = 34;    // CA -> UK
        hours[2][4] = 4;     // CA -> US

        hours[3][0] = 17;    // UK -> NP
        hours[3][1] = 8;     // UK -> IS
        hours[3][2] = 34;    // UK -> CA
        hours[3][3] = 0;     // UK -> UK
        hours[3][4] = 30;    // UK -> US

        hours[4][0] = 16;    // US -> NP
        hours[4][1] = 36;    // US -> IS
        hours[4][2] = 4;     // US -> CA
        hours[4][3] = 30;    // US -> UK
        hours[4][4] = 0;     // US -> US
    }

    public Integer get_hour(String start, String end) {
        Integer x = get_index(start);
        Integer y = get_index(end);
        return this.hours[x][y];
    }

    private Integer get_index(String s){
        return switch (s) {
            case "NP" -> 0;
            case "IS" -> 1;
            case "CA" -> 2;
            case "UK" -> 3;
            case "US" -> 4;
            default -> null;
        };
    }

    // enumeration
    List<String> route = new ArrayList<>();
    public void backtracking(Integer hour_constraint) {
        String start_country = "NP";
        route.add(start_country);
        c_remained[0] = null;
        backtracking_recursion(hour_constraint);
    }

    private void backtracking_recursion(Integer hour_constraint) {
        int totalHour = get_hour_total();
        if (route.size() == 5) {
            // get a complete trip plan
            if (totalHour < hour_constraint) {
                System.out.print("[✅]");
                print_result(totalHour,route);
            } else {
                System.out.print("[x]:");
                print_result(totalHour,route);
            }
        } else {
            if (totalHour >= hour_constraint) {
                System.out.print("[Backtracked]:");
                print_result(totalHour,route);
                return;
            }
        }

        for (int i = 0 ; i < c_remained.length ; i++) {
            if (c_remained[i] == null) continue;
            String c_next = c_remained[i];

            // take out
            route.add(c_next);
            c_remained[i] = null;
            backtracking_recursion(hour_constraint);
            // give back
            route.remove(c_next);
            c_remained[i] = c_next;
        }
    }

    private void print_result(int totalHour, List<String> route) {
        for (int i = 0 ; i < route.size() ; i++) {
            System.out.print(route.get(i));
            if (i + 1 == route.size()) break;
            System.out.print("->");
        }
        System.out.println(" : " + totalHour);
    }

    private int get_hour_total() {
        if (route.isEmpty()) return 0;
        int totalHour = 0;
        String start = route.get(0);
        String end = null;
        for (int i = 1; i < route.size() ; i++) {
            end = route.get(i);
            totalHour += get_hour(start, end);
            start = end;
        }
        return totalHour;
    }

    public static void main(String[] args) {
        Travelplan_backtracking tp = new Travelplan_backtracking();
        tp.build_hour_table();
        Integer hour_constraint = 60;
        tp.backtracking(hour_constraint);
    }
}
