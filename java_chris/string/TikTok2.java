package string;

public class TikTok2 {
    public static int minChangesToMakeCaptionGood(String caption) {
        int changes = 0;
        char[] chars = caption.toCharArray();  // 将字符串转换为字符数组，方便操作
        int i = 1;
        Character flag = chars[0];

        while (i < chars.length - 1) {
            if (chars[i] != chars[i - 1] || chars[i] != chars[i + 1]) {
                changes++;
                chars[i] = flag;
                flag = chars[i+1];
                i += 2;
                continue;
            }
            i++;
        }
        return changes;
    }

    public static void main(String[] args) {
        System.out.println(minChangesToMakeCaptionGood("abcdef"));
    }
}
