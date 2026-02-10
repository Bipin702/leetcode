class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solve(ans,n,sb);
        return ans;
    }

    public void solve(List<String> ans, int n, StringBuilder sb){
        if(sb.length() == 2*n){
            if(isValid(sb.toString()))
            ans.add(sb.toString());
            return;
        }

        sb.append("(");
        solve(ans,n,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        solve(ans,n,sb);
        sb.deleteCharAt(sb.length()-1);
    }

    public boolean isValid(String str){
        Stack<Character> st = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        if(st.isEmpty()) return true;

        return false;
    }
}