class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m=og.length;
        int n=og[0].length;
        int [][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        if(og[0][0]==1)return 0;
        return getCount(m-1,n-1,dp,og);    
    }
    public int getCount(int m,int n,int dp[][],int [][]og)
    {
        if(m==0 && n==0)return 1;
        if(m<0 || n<0)return 0;
        if(og[m][n]==1)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        int left=getCount(m,n-1,dp,og);
        int up=getCount(m-1,n,dp,og);
        return dp[m][n]=left+up;
    }
}