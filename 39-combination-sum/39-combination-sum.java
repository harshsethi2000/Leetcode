class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         We know that each element can be in the combination as many times
//             So we can check for each element and will decide whether to choose that element or not,If we choose that element then we can again choose the same element.
                
    List<List<Integer>> ls=new ArrayList<>();
        calculateCombinationSum(0,candidates,target,ls,new ArrayList<Integer>());
        return ls;
    }
    public void calculateCombinationSum(int index,int [] candidates,int target,List<List<Integer>> ls,ArrayList<Integer> ds)
    {
        //Base condition
        if(index==candidates.length)
        {
            if(target==0)
            {
                ls.add(new ArrayList<Integer>(ds));
            }
            return;
        }
        //select that element
        if(candidates[index]<=target)
        {
            //if we are selecting that element then add it in ds
          ds.add(candidates[index]);
          calculateCombinationSum(index,candidates,target-candidates[index],ls,ds);
          //remove added element from ds
            ds.remove(ds.size()-1);
        }
        
        //not selecting that element soo no need to change the target
        calculateCombinationSum(index+1,candidates,target,ls,ds);
        
    }
    
}