class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int found=0;
        vector<int> v;
    for(int i=0;i<nums.size();i++)
    {
        for(int j=i+1;j<nums.size();j++)
        {
            if((nums[i]+nums[j])==target)
            {
                v.push_back(i);
                v.push_back(j);
                found=1;
                break;
            }
        }
        if(found==1)break;
    }
        return v;
    }
};