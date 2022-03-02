class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        if(nums.size()==0)return 1;
        int max=0;
        for(int i=0; i<nums.size(); i++)
        {
            max|=nums[i];
        }
        return getCount(0,nums,max,0); 
    }
    
    int getCount(int index,vector<int> &nums,int &max,int sum)
    {
        if(index==nums.size())
        {
            if(max==sum)return 1;
            return 0;
        }
        return getCount(index+1,nums,max,sum | nums[index])+getCount(index+1,nums,max,sum);
    }
};