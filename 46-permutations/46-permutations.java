class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls=new ArrayList<>();
        getAllPermutations(0,nums,ls);
        return ls;
    }
   public void getAllPermutations(int index,int nums[],List<List<Integer>> ls)
    {
        if(index==nums.length)
        {
            List<Integer> ds=new ArrayList<>();
            for(int k=0;k<nums.length;k++)ds.add(nums[k]);
            ls.add(new ArrayList<Integer>(ds));
            return ;
        }
        for(int i=index;i<nums.length;i++)
        {
        
            swap(i,index,nums);
            getAllPermutations(index+1,nums,ls);
            swap(i,index,nums);
        }
    }
     private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}