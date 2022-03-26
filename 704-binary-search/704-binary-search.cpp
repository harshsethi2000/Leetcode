class Solution {
public:
    int search(vector<int>& nums, int target) {
     return binarySearch(nums,0,nums.size()-1,target);   
    }
    int binarySearch(vector<int> &nums,int start,int end,int target)
    {
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]<target)start=mid+1;
            else if(nums[mid]>target)end=mid-1;
            else return mid;
        }
        return -1;
    }
};