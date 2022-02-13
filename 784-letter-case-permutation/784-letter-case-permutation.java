class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ls=new ArrayList<String>();
        getPermutation(0,s,ls,"");
        return ls;
    }
    public void getPermutation(int index,String s,List<String> ls,String tmp)
    {
        if(index==s.length())
        {
            ls.add(tmp);
            return;
        }
        
        if(s.charAt(index)>='0' && s.charAt(index)<='9')
        {
         getPermutation(index+1,s,ls,tmp+s.substring(index,index+1));
            
        }
        else
        {
        getPermutation(index+1,s,ls,tmp+s.substring(index,index+1).toUpperCase());
        getPermutation(index+1,s,ls,tmp+s.substring(index,index+1).toLowerCase());
        }
    }
}