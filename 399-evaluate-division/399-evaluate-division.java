class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build graph
       Map<String,Map<String,Double>> graph= buildGraph(equations,values);
      
       // ans array with query size 
       double[] ans= new double[queries.size()];
       int i=0;
       
        // for every query, we are setting ans
        for(List<String> query : queries){
           Set<String> visited = new HashSet(); 
           // corner case
            if(query.get(0).equals(query.get(1))){
               if(graph.containsKey(query.get(0))){
                 ans[i]=1.0;  
               }else{
                   ans[i]=-1.0;  
               }
               i++;
               continue;
           }
           
            ans[i]=DFS(graph, visited, query.get(0), query.get(1)); 
            i++;
       }
        return ans;
    }
    
    
    private Map<String,Map<String,Double>> buildGraph(List<List<String>> equations,double[] values){
        Map<String,Map<String,Double>> graph = new HashMap();
        int i=0;
        for(List<String> list : equations){
            String firstEl= list.get(0);
            String secondEl= list.get(1);
            double value= values[i];
            
            graph.putIfAbsent(firstEl, new HashMap());
            graph.get(firstEl).put(secondEl,value);
            
            graph.putIfAbsent(secondEl, new HashMap());
            graph.get(secondEl).put(firstEl,1/value);
            i++;
        }
        return graph;
    }
    
    
    private double DFS(Map<String,Map<String,Double>> graph,Set<String> visited,String source,String destination){
       
        //if any of them is not in the graph
        if(!graph.containsKey(source) || !graph.containsKey(destination)){
            return -1.0;
        }
        
        //if src and destination is equal
        // if edge connect with both vertices
        // example for (a,b) source(a) and destination(b)
        // a in map key and b in map value key with weight
        if(graph.get(source).containsKey(destination)){
            return graph.get(source).get(destination);
        }
        
       //add to visited set 
       visited.add(source);
        
        //go to next node of source
        for(Map.Entry<String, Double> entry: graph.get(source).entrySet()){
           //check that is it already visited set contains the key
            if(!visited.contains(entry.getKey())){
                double value=DFS(graph,visited,entry.getKey(),destination);
                if(value!=-1.0){
                    return value*entry.getValue();
                }
            }
        }
        return -1.0;
    }
}