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

// Approach 2 -
//     Memoziation
//     TC - O(m*n)
//     SC - O(m*n)+O(n-1+m-1)[path length that is extra stack space] 

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int [][] dp=new int[m][n];
//         for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
//         return getCount(m-1,n-1,dp);   
//     }
//     public int getCount(int m,int n,int dp[][])
//     {
//         if(m==0 && n==0)return 1;
//         if(m<0 || n<0)return 0;
//         if(dp[m][n]!=-1)return dp[m][n];
//         int left=getCount(m,n-1,dp);
//         int up=getCount(m-1,n,dp);
//         return dp[m][n]=left+up;
//     }
// }
// Approach 3 - Tabulation
// TC - O(n*m)
// SC -O(n*m)    

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int [][] dp=new int[m][n];
        
//         for(int i=0;i<m;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                   if(i==0 && j==0)dp[0][0]=1;
//                 else
//                 {
//                     int left=0,up=0;
//                   if(j>0)  left=dp[i][j-1];
//                   if(i>0)  up=dp[i-1][j];
//                   dp[i][j]=left+up;
//                 }
                    
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

// Approach $ -Tabulation with space optmization
// TC->O(n * m) | SC-> O(n)
    
class Solution {
    public int uniquePaths(int m, int n) {
        
        int [] prevRow=new int[n];
        Arrays.fill(prevRow,0);
        for(int i=0;i<m;i++)
       {    int [] curr=new int[n];
            Arrays.fill(curr,0);
        
            for(int j=0;j<n;j++)
            {
                  if(i==0 && j==0)curr[0]=1;
                else
                {
                    int left=0,up=0;
                  if(j>0)  left=curr[j-1];
                  if(i>0)  up=prevRow[j];
                  curr[j]=left+up;
                }
                    
            }
            
            for(int k=0;k<n;k++)prevRow[k]=curr[k];
        }
        return prevRow[n-1];
    }
}




