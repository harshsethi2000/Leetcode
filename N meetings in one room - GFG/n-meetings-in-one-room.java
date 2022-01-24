// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Meeting
{
    public int start;
    public int end;
    public int order;
    public Meeting(int start,int end,int order)
    {
        this.start=start;
        this.end=end;
        this.order=order;
    }
}
class MeetingComparator implements Comparator<Meeting>
{
   public int compare(Meeting m1,Meeting m2)
   {
       if(m1.end!=m2.end)return m1.end-m2.end;
       // end time is samesort based on order
       else return m1.order-m2.order;
   }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    /*
    Logic -
        1. SOrt the array on the basis of end time.
        2. initially ans=1 since 1 meeting can always occur.
        3. limit= end[0]
        4. Iterate from 1 to n-1 if start[i]>limit then meeting can occur update limit and count.
        5. else skip
        */
    
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            Meeting m=new Meeting(start[i],end[i],i+1);
            list.add(m);
        }
        //sort the arrayList
       MeetingComparator cmp =new MeetingComparator(); 
        Collections.sort(list,cmp);
        int count=1;
        int limit=(list.get(0)).end;
        for(int i=1;i<n;i++)
        {
            if(list.get(i).start > limit)
            {
                count++;
                limit=(list.get(i)).end;
            }
        }
        
        return count;
        
    }
}
