// Method 1-
//     Recursion
//     TC - O(3^n)
//     SC - O(n)
    
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//       int ans=Integer.MAX_VALUE;
//       for(int i=0;i<matrix.length;i++)
//       {
//          int tmp= getMinimum(matrix,matrix.length-1,i);
//          ans=Math.min(tmp,ans);
//       }
//         return ans;
//     }
//     public int getMinimum(int [][]matrix , int i ,int j)
//     {
//         if(j<0 || j>=matrix.length)return (int)Math.pow(10,9);
//         if(i==0)return matrix[0][j];
//         int up=matrix[i][j]+getMinimum(matrix,i-1,j);
//         int dl=matrix[i][j]+getMinimum(matrix,i-1,j-1);
//         int dr=matrix[i][j]+getMinimum(matrix,i-1,j+1);
//         return Math.min(up,Math.min(dl,dr));
//     }
    
// }
class Solution {
    public int minFallingPathSum(int[][] matrix) {
      int ans=Integer.MAX_VALUE;
      int [][] dp=new int[matrix.length][matrix.length];
      for(int row[]: dp)Arrays.fill(row,-1);
     
      for(int i=0;i<matrix.length;i++)
      {
         int tmp= getMinimum(matrix,matrix.length-1,i,dp);
         ans=Math.min(tmp,ans);
      }
        return ans;
    }
    public int getMinimum(int [][]matrix , int i ,int j,int [][] dp)
    {
        if(j<0 || j>=matrix.length)return (int)Math.pow(10,9);
        if(i==0)return matrix[0][j];
        if(dp[i][j]!=-1)return dp[i][j];
        int up=matrix[i][j]+getMinimum(matrix,i-1,j,dp);
        int dl=matrix[i][j]+getMinimum(matrix,i-1,j-1,dp);
        int dr=matrix[i][j]+getMinimum(matrix,i-1,j+1,dp);
        return dp[i][j]= Math.min(up,Math.min(dl,dr));
    }
    
}
