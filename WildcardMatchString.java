class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        if (m==0){
            if (n==0){
                return true;
            }
            return false;
        }
        if (n==0){
            for (int i = 0;i<m;i++){
                if (p.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        for (int i = 0;i<dp.length;i++){
            if (i==0 && s.charAt(i) == p.charAt(0)){
                dp[0][0] = 1;
            }
            if (i==0 && p.charAt(0)=='?'){
                dp[0][0] = 1;
            }
            if (p.charAt(0)=='*'){
                dp[i][0] = 1;
            }
        }
        int matched = 0;
        for (int i = 1;i<dp[0].length;i++){
            if (dp[0][0]==0){
                break;
            }
            if (p.charAt(0)=='*'){
                if (p.charAt(i)=='*'){
                    dp[0][i] = 1;
                }
                if (p.charAt(i)=='?' && matched ==0){
                    dp[0][i] = 1;
                    matched = 1;
                    
                }
                if (p.charAt(i)==s.charAt(0) && matched==0){
                    dp[0][i] = 1;
                    matched = 1;
                }
                if (dp[0][i]==0){
                    break;
                }
            }
            else {
                if (p.charAt(i)=='*'){
                    dp[0][i] = 1;
                }
                else {
                    break;
                }
            }
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = 1;j<dp[0].length;j++){
                if (p.charAt(j)==s.charAt(i)){
                    dp[i][j] = dp[i-1][j-1];

                }
                if (p.charAt(j)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j)=='*'){
                    if (dp[i][j-1]==1){
                        dp[i][j] = 1;
                    }
                    if (dp[i-1][j]==1){
                        dp[i][j] = 1;
                    }
                    if (dp[i-1][j-1]==1){
                        dp[i][j] = 1;
                    }
                }
            }
        }
        if (dp[n-1][m-1]==1){
            return true;
        }
        return false;
    }
}
