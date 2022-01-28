class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //arrayList to insert all the unique subsets
        List<List<Integer>> ls=new ArrayList<>();
        Arrays.sort(nums);
        calculateSubsets(0,nums,ls,new ArrayList<Integer>());
        return ls;
    }
    public void calculateSubsets(int index,int [] nums,List<List<Integer>> ls,List<Integer> ds)
    {
        //Base condition
        //add our ds in our final ls
        ls.add(new ArrayList<Integer>(ds));
        for(int i=index;i<nums.length;i++)
        {
            //to eliminate the dulicates
           if(i!=index && nums[i]==nums[i-1])continue;
            ds.add(nums[i]);
            calculateSubsets(i+1,nums,ls,ds);
            //after backtracking will remove that element from our DS
            ds.remove(ds.size()-1);
        }
    }
}