class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ls=new ArrayList<>();
        generate("",0,0,n,ls);
        return ls;
    }
    public void generate(String ds,int open,int close,int n,ArrayList<String> ls)
    {
        if(ds.length()==2*n)
        {
            ls.add(ds);
            return;
        }
       if(open<n)
       {
           generate(ds+"(",open+1,close,n,ls);
       }
        if(close<open)
        {
            generate(ds+")",open,close+1,n,ls);
        }
    }
}