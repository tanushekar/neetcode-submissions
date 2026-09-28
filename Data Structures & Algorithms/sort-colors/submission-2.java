class Solution {
    public void sortColors(int[] nums) {
        // dutch national flag algo
        int n= nums.length;
        int i=0;
        int j=0;
        int k= n-1;

        while(j<=k) {
            if(nums[j]==0){
                swap(nums, j, i);
                j++;
                i++;
            }
            else if(nums[j]==2){
                swap(nums, j, k);
                k--;
            }
            else if(nums[j]==1){
                j++;
            }
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}