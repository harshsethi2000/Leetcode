class Solution {
    int count=0;
    public int countArrangement(int n) {
         int[] nums = new int[n];
        for (int i = 1; i <= n; i++)
            nums[i - 1] = i;
        permutation(0,nums);
        return count;
    }
   public void permutation(int index,int[] nums)
    {
        if(index==nums.length)
        {
            count++;
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(i,index,nums);
            if(nums[index]%(index+1)==0 || (index + 1) % nums[index]==0)
                    permutation(index+1,nums);
            swap(i,index,nums);
        }
    }
     private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}