class Solution {
    public int jump(int[] nums) {
	if (nums == null || nums.length == 0)
		return 0;
 
	int lastReach = 0;
	int reach = 0;
	int step = 0;
 
	for (int i = 0; i <= reach && i < nums.length; i++) {
		if (i > lastReach) {
			step++;
			lastReach = reach;
		}
		reach = Math.max(reach, nums[i] + i);
	}
 
	if (reach < nums.length - 1)
		return 0;
 
	return step;
}
}