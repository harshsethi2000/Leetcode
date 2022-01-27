class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ls=new ArrayList<>();
         Arrays.sort(candidates);
        combinationSum(0,candidates,target,ls,new ArrayList<Integer>());
        return ls;
    }
    public void combinationSum(int index,int [] candidates,int target,List<List<Integer>> ls,List<Integer> ds)
    {
        if(target==0)
        {
            ls.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i=index;i<candidates.length;i++)
        {
             if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            ds.add(candidates[i]);
            combinationSum(i+1,candidates,target-candidates[i],ls,ds);
            ds.remove(ds.size()-1);
        }
    }
}