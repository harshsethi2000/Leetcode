class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[]=new Boolean[nums.length];
        
        return jump(0,nums[0],nums,dp);
    }
    public boolean jump(int index,int k,int [] nums,Boolean[] dp)
    {
        if(index==nums.length-1)return true;
        if(index>=nums.length)return false;
        if(dp[index]!=null)return dp[index];
        for(int i=1;i<=k;i++)
        {
            if(jump(i+index,nums[index+i],nums,dp)==true)return dp[index]=true;
        }
        return dp[index]=false;
    }
}