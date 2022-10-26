// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        if(isBadVersion(1))
            return 1;
        int start = 1;
        int end = n;
        while(start<=end) {
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)) {
                if(isBadVersion(mid - 1)) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                start = mid + 1;
            }
        }
    return -1;
    }
};