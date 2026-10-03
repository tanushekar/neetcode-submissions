class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();

        List<Integer>[] freq= new List[nums.length+1]; // 0 to 6 freq for len=6

        for(int i=0; i<freq.length; i++) {
            freq[i]= new ArrayList<>();
        }

        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        // for every value(freq) in hashmap --> add key(number) to freq array in the form of list

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            // freq[count].add[key]

            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result= new int[k];   // for top k elements

        int index=0;

        for(int i=freq.length-1; i > 0  ; i--) {
            for(int n: freq[i]) {
                result[index]= n;
                index++;
                if(index==k) {
                    return result;
                }
            }
        }
        return result;

    }
}
