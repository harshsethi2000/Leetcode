class Solution {
public:
    int ans=0;
    int subsetXORSum(vector<int>& nums) {
        if(nums.size()==0)return 0;
        if(nums.size()==1)return nums[0];
        getSum(0,nums,0);
        return ans;
    }
    void getSum(int index,vector<int> &nums,int sum)
    {
        if(index==nums.size())
        {
            ans+=sum;
            return;
        }
        getSum(index+1,nums,sum xor nums[index]);
        getSum(index+1,nums,sum);
    }
};