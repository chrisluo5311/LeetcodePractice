package recursion;

public class kthGrammar {

    public static int depthFirstSearch(int n, int k, int rootVal){
        if (n==1){
            return rootVal;
        }

        int totalNodes = (int) Math.pow(2,n-1);

        if (k > totalNodes/2) {
            int nextRootVal = rootVal == 0 ? 1 : 0;
            return depthFirstSearch(n-1,k-(totalNodes/2),nextRootVal);
        } else {
            int nextRootVal = rootVal == 0 ? 0 : 1;
            return depthFirstSearch(n-1,k,nextRootVal);
        }
    }


    public static void main(String[] args) {
        int n = 21;
        int k = 6;
        int result = depthFirstSearch(n,k,0);
        System.out.println(result);
    }
}
