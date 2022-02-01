class Solution {
    public int singleNonDuplicate(int[] nums) {
      //   Method 1- Using XOR operation
      //       We can find the XOR of all the element and that XOR of all the element will be our singleNonDuplicate Number
      //       Since : (p is element) 
      //       p xor p=0
      //       and p xor 0 =p
      // and we know that all the elements occured twice so xor of all the elements
      //           that occured twice will be 0.
      //           Time Complexity - O(n)
      //           Space Complexity -O(1)
        // int elements=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     elements=elements^nums[i];
        // }
        // return elements;
        
// //         Method 2: Using Binary Search
//             We will find the Break point such that it will break 
//             our array into two halves left and right halves
//             Observation for our left half - 1St occurance at even index
//                                             2nd occurance at odd index
//             Observation for our right half - 1St occurance at odd index
//                                             2nd occurance at even index
//             if our mid element is in 
//                 Left half then shrink the left half
//                 Right half then shrink the right half
                
//             After follwing all the steps the element at low index will be our                 answer
//                 Time Complexity - O(logn)
//                 Space Complexity - O(1)
                
        int low=0;
        //just in case our element at last will be our answer soo take high=n-2
        int high=nums.length-2;
        while(low<=high)
        {
            int mid=(low+high)/2;
            //if mid is at even index
            if(mid%2==0)
            {
                if(nums[mid]!=nums[mid+1])
                {
                    //mid is in right half
                    //shrink the right half
                    high=mid-1;
                }
                else
                {
                    //mid is in left half
                    //shrink the left half
                    low=mid+1;
                }
            }
            //if mid is at odd index
            else
            {
                 if(nums[mid]==nums[mid+1])
                {
                    //mid is in right half
                    //shrink the right half
                    high=mid-1;
                }
                else
                {
                    //mid is in left half
                    //shrink the left half
                    low=mid+1;
                }
            }
        }
        return nums[low];
                
    }
}