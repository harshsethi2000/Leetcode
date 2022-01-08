class Solution {
public:
    void permutations(vector<int>& nums,vector<vector<int>>&ans, vector<int>&ds,int freq[])
    {
        //if at any point we reach at end just add that elements in final ans
        if(ds.size()==nums.size())
        {
            ans.push_back(ds);
            return;
        }
        for(int i=0;i<nums.size();i++)
        {
            if(!freq[i])
            {
                ds.push_back(nums[i]);//push element into arr
                //mark it as taken
                freq[i]=1;
                //call permutations for next elements recursiuvely
                permutations(nums,ans,ds,freq);
                //backtrack after one recrsion is over
                freq[i]=0;//make freq of last element zero
                //pop it from given set
                ds.pop_back();
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>>ans;//to store final ans
        vector<int>ds;//to store temporary ans of recursion
        int freq[nums.size()];//to mark if element is taken or not
        for(int i=0;i<nums.size();i++)
        {
            freq[i]=0;
        }
        permutations(nums,ans,ds,freq);
        return ans;
    }
};