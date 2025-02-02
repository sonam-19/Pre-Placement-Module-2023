class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int num1Len = num1.length();
        int num2Len = num2.length();
        int t;
        int[] res = new int[num1Len + num2Len];
        for (int i = num1Len - 1; i >= 0; i--) {
            for (int j = num2Len - 1, r = num1Len - 1 - i; j >= 0; j--, r++) {
                res[r] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                if (res[r] > 9) {
                    t = res[r];
                    res[r] = t % 10;
                    res[r + 1] += t / 10 % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (sb.length() == 0 && res[res.length - 1 - i] == 0) {
                continue;
            }
            sb.append(res[res.length - 1 - i]);
        }
        return sb.toString();
    }
}