// Method 1 -
//     Recursion 
//     TC - O(2^m*n)
//     SC - O(m-1+n-1)
    
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
//         return getMinimumPath(m-1,n-1,grid);
//     }
//     public int getMinimumPath(int m,int n,int[][]grid)
//     {
//         if(m==0 && n==0)return grid[0][0];
//         if(m<0 || n<0)return (int)Math.pow(10,9);
//         int up=grid[m][n]+getMinimumPath(m-1,n,grid);
//         int left=grid[m][n]+getMinimumPath(m,n-1,grid);
//         return Math.min(left,up);
//     }
// }

// Method 2-
//     Memoization
//     TC - O(m*n)
//     SC - O(m*n) + O(m-1+n-1) {stack space}

// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
//         int [][] dp=new int[m][n];
//         for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);

//         return getMinimumPath(m-1,n-1,grid,dp);
//     }
//     public int getMinimumPath(int m,int n,int[][]grid,int [][]dp)
//     {
//         if(m==0 && n==0)return grid[0][0];
//         if(m<0 || n<0)return (int)Math.pow(10,9);
//         if(dp[m][n]!=-1)return dp[m][n];
//         int up=grid[m][n]+getMinimumPath(m-1,n,grid,dp);
//         int left=grid[m][n]+getMinimumPath(m,n-1,grid,dp);
//         return dp[m][n]=Math.min(left,up);
//     }
// }

// Method 3-
//     Tabulation
//     TC - O(n*m)
//     SC - O(n*m)
    
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] dp=new int[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)dp[0][0]=grid[0][0];
                else
                {
                    int left=grid[i][j];
                    if(j>0)left+=dp[i][j-1];
                    else left+=Math.pow(10,9);
                    int up=grid[i][j];
                    if(i>0)up+=dp[i-1][j];
                    else up+=Math.pow(10,9);
                    dp[i][j]=Math.min(left,up);
                }
            }
        }
        return dp[m-1][n-1];

    }
    
}

