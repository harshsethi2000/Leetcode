class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        vector<vector<int>> dp(piles.size(),vector<int>(k+1,-1));
        return f(0,piles,k,dp);
    }
    int f(int index,vector<vector<int>> &piles,int k, vector<vector<int>> &dp)
    {
        if(index==piles.size()||k==0)
        {
            return 0;
        }
        if(dp[index][k]!=-1)return dp[index][k];
        int best=f(index+1,piles,k,dp);
        int sum=0;
        for(int i=0;i<min((int)piles[index].size(),k);i++)
        {
            sum+=piles[index][i];
             best=max(best,sum+f(index+1,piles,k-(i+1),dp));
        }
        return dp[index][k]=best;
    }
};