class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ls=new ArrayList<>();
        ArrayList<String> tmpArr=new ArrayList<>();
        tmpArr.add("abc");
        tmpArr.add("def");
        tmpArr.add("ghi");
        tmpArr.add("jkl");
        tmpArr.add("mno");
        tmpArr.add("pqrs");
        tmpArr.add("tuv");
        tmpArr.add("wxyz");
        if(digits.length()!=0)generateCombination(0,ls,digits,"",tmpArr);
        return ls;
    }
    public void generateCombination(int index,List<String> ls,String digits,String ds,ArrayList<String> tmpArr)
    {
        if(index==digits.length())
        {
            ls.add(ds);
            return;
        }
        int digitIndex=Character.getNumericValue(digits.charAt(index))-2;
        for(int i=0;i<tmpArr.get(digitIndex).length();i++)
        {
              
                generateCombination(index+1,ls,digits,ds+tmpArr.get(digitIndex).charAt(i),tmpArr);
        }
    }
}