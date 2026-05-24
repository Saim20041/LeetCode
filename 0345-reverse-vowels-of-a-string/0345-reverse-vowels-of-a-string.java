class Solution {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        char arr[] = s.toCharArray();
        while(left < right){
            if(!"aeiouAEIOU".contains(String.valueOf(arr[left]))){
                left++;
            }
            else if(!"aeiouAEIOU".contains(String.valueOf(arr[right]))){
                right--;
            }
            else{
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
                left++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        String res = sb.toString();
        return res;
    }
}