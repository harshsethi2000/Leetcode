
class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return minJump(0,nums[0],nums,dp);
    }
    public int minJump(int index,int k,int [] nums,int[] dp)
    {
        if(index==nums.length-1)return 0;
        if(index>=nums.length)return 0;
        if(dp[index]!=-1)return dp[index];
        int ans=10001;
        for(int i=1;i<=k;i++)
        {
            if(index+i>=nums.length)ans=ans;
            else ans=Math.min(ans,1+minJump(i+index,nums[index+i],nums,dp));
            
        }
        
        return dp[index]=ans;
    }
}