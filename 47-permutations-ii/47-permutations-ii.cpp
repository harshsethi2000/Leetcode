class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        set<vector<int>> ans;
        getPermutations(0,nums,ans);
        
        return vector<vector<int>>(ans.begin(),ans.end());
    }
    void getPermutations(int index,vector<int> &nums,set<vector<int>> &ans)
    {
        if(index==nums.size())
        {
            ans.insert(nums);
            return;
        }
        for(int i=index;i<nums.size();i++)
        {
            swap(nums[i],nums[index]);
            getPermutations(index+1,nums,ans);
            swap(nums[i],nums[index]);
        }
    }
};