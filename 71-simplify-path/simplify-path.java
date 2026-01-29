class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();

        for(String comp : arr){
            if(comp.equals("") || comp.equals(".")){
                continue;
            }

            if(comp.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(comp);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.insert(0,"/"+st.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}