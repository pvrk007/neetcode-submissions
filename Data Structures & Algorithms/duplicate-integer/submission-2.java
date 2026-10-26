class Solution {
    public boolean hasDuplicate(int[] nums) {
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        for(int i: nums){
            if(ht.containsKey(i)){
                 return true;
            }
            ht.put(i,1);
        }
        return false;
    }
}