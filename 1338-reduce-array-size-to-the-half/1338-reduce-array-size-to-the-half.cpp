class Solution {
public:
   int minSetSize(vector<int>& arr) {
        unordered_map<int, int> countMap;
        priority_queue<int> countValues;
        
        for (int num : arr) countMap[num]++;
        for (auto pair: countMap) countValues.push(pair.second);    

        int size = arr.size(), result = 0;
        while (size > arr.size() / 2) {
            size -= countValues.top();
            countValues.pop();
            result++;
        }

        return result;
    }
};