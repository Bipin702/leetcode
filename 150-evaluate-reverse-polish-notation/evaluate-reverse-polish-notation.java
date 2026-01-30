class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (String str : tokens) {

            if (str.equals("+") || str.equals("*") ||
                str.equals("-") || str.equals("/")) {

                int b = st.pop();
                int a = st.pop(); 

                int result = operation(a, b, str);
                st.push(result);

            } else {
                st.push(Integer.parseInt(str));
            }
        }

        return st.pop();
    }

    public int operation(int a, int b, String operator) {

        if (operator.equals("+")) {
            return a + b;

        } else if (operator.equals("-")) {
            return a - b;

        } else if (operator.equals("*")) {
            return a * b;

        } else {
            return a / b;
        }
    }
}
