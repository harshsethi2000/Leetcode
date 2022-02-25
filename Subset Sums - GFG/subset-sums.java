// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ls=new ArrayList<>();
        getSum(0,0,ls,arr);
        return ls;
    }
    public void getSum(int index,int sum,ArrayList<Integer> ls,ArrayList<Integer> arr)
    {
        if(index==arr.size())
        {
         ls.add(sum);
         return;
        }
        getSum(index+1,sum+arr.get(index),ls,arr);
        getSum(index+1,sum,ls,arr);
    }
}