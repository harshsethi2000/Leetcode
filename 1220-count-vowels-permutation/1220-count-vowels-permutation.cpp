// class Solution {
// public:
//     //Recursion Solution
//     // int countVowelPermutation(int n) {
//     // unordered_map<char, vector<char>> map {
//     //     {'s', {'a', 'e', 'i', 'o', 'u'}},
//     //     {'a', {'e'}},
//     //     {'e', {'a', 'i'}},
//     //     {'i', {'a', 'e', 'o', 'u'}},
//     //     {'o', {'i', 'u'}},
//     //     {'u', {'a'}}
//     // };
//     //     return helper(n, 's', map);
//     // }
//     // int helper(int idx, char prev, unordered_map<char, vector<char> > &map) {
//     //     if(idx == 0)return 1;
//     //     int ans = 0;
//     //     for(auto i :  map.at(prev)){
//     //         ans += helper(idx - 1, i, map);
//     //     }
//     //     return ans;  
//     // }
    
  
// };
class Solution {
    const int MOD = 1e9 + 7;   
    const vector<vector<int>> mappings{{1}, {0,2}, {0,1,3,4}, {2,4}, {0}, {0,1,2,3,4}};
    
    public:
    
    int f(int idx, int prev, vector<vector<int>> &dp)
    {
        if(idx == 0)
            return 1;
        
        if(dp[prev][idx] != -1)
           return dp[prev][idx];
        
        dp[prev][idx] = 0;
        for(auto c : mappings[prev])
            dp[prev][idx] = (dp[prev][idx] + f(idx - 1, c, dp)) % MOD;  
        
        return (dp[prev][idx]);
    }
    
    int countVowelPermutation(int n) {
        vector<vector<int>> dp(6, vector<int> (n+1, -1));
        int ans = f(n, 5, dp);
        return ans;
    }
};