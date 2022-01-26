class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ls=new ArrayList<>();
        Arrays.sort(nums);
        calculateSubset(0,nums,ls,new ArrayList<Integer>());
        return ls;
    }
    public void calculateSubset(int index,int[] nums,List<List<Integer>> ls,List<Integer> ds)
    {
        ls.add(new ArrayList<Integer>(ds));
        for(int i=index;i<nums.length;i++)
        {
            if(i!=index && nums[i]==nums[i-1])continue;
            ds.add(nums[i]);
            calculateSubset(i+1,nums,ls,ds);
            ds.remove(ds.size()-1);
        }
        
        
    }
}