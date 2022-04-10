class Solution {
public:
    int calPoints(vector<string>& ops) {
        vector<int> scores;
        for(auto i:ops)
        {
            if(i=="C")
            {
                scores.pop_back();
             }else if(i=="+")
            {
                scores.push_back(scores[scores.size()-1]+scores[scores.size()-2]);
            }else if(i=="D")
            {
                scores.push_back(scores[scores.size()-1]*2);
            }else
            {
                scores.push_back(stoi(i));
            }
        }
        int ans=0;
        for(auto i:scores)
        {
            ans+=i;
        }
        return ans;
    }
};