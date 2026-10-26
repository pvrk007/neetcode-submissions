class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Queue<Integer> pq = new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        for(int i: map.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        for(int i=0;i<=k-1;i++){
           ans[i]=pq.poll();
           System.out.println(ans[i]);
        }
        return ans;
}
}
