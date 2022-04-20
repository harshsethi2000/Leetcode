class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int,int> m;
        for(int i=0;i<tasks.size();i++)
        {
            m[tasks[i]]++;
        }
        int count=0;
        for(auto &i:m)
        {
            int elem=i.first;
            int frequency=i.second;
            if(frequency==1)return -1;
            else if(frequency%3==0)count+=frequency/3;
            else count+=(frequency/3)+1;
        }
        return count;
        
    }
};