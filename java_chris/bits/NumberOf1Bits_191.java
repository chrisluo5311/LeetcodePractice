package bits;

public class NumberOf1Bits_191 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            ret += (n & 1);
            n = n >>> 1;
        }
        return ret;
    }
}
