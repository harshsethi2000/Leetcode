class Solution {
    public int rob(int[] nums) {
        int [] tmpOne=new int[nums.length-1];
        int [] tmpTwo=new int[nums.length-1];
        //since we know that we cannot pick first and last element together so we will
        //find the max sum including the first element of the array and not the last
        //then find the max sum including the last element of the array and not the first
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            tmpOne[i-1]=nums[i];
        }
        
        for(int i=0;i<nums.length-1;i++)
        {
            tmpTwo[i]=nums[i];
        }
        
        return Math.max(solve(tmpOne),solve(tmpTwo));
    }
     public int solve(int[] nums) {
        if(nums.length==0)return 0;
         if(nums.length==1)return nums[0];
        int prev=nums[0];
        int secPrev=0;
        for(int i=1;i<nums.length;i++)
        {
            int pick=nums[i];
            if(i>1)
            pick += secPrev;
            int notPick=prev;
            int curr=Math.max(pick,notPick);
            secPrev=prev;
            prev=curr;
        }
        return prev;

   }
}