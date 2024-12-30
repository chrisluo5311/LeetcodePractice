package string;

public class FindTheIndexOfTheFirstOccurrenceInaString_28 {
    static int magicNum = 31; // for hashing
    static int moduleNum = 1000000007;
    public static int strStr(String haystack, String needle) {
        if (null == haystack) return -1;
        if (null == needle) return -1;
        if (haystack.length() < needle.length()) return -1;
        if (needle.isEmpty()) return 0; // if empty string, return 0

        // target hash
        long targetHashNum = hash(needle);

        // main code
        long nowHashNum = 0;
        long highest_power = (long)Math.pow(magicNum, needle.length() - 1);
        /** 1st loop: check hash value **/
        for (int i = 0 ; i <= haystack.length() - needle.length(); i++) {
            // get base case
            if (i == 0) {
                nowHashNum = hash(haystack.substring(i, i + needle.length()));
            }else{
                /** rolloing hash **/
                // abc - a -> _bc
                nowHashNum -= (haystack.charAt(i-1) * (highest_power));
                nowHashNum = mod(nowHashNum, moduleNum);
                // bc_ move left
                nowHashNum *= magicNum;
                nowHashNum = mod(nowHashNum, moduleNum);
                // bc_ + d -> bcd
                nowHashNum += haystack.charAt(i + needle.length() - 1);
                nowHashNum = mod(nowHashNum, moduleNum);
            }

            // if passed, it means two things:
            // 1. you're a good person
            // 2. your hash function is good
            if (nowHashNum == targetHashNum){
                return i;
            }
        }

        return -1;
    }

    private static long hash(String str) {
        long result = 0;

        for (int i = 0; i < str.length(); i++) {
            // "ab_" move ALL left
            result *= magicNum;
            result = mod(result, moduleNum);
            // "ab_" + c -> "abc"
            result += str.charAt(i);
            result = mod(result, moduleNum);
        }

        return result;
    }

    private static long mod(long num, long mod) {
        return ( num % mod + mod) % mod;
    }

    public static void main(String[] args) {
        int res = strStr("fourscoreandsevenyearsagoourfathersbroughtforthuponthiscontinentanewnation",
                "ourfathersbroughtforthuponthiscontinentanewnation");

        System.out.println(res);
    }
}
