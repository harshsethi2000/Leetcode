class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ls=new ArrayList<>();
        generateSubstring(0,s,ls,new ArrayList<String>());
        return ls;
    }
    public void generateSubstring(int index,String s,List<List<String>> ls,List<String> ds)
    {
        if(index==s.length())
        {
            //add in ls
            ls.add(new ArrayList<String>(ds));
            return ;
        }
        for(int i=index;i<s.length();i++)
        {
            if(isPalindrome(index,i,s))
            {
                ds.add(s.substring(index,i+1));
                generateSubstring(i+1,s,ls,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public boolean isPalindrome(int start,int end,String s)
    {
        while(start<end)
        {
            if(s.charAt(start++)!=s.charAt(end--))return false;
        }
        return true;
    }
}