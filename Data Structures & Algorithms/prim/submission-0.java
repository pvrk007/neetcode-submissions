class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i=1;i<n+1;i++) {
            adj.put(i, new ArrayList<Integer[]>());
        }
        for (List<Integer> edge: edges) {
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            int weight = edge.get(2);
            adj.putIfAbsent(n1, new ArrayList<Integer[]>());
            adj.putIfAbsent(n2, new ArrayList<Integer[]>());
            adj.get(n1).add(new Integer[] {n2, weight});
            adj.get(n2).add(new Integer[] {n1, weight});            
        }

        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2)->(n1[0]-n2[0]));
        for(Integer[] neighbor : adj.get(0)) {
            int node = neighbor[0], weight = neighbor[1];
            minHeap.add(new int[]{weight, 0, node});
        }
        int totalWeight = 0;
        HashSet<Integer> visit = new HashSet<>();
        visit.add(0);
        while(visit.size()<n && !minHeap.isEmpty()){
            int[] cur = minHeap.remove();
            int w1 = cur[0], n1 = cur[1], n2=cur[2];
            if(visit.contains(n2)) {
                continue;
            }
            totalWeight+=w1;
            visit.add(n2);
            for(Integer[] pair: adj.get(n2)) {
                Integer neighbor = pair[0], weight=pair[1];
                if(!visit.contains(neighbor)) {
                    minHeap.add(new int[]{weight, n2, neighbor});
                }
            }
        }
        return visit.size()==n? totalWeight:-1;
    }
}    
