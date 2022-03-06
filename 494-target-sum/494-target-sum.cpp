class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
     return getCount(0,nums,0,target);   
    }
    int getCount(int index,vector<int>& nums,int sum,int target)
    {
        
        if(index==nums.size())
        {
            if(sum==target)return 1;
            return 0;
        }
        //placing +ve sign
        int pos=getCount(index+1,nums,sum+nums[index],target);
        //placing -ve sign
        int neg=getCount(index+1,nums,sum-nums[index],target);
        return pos+neg;
    }
};