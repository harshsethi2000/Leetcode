// Method 2 -
//     Using Memoization
    
// class Solution {
//     public int fib(int n) {
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return getFibonacci(n,dp);
//     }
//     public int getFibonacci(int n,int []dp)
//     {
//         if(n<=1)return n;
//         if(dp[n]!=-1)return dp[n];
//         dp[n]=getFibonacci(n-1,dp)+getFibonacci(n-2,dp);
//         return dp[n];
//     }
// }
// Method 3-
//     Tabulation
//     TC - O(n)
// class Solution {
//     public int fib(int n) {
    
//         int dp[]=new int[n+1];
//         dp[0]=0;
//         dp[1]=1;
//         for(int i=2;i<=n;i++)
//         {
//             dp[i]=dp[i-1]+dp[i-2];
//         }
//         return dp[n];
        
//     }
// // }
// Method 4-
//     Tabulation with Space Optimization
//     TC- O(n)
//     SC- O(1)
    
class Solution {
    public int fib(int n) {
        int prev,secPrev;
        secPrev=0;
        prev=1;
        if(n<=1)return n;
        for(int i=2;i<=n;i++)
        {
            int curr=prev+secPrev;
            secPrev=prev;
            prev=curr;
            
        }
        return prev;
        
    }
}
