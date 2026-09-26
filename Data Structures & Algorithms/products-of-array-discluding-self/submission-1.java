class Solution {
    public int[] productExceptSelf(int[] nums) {
        //using left prefix and right postfix products
        //O(3N)= o(n)

        int n= nums.length;

        int[] left= new int[n];

        int[] right= new int[n];


        left[0]= 1;
        for(int i=1; i<n; i++) {
            left[i]= left[i-1] * nums[i-1];
        }

        right[n-1]=1;
        for(int i=n-2; i> -1; i--) {
            right[i]= right[i+1] * nums[i+1];
        }

        int[] result= new int[n];
        for(int i=0; i<n; i++){
            result[i]= left[i] * right[i];
        }

        return result;

        /* O(n^2)
        int[] res= new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int product=1;
            for(int j=0; j<nums.length; j++){
                if(i!=j){
                    product= product*nums[j];
                }
            }
            res[i]= product;
        }
        return res;
        */
    }
}  
