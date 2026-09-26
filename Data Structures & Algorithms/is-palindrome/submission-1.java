class Solution {
    public boolean isPalindrome(String s) {
        
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        s= s.toLowerCase();
        
        String str= new StringBuilder(s).reverse().toString();

        if(s.equals(str)){
            return true;
        }
        else{
            return false;
        }
    }
}
