public class LexicographicalOrder {
    public static void main(String[] args) {
        String s = "welcometojava";
        int k = 3;
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = s.substring(0,k);
        largest = s.substring(0,k);
        for (int i = 0; i<=s.length()-k;i++){
            String sub = s.substring(i,i+k);
            System.out.println(sub);
            if (sub.compareTo(smallest) < 0) {
                smallest = sub;
            }
            if (sub.compareTo(largest) > 0) {
                largest = sub;
            }
        }
        System.out.println("smallest: "+smallest);
        System.out.println("largest: " + largest);
    }
}
