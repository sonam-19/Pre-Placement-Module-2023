class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        LinkedList<int[]> link = new LinkedList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            if (link.isEmpty() || link.getLast()[1] <= intervals[i][0]) {
                link.add(intervals[i]);
            }
        }
        return intervals.length - link.size();
    }
}

