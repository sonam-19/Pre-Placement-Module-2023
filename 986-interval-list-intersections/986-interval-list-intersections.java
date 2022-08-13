class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int ia = 0, ib = 0;
        
        while (ia < A.length && ib < B.length) {
            int a0 = A[ia][0], a1 = A[ia][1];
            int b0 = B[ib][0], b1 = B[ib][1];
            
            if (a0 > b1) {
                ib++;
                continue;
            }
            if (b0 > a1) {
                ia++;
                continue;
            }
            
            ans.add(new int[]{Math.max(a0, b0), Math.min(a1, b1)});
            
            if (a1 > b1) ib++;
            else ia++;
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}