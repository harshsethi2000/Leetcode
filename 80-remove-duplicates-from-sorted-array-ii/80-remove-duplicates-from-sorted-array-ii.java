class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 2;
        if(nums.length < 2)
            return nums.length;
        for(int i = 2 ; i < nums.length; i++) {
            if(nums[index-2] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
