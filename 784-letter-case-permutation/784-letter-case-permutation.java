class Solution {
   public void helper(List<String> res, int index, char[] str) {
        if(index == str.length) {
            res.add(new String(str));
        } else {
            if(Character.isLetter(str[index])) {
                str[index] = Character.toUpperCase(str[index]);
                helper(res, index+1, str);
                str[index] = Character.toLowerCase(str[index]);
            }
            helper(res, index+1, str);
        }
        
    }
    
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(res, 0, S.toCharArray());
        return res;
    }
}