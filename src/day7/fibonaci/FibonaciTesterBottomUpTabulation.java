package day7.fibonaci;

public class FibonaciTesterBottomUpTabulation {

    public static long getFibonaciElement(int n) {
        long result = 0;
        long dp[] = new long[n+1];
        dp[0]=0;
        dp[1]=1;

        for( int i=2; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        result=dp[n];
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Nth Fibo element "+getFibonaciElement(5));
    }


}
