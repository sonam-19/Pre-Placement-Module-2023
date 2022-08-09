class Solution {
  List<List<Integer>> paths;
    List<Integer> path;
    
    public void dfs(int[][] graph, int curr) {
        path.add(curr);
        if (curr == (graph.length-1)) {
            paths.add(new ArrayList<>(path));
        } else {
            for(int node:graph[curr])
                dfs(graph,node);
        }   
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList();
        path = new ArrayList();
        dfs(graph,0);
        return paths;
    }
}