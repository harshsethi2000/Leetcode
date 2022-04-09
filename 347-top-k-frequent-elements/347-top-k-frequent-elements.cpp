class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int>v(k);    // ans vector to be return
        // to maintain freq of element
        unordered_map<int,int> map;
        for(auto i : nums){
            map[i]++;
        }
        // max priority queue which will hold value in decreasing order
        priority_queue<pair<int,int>> pq;
        unordered_map<int,int>:: iterator it = map.begin();
        while(it != map.end()){
            pq.push(make_pair(it->second, it->first));
            it++;
        }     
        // creating ans vector
        int i = 0;
        while(i < k){
            pair<int,int> top = pq.top();
            pq.pop();
            v[i++] = top.second;
        }
        return v;
    }
};