class Solution {
public:
    int findDuplicate(vector<int>& x) {
      int slow =x[0];
      int fast =x[0];
      do
      {
         slow=x[slow];
         fast=x[x[fast]]; 
      } while (slow!=fast);
      slow = x[0];
      while(slow!=fast)
      {
          slow=x[slow];
          fast=x[fast];
      }
      return slow;
    }
};