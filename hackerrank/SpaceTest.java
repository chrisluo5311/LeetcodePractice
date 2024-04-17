public class SpaceTest {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 0;i<n;i++){
            int spaces = n-i-1;
            int staircaseNum = i+1;
            for (int j =0;j<spaces;j++){
                System.out.print(" ");
            }
            for (int k=0;k<staircaseNum;k++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
