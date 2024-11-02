package bits;

public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        int power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >>> 1;
            power--;
        }
        return ret;
    }
}
