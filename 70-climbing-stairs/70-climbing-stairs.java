// Two pointer + Tabulation space:-O(1) time:- O(N)
class Solution {
    int count=0;
    public int climbStairs(int n) {
        if(n==0 || n==1)
            return 1;
      int prev = 1,prev2 =1;
        for(int i=2;i<=n;i++){
            int ans = prev + prev2;
            prev = prev2;
            prev2 = ans;
        }
        return prev2;
    }
    
}

// Tabulation:- space:-O(N) time:-O(N)
// class Solution {
// public:
    
//     int climbStairs(int n) {
//         if(n==0 || n==1)
//             return 1;
//        vector<int>dp(n+1,-1);
//         dp[0]=1;
//         dp[1]=1;
//         for(int i=2;i<=n;i++)
//             dp[i] = dp[i-1] + dp[i-2];
//         return dp[n];
//     }
// };

// memoization :- faster han 100% time:- O(N) space:- O(N);

// class Solution {
// public:
//     int result(vector<int>&dp,int n){
//         if(dp[n]!=-1)
//             return dp[n];
//        int l = result(dp,n-1);
//         int r=0;
//         if(n>1)
//             r= result(dp,n-2);
//         return dp[n] = l+r;
//     }
//     int climbStairs(int n) {
//         if(n==0 || n==1)
//             return 1;
//        vector<int>dp(n+1,-1);
//         dp[0]=1;
//         dp[1]=1;
//         return result(dp,n);
//     }
// };