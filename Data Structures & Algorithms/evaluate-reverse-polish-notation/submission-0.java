class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();

        for(String c: tokens) {
            if(c.equals("+")) {
                stack.push(stack.pop()+stack.pop());
            }
            else if(c.equals("-")){
                //sub and div--> order sensitive!
                int b= stack.pop(); // top--> second operand
                int a= stack.pop();
                stack.push(a-b);
            }
            else if(c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if(c.equals("/")) {
                // top--> b
                // a/b
                int b= stack.pop();
                int a= stack.pop();
                stack.push(a/b);
            }
            else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop(); // last ele remaining= final result
    }
}
