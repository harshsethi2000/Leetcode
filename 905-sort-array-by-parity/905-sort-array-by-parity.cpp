class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        int i=0,j=nums.size()-1;
        //using two pointer
        while(i<j)
        {
            if(nums[i]%2==0 && nums[j]%2==0)i++;
            else if(nums[i]%2!=0 && nums[j]%2==0)swap(nums[i++],nums[j--]);
            else if(nums[i]%2!=0 && nums[j]%2!=0)j--;
            else if(nums[i]%2==0 && nums[j]%2!=0)
            {
                i++;j--;
            }
        }
        return nums;
    }
};