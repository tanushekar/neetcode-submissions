class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();

        if(s.length() % 2 ==1) {
            return false;
        }
        for(char c: s.toCharArray()) {
            if(c=='(' || c=='[' || c=='{') {
                stack.push(c);
            }
            else if(!stack.empty() && c==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(!stack.empty() && c==']' && stack.peek()=='['){
                stack.pop();
            }
            else if(!stack.empty() && c=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else return false;
        }
        return stack.empty();
    }
}
