class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> ls=new ArrayList<>();
       for(int i=1;i<=9;i++) getNumbers(0,i,ls,n,k,Integer.toString(i));
        
        int arr[]=new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) arr[i] = ls.get(i);
        return arr;
    }
    public void getNumbers(int index,int num,ArrayList<Integer> ls,int n,int k,String ans)
    {
        if(num<0 || num>9)return;
        
        if(index==n-1)
        {
            ls.add(Integer.parseInt(ans));
            return;
        }
        
        getNumbers(index+1,num+k,ls,n,k,ans+Integer.toString(num+k));
        if(num+k!=(num-k))getNumbers(index+1,num-k,ls,n,k,ans+Integer.toString(num-k));
        
    }
}