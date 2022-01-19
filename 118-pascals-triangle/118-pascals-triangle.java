//the approach is to simply take a 2D array and then add element according to the condition
//Time Complexity- O(N^2)
//Space Complexity - O(N^2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> li=new ArrayList<>();        
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        li.add(firstRow);
        for(int i=1;i<numRows;i++)
        {
            List<Integer> tmp=new ArrayList<>();
            tmp.add(1);
            List<Integer> prevRow=li.get(i-1);
            for(int j=1;j<i;j++)
            {
                tmp.add(prevRow.get(j)+prevRow.get(j-1));
            }
            tmp.add(1);
            li.add(tmp);
        }
        return li;
        
    }
}