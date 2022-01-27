class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ls=new ArrayList<>();
        findCombination(1,n,k,ls,new ArrayList<Integer>());
        return ls;
    }
    public void findCombination(int index,int n,int k,List<List<Integer>> ls,List<Integer> ds)
    {
        //base condtion
        if(ds.size()==k)
        {
            //if our combination is of k size then only add in our ans
            ls.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i=index;i<=n;i++)
        {
            ds.add(i);
            findCombination(i+1,n,k,ls,ds);
            ds.remove(ds.size()-1);
        }
    }
    
}