package recursion;

public class ReverseString_344 {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        //reverseString(s);
        officialSolution(0,s.length-1,s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        helpers(0,s);
    }

    //自己想的
    public static void helpers(int index, char[] s) {
        if (s.length == 1 || index >= s.length) {
            return;
        }
        helpers(index+1,s);
        int median = s.length/2;
        if (index >= median) {
            int startIndex = s.length - index - 1;
            char temp = s[startIndex];
            s[startIndex] = s[index];
            s[index] = temp;
        }
    }

    //解答
    public static void officialSolution(int start, int end, char[] s){
        if (start >= end || s.length == 1) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        officialSolution(start+1, end-1, s);
    }
}
