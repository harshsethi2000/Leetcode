// if element is found at mid return that mid
// if x[start]<=x[mid] that means array is sorted from start to mid
//        find if target is in left side of the array 
//        else target is in right side of the array for sure

// else array is sorted from mid+1 to end
     
class Solution {
public:
    int search(vector<int>& nums, int target) {
     return binarySearch(0,nums.size()-1,target,nums);
     
    }
    int binarySearch(int start,int end,int target,vector<int> &nums)
    {
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]==target)return mid;
            if(nums[start]<=nums[mid])
            {
                //left side of array is sorted
                if(target<=nums[mid] && target>=nums[start])
                {
                    //that target is in left side of the array
                    end=mid-1;
                }
                else
                {
                    //target is not in left side of the array 
                    start=mid+1;
                }
                
            }
            else
            {
                //right side of the array is sorted
                if(nums[mid]<=target && target<=nums[end])
                {
                    //target is in right side of the array
                    start=mid+1;
                }
                else end=mid-1;
            }
        }
        return -1;
    }
};