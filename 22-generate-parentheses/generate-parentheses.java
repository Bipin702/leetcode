class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int close = 0;
        solve(ans,n,sb,open,close);
        return ans;
    }

    public void solve(List<String> ans, int n, StringBuilder sb, int open , int close){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append("(");
            solve(ans,n,sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            solve(ans,n,sb,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}