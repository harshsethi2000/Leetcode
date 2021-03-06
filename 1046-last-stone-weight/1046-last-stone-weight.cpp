// class Solution {
// public:
//     int lastStoneWeight(vector<int>& stones) {
//         if(stones.size()==1)return stones[0];
//         sort(stones.begin(),stones.end());
        
//         while(stones.size()!=0 || stones.size()!=1)
//         {
//             int firstMaxIndex=stones.size()-1;
//             int secondMaxIndex=stones.size()-2;
//             if(stones[secondMaxIndex]==stones[firstMaxIndex])
//             {
//                 //remove both
//                 stones.erase(stones.begin()+firstMaxIndex);
//                 stones.erase(stones.begin()+secondMaxIndex);
//             }
//             else if(stones[secondMaxIndex]<stones[firstMaxIndex])
//             {
               
//                 stones[firstMaxIndex]-=stones[secondMaxIndex];
//                 stones.erase(stones.begin()+secondMaxIndex);
//             }
//             if(stones.size()==0|| stones.size()==1)break;
//             sort(stones.begin(),stones.end());
//         }
//         sort(stones.begin(),stones.end());
//         if(stones.size()==0)return 0;
//         return stones[0];
//         }
// };

class Solution {
public:
 int lastStoneWeight(vector<int>& stones) 
    {
        priority_queue<int> pq(stones.begin(),stones.end());
        while(pq.size()>1)
        {
            int y=pq.top();
            pq.pop();
            int x=pq.top();
            pq.pop();
            if(x!=y) pq.push(y-x);
        }
        return pq.empty()? 0 : pq.top();
    }
};

