public class Solution {

    public List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.size(); i++) {
            List<Integer> newNums = (List<Integer>)((ArrayList)nums).clone();
            newNums.remove(i);
            List<List<Integer>> subLst = permute(newNums);
            if(subLst.isEmpty()) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(nums.get(i));
                lst.add(l);
            } else {
                for(List<Integer> l : subLst) {
                    l.add(nums.get(i));
                    lst.add(l);
                }
            }
            while(i<nums.size()-1 && nums.get(i+1).equals(nums.get(i))) i++;
        }
        return lst;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numsLst = new ArrayList<Integer>();
        for(int i : nums)
            numsLst.add(i);
        return permute(numsLst);
    }
}