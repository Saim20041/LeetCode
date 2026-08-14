class Solution {
    public int maximumLengthSubstring(String s) {
        int arr[] = new int[26];
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            arr[ch - 'a']++;
            if (arr[ch - 'a'] > 2) {
                while(arr[ch - 'a'] > 2){
                    arr[s.charAt(left) - 'a']--;
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}