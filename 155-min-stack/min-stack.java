class MinStack {

    class Pair{
        int value;
        int min;

        Pair(int value,int min){
            this.value = value;
            this.min = min;
        }
    }

    Stack<Pair>st;
    public MinStack() {
        st = new Stack<>();;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }else{
            int currentMin = Math.min(val,st.peek().min);
            st.push(new Pair(val,currentMin));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().value;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */