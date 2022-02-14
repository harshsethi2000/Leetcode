// Approach 1 -
//     Simple Recursion Solution
//     TC - O(2^m*n)
//     SC - O(m-1+n) 
// class Solution {
//     public int uniquePaths(int m, int n) {
//       return getCount(m-1,n-1);   
//     }
//     public int getCount(int m,int n)
//     {
//         if(m==0 && n==0)return 1;
//         if(m<0 || n<0)return 0;
//         int left=getCount(m,n-1);
//         int up=getCount(m-1,n);
//         return left+up;
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return getCount(m-1,n-1,dp);   
    }
    public int getCount(int m,int n,int dp[][])
    {
        if(m==0 && n==0)return 1;
        if(m<0 || n<0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        int left=getCount(m,n-1,dp);
        int up=getCount(m-1,n,dp);
        return dp[m][n]=left+up;
    }
}


