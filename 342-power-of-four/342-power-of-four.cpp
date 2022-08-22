class Solution {
public:
    //TC : O(N)
    // bool isPowerOfFour(int n) {
    //     if(n<=1)return false;
    //     while(n>1){
    //         if((n%4) != 0) return false;
    //         n = n/4;
    //     }
    //     return true;
    // }
    
    //TC : O(1)
     bool isPowerOfFour(int n) {
        
        // edge case
        
        if(n <= 0)
            return false;
        
        // this condition must be satisfied, if any number is power of 4
        
        if((n & (n - 1)) == 0 && (n - 1) % 3 == 0)
            return true;
        
        return false;
    }
};