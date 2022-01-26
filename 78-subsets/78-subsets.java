class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls=new ArrayList<>();
        calculateSubset(0,nums,ls,new ArrayList<Integer>());
        return ls;
    }
  public void  calculateSubset(int index,int[] nums, List<List<Integer>> ls, List<Integer> ds)
    {
        if(index==(nums.length))
        {
            ls.add(new ArrayList<Integer>(ds));
            return ;
        }
        ds.add(nums[index]);
        calculateSubset(index+1,nums,ls,ds);
        ds.remove(ds.size()-1);
        calculateSubset(index+1,nums,ls,ds);
    }
}