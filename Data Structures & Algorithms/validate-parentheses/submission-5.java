class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();

        HashMap<Character, Character> map= new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char c: s.toCharArray()){

            if(map.containsKey(c)){
                if(!stack.isEmpty() && stack.peek()==map.get(c)) {
                    stack.pop();
                }
                else{
                    return false;
                }
            }

            else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
        /*
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
        */

    }
}
