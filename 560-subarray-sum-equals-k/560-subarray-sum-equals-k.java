class Solution {
    public int subarraySum(int[] nums, int k) {
  // The HashMap will store with the key being any particular sum, and the value being the number of times it has happened till the current iteration of the loop as we traverse the array from left to right.
//         Time Complexity - O(n)
//         Space Complexity -O(n)
            
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}