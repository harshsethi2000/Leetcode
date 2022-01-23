class Solution {
    public int pivotIndex(int[] nums) {
        // Method 1-
        //     Using Extra space
        //     TIme Complexity -O(3n)
        //     Space Complexity -O(n)+O(n)
        // // int prefixSum[]=new int[nums.length];
        // int suffixSum[]=new int[nums.length];
        // int sum=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     prefixSum[i]=sum;
        //     sum=sum+nums[i];
        // }
        // sum=0;
        // for(int i=nums.length-1;i>=0;i--)
        // {
        //     suffixSum[i]=sum;
        //     sum=sum+nums[i];
        // }
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(prefixSum[i]==suffixSum[i])return i;
        // }
        // return -1;
        
//         Method 2-
//             We can calculate total sum in a single iteration
//             and then for each element check if leftSum==totalSum-leftSUm-x[i]
//                 Time Complexity -O(n)
//                 Space Complexity -O(1)
                
                int totalSum=0,leftSum=0;
        for(int i=0;i<nums.length;i++)totalSum+=nums[i];
        for(int i=0;i<nums.length;i++)
        {
            if(leftSum==totalSum-leftSum-nums[i])return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}