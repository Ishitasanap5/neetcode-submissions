class Solution {
    public int countComponents(int n, int[][] edges) {
        int connected = 0;
        List<List<Integer>> graph =  new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
                graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n;i++){
            if(!visited[i]){
                connected++;

            Queue<Integer> queue = new LinkedList<>();

            
        queue.offer(i);
        visited[i] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
             
            for(int neighbour:graph.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }

            }
        
        
        }
    }
    return connected;
}
}