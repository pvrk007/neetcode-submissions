class Solution {
    public int longestConsecutive(int[] nums) {
    int ans=0;
    Set<Integer> set = new HashSet<>();
    for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
    }
    for(int num: nums){
        if(!set.contains(num-1)){
            int length=1;
            while(set.contains(num+length)){
                length++;
            }
            ans=Math.max(length,ans);
        }  
    }
    return ans;
    }
}
