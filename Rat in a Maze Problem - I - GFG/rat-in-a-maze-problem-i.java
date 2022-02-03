// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        //create a visited array to mark 
        int [][] vis=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)vis[i][j]=0;
        }
        ArrayList<String> ans=new ArrayList<>();
        if(m[0][0]==1)mazeSolution(0,0,n,m,ans,"",vis);
        return ans;
    }
    public static void mazeSolution(int i,int j,int n,int[][] m,ArrayList<String> ans,String move,int[][] vis)
    {
        if(i==n-1 && j==n-1)
        {
            ans.add(move);
            return;
        }
        //check for each possible moves
        //downwords - i=i+1 j=j
        if(i+1<n && vis[i+1][j]==0 && m[i+1][j]==1)
        {
            //mark to visited
            vis[i][j]=1;
            mazeSolution(i+1,j,n,m,ans,move+"D",vis);
            vis[i][j]=0;
        }
        //left - i=i and j=j-1;
        if(j-1>=0 && vis[i][j-1]==0 && m[i][j-1]==1)
        {
            //mark to visited
            vis[i][j]=1;
            mazeSolution(i,j-1,n,m,ans,move+"L",vis);
            vis[i][j]=0;
        }
        //right i=i j=i+1
        if(j+1<n && vis[i][j+1]==0 && m[i][j+1]==1)
        {
            //mark to visited
            vis[i][j]=1;
            mazeSolution(i,j+1,n,m,ans,move+"R",vis);
            vis[i][j]=0;
        }
        //up i=i-1 and j=j
        if(i-1>=0 && vis[i-1][j]==0 && m[i-1][j]==1)
        {
            //mark to visited
            vis[i][j]=1;
            mazeSolution(i-1,j,n,m,ans,move+"U",vis);
            vis[i][j]=0;
        }
        
    }
}