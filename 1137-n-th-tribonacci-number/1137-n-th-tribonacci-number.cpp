// class Solution {
// public:
//     int tribonacci(int n) {
//         vector<int> dp(n+1,-1);
//      return  getTribonacci(n,dp);
//     }
//     int getTribonacci(int n,vector<int> &dp)
//     {
//         if(n==0)return 0;
//         if(n==1 || n==2)return 1;
//         if(dp[n]!=-1)return dp[n];
//         return dp[n]=getTribonacci(n-1,dp)+getTribonacci(n-2,dp)+getTribonacci(n-3,dp);
//     }
// };

// Method 2 - Tabulation

// class Solution {
// public:
//     int tribonacci(int n) {
//         vector<int> dp(n+1,-1);
//         dp[0]=0;
//         dp[1]=1;
//         dp[2]=1;
//         for(int i=3;i<=n;i++)
//         {
//             dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
//         }
//         return dp[n];
//     }
    
// };

// Method 3- Tabulation with space optimization

class Solution {
public:
    int tribonacci(int n) {
        if(n==0)return 0;
        int prev=1,secPrev=1,thirdPrev=0;
      
        for(int i=3;i<=n;i++)
        {
            int curr=prev+secPrev+thirdPrev;
            thirdPrev=secPrev;
            secPrev=prev;
            prev=curr;
        }
        return prev;;
    }
    
};

