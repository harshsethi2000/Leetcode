// Method 1 -
//     Recursion
//     TC - O(2^(1+2+3....n))
//     SC - O(n)
    
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//      //ending point is varying so we can start from bottom
//         int n=triangle.size();
//         return getMinimum(triangle,0,0);
//     }
//     public int getMinimum(List<List<Integer>> triangle,int i,int j)
//     {
//         if(i==triangle.size()-1)
//         {
//             return triangle.get(i).get(j);
//         }
//         int down=triangle.get(i).get(j)+getMinimum(triangle,i+1,j);
//         int diagonallyDown=triangle.get(i).get(j)+getMinimum(triangle,i+1,j+1);
//         return Math.min(down,diagonallyDown);
//     }
// }
// Method 2 -
//     Memoization
//     TC - O(n*n)
//     SC - O(n)+O(n*n)
    
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//      //ending point is varying so we can start from bottom
        
//         int n=triangle.size();
//         int [][] dp=new int[n][n];
//         for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
//         return getMinimum(triangle,0,0,dp);
//     }
//     public int getMinimum(List<List<Integer>> triangle,int i,int j,int [] [] dp)
//     {
//         if(i==triangle.size()-1)
//         {
//             return triangle.get(i).get(j);
//         }
//         if(dp[i][j]!=-1)return dp[i][j];
//         int down=triangle.get(i).get(j)+getMinimum(triangle,i+1,j,dp);
//         int diagonallyDown=triangle.get(i).get(j)+getMinimum(triangle,i+1,j+1,dp);
//         return dp[i][j]=Math.min(down,diagonallyDown);
//     }
// }

// Method 3 -
//     Tabulation
//     TC - O(n*n)
//     SC - O(n*n)
    
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
     //ending point is varying so we can start from bottom
        
        int n=triangle.size();
        int [][] dp=new int[n][n];
        for(int j=0;j<n;j++){
           dp[n-1][j] = triangle.get(n-1).get(j);
        }
    
    for(int i=n-2; i>=0; i--){
        for(int j=i; j>=0; j--){
            
            int down = triangle.get(i).get(j)+dp[i+1][j];
            int diagonal =  triangle.get(i).get(j)+dp[i+1][j+1];
            
            dp[i][j] = Math.min(down, diagonal);
        }
    }
    return dp[0][0];
    }
    
}

// Method 4-
//     Space Optimized Tabulation
//     TC - O(n*n)
//     SC - O(n)
    
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//      //ending point is varying so we can start from bottom
        
//         int n=triangle.size();
//         int [] prevRow=new int[n];
//         int []curr=new int[n];
//         for(int j=0;j<n;j++){
//            prevRow[j] = triangle.get(n-1).get(j);
//         }
//     for(int i=n-2; i>=0; i--){
//         for(int j=i; j>=0; j--){
            
//             int down = triangle.get(i).get(j)+prevRow[j];
//             int diagonal =  triangle.get(i).get(j)+prevRow[j+1];
            
//             curr[j] = Math.min(down, diagonal);
//         }
//         prevRow=curr;
//     }
//     return prevRow[0];
//     }
    
// }
