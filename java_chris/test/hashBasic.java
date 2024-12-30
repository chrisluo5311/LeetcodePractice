package test;

public class hashBasic {

    private static long hash(String str) {
        int magic_nubmer = 31; // you can pick other prime number
        int module_number = 1000000007;
        long hashedbucket = 0;
        for (int i = 0; i < str.length(); i++) {
            /** step01: move ALL left each round **/
            hashedbucket *= magic_nubmer; // leverage multiplication to show different char position
            hashedbucket = mod(hashedbucket, module_number);
            /** step02: add the newly left-most char **/
            System.out.println("curr char is:" + str.charAt(i));
            hashedbucket += str.charAt(i); // leverage ASCII chart to convert char into int
            hashedbucket = mod(hashedbucket, module_number);
            /** stepall: use % to categorize & avoid overflow in every step **/
        }

        return hashedbucket;
    }

    private static long mod(long n, long m) {
        return (n%m + m) % m;
    }

    public static void main(String[] args) {
        String str = "ab";
        long hashed_moded_result = hash(str);
        System.out.println("result: " + hashed_moded_result); // 104371024
    }
}
