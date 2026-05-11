class Solution {
    public int[] separateDigits(int[] nums) {
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length;i++){
            String str = String.valueOf(nums[i]);
            for(int j = 0; j < str.length(); j++){
                list.add(str.charAt(j));
            }
        }  
        int arr[] = new int[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i) - '0';
        }

        
        return arr;
    }
}