package tree;

public class KokoEatingBananas_875 {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) return 0;
        int max_bananas = 1000000000;
        return search(piles, h, 1, max_bananas);
    }

    public int search(int[] piles, int H, int i_low, int i_end) {
        if (i_low > i_end) return -1;
        int result = -1;
        int mid = (i_low + i_end) / 2;
        long h = calculateHours(piles, mid);

        if (h <= H) {
            result = mid;
            // any better
            int left_node = search(piles, H, i_low, mid - 1);
            if (left_node != -1) result = left_node;
        } else if (h > H) {
            // go right
            int right_node = search(piles, H, mid + 1, i_end);
            if (right_node != -1) result = right_node;
        }
        return result;
    }

    public long calculateHours(int[] piles, int k) {
        int i = 0;
        long h = 0;
        while (true) {
            int banana = piles[i++];
            if (banana % k == 0) {
                h += banana/k;
            } else {
                h += banana/k + 1;
            }
            if (i >= piles.length) break;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        KokoEatingBananas_875 k = new KokoEatingBananas_875();
        int ans = k.minEatingSpeed(piles, h);
        System.out.println(ans);
    }
}
