class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        vector<vector<int>> ans;
        set<vector<int>> s;
        vector<int> ds;
        getSequence(0,nums,s,ds,INT_MIN);
         for(auto i:s)
            ans.push_back(i);
        return ans;
    }
    void getSequence(int index,vector<int> &nums,set<vector<int>>& ans,vector<int> &ds,int prev)
    {
        if(index==nums.size())
        {
            if(ds.size()>=2)ans.insert(ds);
            return;
        }
        //pick the element
            if(prev<=nums[index])
           {
             ds.push_back(nums[index]);
             getSequence(index+1,nums,ans,ds,nums[index]);
             ds.pop_back();
           }            
        getSequence(index+1,nums,ans,ds,prev); 
    }
};