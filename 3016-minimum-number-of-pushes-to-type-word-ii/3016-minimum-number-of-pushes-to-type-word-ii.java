class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for(int i = 0; i < word.length(); i++){
            freq[word.charAt(i) - 'a']++;
        }
        int press = 0;
        Arrays.sort(freq);
        int left = 0;
        int right = freq.length-1;
        while(left < right){
            int temp = freq[left];
            freq[left] = freq[right];
            freq[right] = temp;
            left++;
            right--;
        }
        for(int i = 0; i < 26; i++){
            if(i <=7){
                press += freq[i];
            }
            else if(i > 7 && i <= 15){
                press += freq[i]*2;
            }
            else if(i > 15 && i <= 23){
                press += freq[i] * 3;
            }
            else{
                press+=freq[i]*4;
            }
        }
        return press;
    }
}