class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //taking a List to add all our unique subsequences 
        List<List<Integer>> ls=new ArrayList<>();
        calculateSum(0,candidates,target,ls,new ArrayList<Integer>());
        return ls;
    }
    public void calculateSum(int index,int[] nums, int target,List<List<Integer>> ls,List<Integer>ds)
    {
        
        //base condition
        if(index==nums.length)
        {
        if(target==0)    ls.add(new ArrayList<Integer>(ds));
         return;
        }
        //we will pick a element if it is less than our target
        if(target>=nums[index])
        {
            ds.add(nums[index]);
            //we can choose the same number twice soo no need to increment index
            calculateSum(index,nums,target-nums[index],ls,ds);
            ds.remove(ds.size()-1);
        }
        calculateSum(index+1,nums,target,ls,ds);
    }
}