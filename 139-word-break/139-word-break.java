class Solution {
       public boolean wordBreak(String s, List<String> wordDict) {
        //base case
        if(s == null || s.length() == 0) return false;
        boolean[] M = new boolean[s.length() + 1];
        M[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; --i) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < s.length(); ++j) {
                sb.append(s.charAt(j));
                if(wordDict.contains(sb.toString()) && M[j + 1]) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[0];
       }
}