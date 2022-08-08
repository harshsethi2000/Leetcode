class Solution {
public:
   int dp[2600][2600];
    int helper(vector<int>& arr, int i,int prev) {
        if(i>=arr.size())return 0;
        if(dp[i][prev]!=-1)return dp[i][prev];
        if(prev!=2550&&arr[i]<=arr[prev])return dp[i][prev]=helper(arr,i+1,prev);
        return dp[i][prev]=max(helper(arr,i+1,prev),1+helper(arr,i+1,i));
    }
    int lengthOfLIS(vector<int>& nums) {
        memset(dp,-1,sizeof(dp));
        return helper(nums,0,2550);
    }
};