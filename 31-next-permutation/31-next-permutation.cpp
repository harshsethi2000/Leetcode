class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        //pichese suffix 2 543
        //2 pivot
        //2 se just bada element dhunda hai
        //woh element ko 2 wale se swap krdia
        // reverse pivot+1 se reverse krdena
        
        //find increasing order suffix from the back and determine the pivot
        int i=nums.size()-2;
        while(i>=0 && nums[i+1]<=nums[i])i--;
        int pivot=i;
        //search for the next greater element than the pivot
        if(pivot>=0)
        {
            i=nums.size()-1;
            while(nums[i]<=nums[pivot])i--;
            //swap our pivot element with the next greater element
            swap(nums[i],nums[pivot]);
        }
        //reverse the array from pivto+1 to end
        int k=pivot+1,t=nums.size()-1;
        while(k<t)swap(nums[k++],nums[t--]);

        
    }
    
    
};