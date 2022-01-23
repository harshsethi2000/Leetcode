class Solution {
    public int pivotIndex(int[] nums) {
        int prefixSum[]=new int[nums.length];
        int suffixSum[]=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            prefixSum[i]=sum;
            sum=sum+nums[i];
        }
        sum=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            suffixSum[i]=sum;
            sum=sum+nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(prefixSum[i]==suffixSum[i])return i;
        }
        return -1;
    }
}